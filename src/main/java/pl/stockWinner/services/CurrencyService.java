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
    final static String BASE_URL = "https://free.currencyconverterapi.com/api/v5";
    final static String CONVERT = "/convert?q=" + BASE_CURRENCY + "_";
    final static String COMPACT = "&compact=ultra";

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyConverter currencyConverter;

    public Collection<CurrencyDto> getCurrencies() {
        List<Currency> currencyList = currencyRepository.findAll();

        return currencyConverter.convertFromEntities(currencyList);
    }

    public Currency getCurrency(String name) {
        return currencyRepository.findByName(name).get();
    }

    // Problem is that API give us ban after 100 requests in hour
    public void addAllCurrencies() throws IOException {
        Iterator<String> currenciesNames = getCurrenciesNames();

        String[] currencies = new String[2];

        currenciesNames.forEachRemaining(name -> {
            if (currencies[0] == null)
                currencies[0] = name;
            else if (currencies[1] == null)
                currencies[1] = name;
            else {
                try {
                    double[] rates = getRatesForCurrencies(currencies[0], currencies[1]);

                    CurrencyDto currencyDto1 = new CurrencyDto(currencies[0], rates[0], new Timestamp(System.currentTimeMillis()));
                    CurrencyDto currencyDto2 = new CurrencyDto(currencies[1], rates[1], new Timestamp(System.currentTimeMillis()));

                    Currency currency1 = currencyConverter.convertFromDto(currencyDto1);
                    Currency currency2 = currencyConverter.convertFromDto(currencyDto2);

                    currencyRepository.save(currency1);
                    currencyRepository.save(currency2);

                    currencies[0] = null;
                    currencies[1] = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
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


    public void updateCurrency(String name) throws IOException {
        double rate = getRateForCurrency(name);

        Currency currency = currencyRepository.findByName(name).get();

        currency.setRate(rate);
        currency.setLastUpdate(new Timestamp(System.currentTimeMillis()));

        currencyRepository.save(currency);
    }

    private Iterator<String> getCurrenciesNames() throws IOException {
        JSONObject response;
        response = readResponseFromApi(BASE_URL + "/currencies").getJSONObject("results");

        return response.keys();
    }

    private double[] getRatesForCurrencies(String name1, String name2) throws JSONException, IOException {
        JSONObject response;
        response = readResponseFromApi(BASE_URL + CONVERT + name1 + "," + BASE_CURRENCY + "_" + name2 + COMPACT);

        if (response.length() != 2)
            throw new RuntimeException("Currency " + name1 + " or currency " + name2 + " is not available");

        return new double[]{response.getDouble(BASE_CURRENCY + "_" + name1), response.getDouble(BASE_CURRENCY + "_" + name2)};
    }

    private double getRateForCurrency(String name) throws JSONException, IOException {
        JSONObject response;
        response = readResponseFromApi(BASE_URL + CONVERT + name + COMPACT);

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
