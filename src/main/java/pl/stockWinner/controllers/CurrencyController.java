package pl.stockWinner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.stockWinner.models.converters.CurrencyConverter;
import pl.stockWinner.models.dto.CurrencyDto;
import pl.stockWinner.models.dto.CurrencyPersonalDto;
import pl.stockWinner.models.entity.CurrencyPersonalEntity;
import pl.stockWinner.models.entity.UserEntity;
import pl.stockWinner.repositories.UserDataRepository;
import pl.stockWinner.services.CurrencyPersonalService;
import pl.stockWinner.services.CurrencyService;

import java.io.IOException;
import java.util.Collection;

@RestController
@RequestMapping("api/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CurrencyPersonalService currencyPersonalService;

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private CurrencyConverter currencyConverter;

    @GetMapping(value = "/all")
    public ResponseEntity<Collection<CurrencyDto>> addAllCurrencies() throws IOException {
        currencyService.addAllCurrencies();

        return ResponseEntity.ok(currencyService.getCurrencies());
    }

    @GetMapping(value = "/forUser")
    public ResponseEntity<Collection<CurrencyPersonalDto>> getCurrenciesForUser() {
//        currencyService.getCurrenciesForUser(getUserEntity());

        // TODO fix this
        return ResponseEntity.ok(currencyService.getCurrenciesForUser(getUserEntity()));
    }

    @GetMapping
    public ResponseEntity<Collection<CurrencyDto>> getCurrencies() {
        return ResponseEntity.ok(currencyService.getCurrencies());
    }

    @PostMapping(params = {"currencyName", "amount"})
    public ResponseEntity<Void> addToWallet(@RequestParam(value = "currencyName") String name,
                                            @RequestParam(value = "amount") int amount) {

        currencyPersonalService.create(currencyService.getCurrency(name), amount, getUserEntity());

        // TODO fix this
        return ResponseEntity.ok().build();
    }

    @PostMapping(params = {"currencyName"})
    public ResponseEntity<Collection<CurrencyDto>> addCurrency(@RequestParam(value = "currencyName") String name) throws IOException {
        currencyService.addCurrency(name);

        return ResponseEntity.ok(currencyService.getCurrencies());
    }

    @DeleteMapping(params = {"currencyName"})
    public ResponseEntity<Collection<CurrencyDto>> deleteCurrency(@RequestParam(value = "currencyName") String name) {
        currencyService.deleteCurrency(name);

        return ResponseEntity.ok(currencyService.getCurrencies());
    }

    @PutMapping
    public ResponseEntity<Collection<CurrencyDto>> updateCurrency(@RequestBody String name) throws IOException {
        currencyService.updateCurrency(name);

        return ResponseEntity.ok(currencyService.getCurrencies());
    }

    private UserEntity getUserEntity() {
        String userMail = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDataRepository.findFirstByUserMail(userMail);
    }
}