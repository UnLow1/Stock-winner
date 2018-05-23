package pl.stockWinner.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.stockWinner.models.dto.CompanyDTO;
import pl.stockWinner.models.entity.Company;
import pl.stockWinner.services.CompanyService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("stock")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        Company company = companyService.createCompany(companyDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/AAPL/company")
                .buildAndExpand(company.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/AAPL/company")
    public ResponseEntity<CompanyDTO> getCompany(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompanyById(id));
    }
}
