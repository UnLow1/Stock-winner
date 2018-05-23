package pl.stockWinner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stockWinner.models.converters.CompanyConverter;
import pl.stockWinner.models.dto.CompanyDTO;
import pl.stockWinner.models.entity.Company;
import pl.stockWinner.repositories.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyConverter companyConverter;

    public CompanyDTO getCompanyById(Long id) {
        return companyConverter.convertFromEntity(companyRepository.getById(id).get());
    }

    public Company createCompany(final CompanyDTO companyDTO) {
        return companyRepository.save(companyConverter.convertFromDto(companyDTO));
    }


}
