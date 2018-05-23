package pl.stockWinner.models.converters;

import org.springframework.stereotype.Component;
import pl.stockWinner.models.dto.CompanyDTO;
import pl.stockWinner.models.entity.Company;

@Component
public class CompanyConverter implements BaseConverter<Company, CompanyDTO> {

    @Override
    public CompanyDTO convertFromEntity(Company entity) {
        CompanyDTO companyDTO = new CompanyDTO()
                .build()
                .setId(entity.getId())
                .setSymbol(entity.getSymbol())
                .setCompanyName(entity.getCompanyName())
                .setExchange(entity.getExchange())
                .setIndustry(entity.getIndustry())
                .setWebsite(entity.getWebsite())
                .setDescription(entity.getDescription())
                .setCEO(entity.getCEO())
                .setIssueType(entity.getIssueType())
                .setSector(entity.getSector());

        return companyDTO;
    }

    @Override
    public Company convertFromDto(CompanyDTO dto) {
        Company company = new Company()
                .build()
                .setId(dto.getId())
                .setSymbol(dto.getSymbol())
                .setCompanyName(dto.getCompanyName())
                .setExchange(dto.getExchange())
                .setIndustry(dto.getIndustry())
                .setWebsite(dto.getWebsite())
                .setDescription(dto.getDescription())
                .setCEO(dto.getCEO())
                .setIssueType(dto.getIssueType())
                .setSector(dto.getSector());

        return company;
    }
}