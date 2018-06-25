package pl.stockWinner.models.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.stockWinner.models.dto.CurrencyDto;
import pl.stockWinner.models.dto.CurrencyPersonalDto;
import pl.stockWinner.models.entity.Currency;
import pl.stockWinner.models.entity.CurrencyPersonalEntity;
import pl.stockWinner.repositories.CurrencyRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CurrencyPersonalConverter implements BaseConverter<CurrencyPersonalEntity, CurrencyPersonalDto> {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyConverter currencyConverter;

    @Override
    public CurrencyPersonalDto convertFromEntity(CurrencyPersonalEntity entity) {
        Currency currency = currencyRepository.findById(entity.getCurrencyEntityId()).get();

        double amount = entity.getAmount();
        double rate = entity.getRate();
        CurrencyPersonalDto currencyPersonalDto = new CurrencyPersonalDto();
        currencyPersonalDto.setAmount(amount);
        currencyPersonalDto.setRate(rate);
        currencyPersonalDto.setBasePrice(rate);
        // TODO change it to current price
        currencyPersonalDto.setCurrentPrice(rate);
        currencyPersonalDto.setName(currency.getName());
        currencyPersonalDto.setValue(rate * amount);

        return currencyPersonalDto;
    }

    @Override
    public CurrencyPersonalEntity convertFromDto(CurrencyPersonalDto dto) {
        return null;
    }

    @Override
    public Collection<CurrencyPersonalDto> convertFromEntities(Collection<CurrencyPersonalEntity> entities) {
        return entities.stream()
                .map(this::convertFromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<CurrencyPersonalEntity> convertFromDtos(Collection<CurrencyPersonalDto> dtos) {
        return null;
    }
}
