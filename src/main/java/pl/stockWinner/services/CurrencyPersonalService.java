package pl.stockWinner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stockWinner.models.entity.Currency;
import pl.stockWinner.models.entity.CurrencyPersonalEntity;
import pl.stockWinner.models.entity.UserEntity;
import pl.stockWinner.repositories.CurrencyPersonalRepository;

@Service
public class CurrencyPersonalService {

    @Autowired
    CurrencyPersonalRepository currencyPersonalRepository;

    public void create(Currency currency, double amount, UserEntity userEntity) {
        CurrencyPersonalEntity currencyPersonalEntity = new CurrencyPersonalEntity();

        currencyPersonalEntity.setCurrencyEntityId(currency.getId());
        currencyPersonalEntity.setUserEntity(userEntity);
        currencyPersonalEntity.setAmount(amount);
        currencyPersonalEntity.setRate(currency.getRate());

        currencyPersonalRepository.save(currencyPersonalEntity);

//        return currencyPersonalEntity;
    }
}
