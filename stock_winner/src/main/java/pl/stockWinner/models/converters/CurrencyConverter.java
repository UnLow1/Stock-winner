package pl.stockWinner.models.converters;

import org.springframework.stereotype.Component;
import pl.stockWinner.models.dto.CurrencyDto;
import pl.stockWinner.models.entity.Currency;

@Component
public class CurrencyConverter implements BaseConverter<Currency, CurrencyDto> {

    @Override
    public CurrencyDto convertFromEntity(Currency entity) {
        CurrencyDto currencyDto = new CurrencyDto();

        currencyDto.setId(entity.getId());
        currencyDto.setName(entity.getName());
        currencyDto.setRate(entity.getRate());
        currencyDto.setLastUpdate(entity.getLastUpdate());

        return currencyDto;
    }

    @Override
    public Currency convertFromDto(CurrencyDto dto) {
        Currency currency = new Currency();

        currency.setId(dto.getId());
        currency.setName(dto.getName());
        currency.setRate(dto.getRate());
        currency.setLastUpdate(dto.getLastUpdate());

        return currency;
    }
}
