package pl.stockWinner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.stockWinner.models.dto.CurrencyDto;
import pl.stockWinner.services.CurrencyService;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("api/currencies")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;


    @GetMapping(value = "/all")
    public ResponseEntity<Collection<CurrencyDto>> addAllCurrencies() throws IOException {
        return ResponseEntity.ok(currencyService.addAllCurrencies());

    }

    @GetMapping
    public ResponseEntity<Collection<CurrencyDto>> getCurrencies() {
        return ResponseEntity.ok(currencyService.getCurrencies());
    }

    @PostMapping(params = {"currencyName"})
    public ResponseEntity<Void> addCurrency(@RequestParam(value = "currencyName") String name) throws IOException {
        currencyService.addCurrency(name);

        return ResponseEntity.created(URI.create("/list-currencies")).build();
    }

    @DeleteMapping(params = {"currencyName"})
    public ResponseEntity<Void> deleteCurrency(@RequestParam(value = "currencyName") String name) {
        currencyService.deleteCurrency(name);

        return ResponseEntity.created(URI.create("/list-currencies")).build();
    }


}