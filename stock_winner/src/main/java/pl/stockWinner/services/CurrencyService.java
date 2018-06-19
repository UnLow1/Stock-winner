package pl.stockWinner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stockWinner.models.converters.CurrencyConverter;
import pl.stockWinner.models.dto.CurrencyDto;
import pl.stockWinner.models.entity.Currency;
import pl.stockWinner.repositories.CurrencyRepository;

import java.util.Collection;
import java.util.List;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyConverter currencyConverter;

    public Collection<CurrencyDto> getCurrencies() {
        List<Currency> currencyList = currencyRepository.findAll();

        return currencyConverter.convertFromEntities(currencyList);
    }
}
