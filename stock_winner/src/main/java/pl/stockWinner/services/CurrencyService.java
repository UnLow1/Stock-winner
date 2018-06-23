package pl.stockWinner.services;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stockWinner.models.converters.CurrencyConverter;
import pl.stockWinner.models.dto.CurrencyDto;
import pl.stockWinner.models.entity.Currency;
import pl.stockWinner.repositories.CurrencyRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    final static String BASE_CURRENCY = "PLN";
    final static String BASE_URL = "https://free.currencyconverterapi.com/api/v5/convert?q=" + BASE_CURRENCY + "_";
    final static String COMPACT = "&compact=ultra";

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyConverter currencyConverter;

    public Collection<CurrencyDto> getCurrencies() {
        List<Currency> currencyList = currencyRepository.findAll();

        return currencyConverter.convertFromEntities(currencyList);
    }

    // Problem is that API give us ban after 100 requests in hour
    public Collection<CurrencyDto> addAllCurrencies() throws IOException {
        Iterator<String> currenciesNames = getCurrenciesNames();
        currenciesNames.forEachRemaining(name -> {
            try {
                double rate = getRateForCurrency(name);

                CurrencyDto currencyDto = new CurrencyDto(name, rate, new Timestamp(System.currentTimeMillis()));

                Currency currency = currencyConverter.convertFromDto(currencyDto);
                currencyRepository.save(currency);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return null;
    }

    public void addCurrency(String name) throws IOException {
        double rate = getRateForCurrency(name);

        CurrencyDto currencyDto = new CurrencyDto(name, rate, new Timestamp(System.currentTimeMillis()));

        Currency currency = currencyConverter.convertFromDto(currencyDto);
        currencyRepository.save(currency);
    }

    public void deleteCurrency(String name) {
        Optional<Currency> currencyToDelete = currencyRepository.findByName(name);

        currencyToDelete.ifPresent(currency -> currencyRepository.delete(currency));
    }

    private Iterator<String> getCurrenciesNames() throws IOException {
        JSONObject response;
        response = readResponseFromApi("https://free.currencyconverterapi.com/api/v5/currencies").getJSONObject("results");

        return response.keys();
    }

    private double getRateForCurrency(String name) throws JSONException, IOException {
        JSONObject response;
        response = readResponseFromApi(BASE_URL + name + COMPACT);

        if (response.length() == 0)
            throw new RuntimeException("Currency " + name + " is not available");

        return response.getDouble(BASE_CURRENCY + "_" + name);
    }

    private JSONObject readResponseFromApi(String url) throws IOException, JSONException {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null)
            response.append(inputLine);
        in.close();

        return new JSONObject(response.toString());
    }
}
