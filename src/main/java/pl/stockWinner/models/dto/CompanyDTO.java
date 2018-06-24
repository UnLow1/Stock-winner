package pl.stockWinner.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CompanyDTO {
    private Long id;

    @NotNull
    @Size(max = 255)
    private String symbol;

    @NotNull
    @Size(max = 255)
    private String companyName;

    @NotNull
    @Size(max = 255)
    private String exchange;

    @NotNull
    @Size(max = 255)
    private String industry;

    @Size(max = 255)
    private String website;

    @Size(max = 255)
    private String description;

    @Size(max = 255)
    private String CEO;

    @Size(max = 255)
    private String issueType;

    @Size(max = 255)
    private String sector;

    public CompanyDTO() {
    }

    public CompanyDTO build() {
        return this;
    }

    public Long getId() {
        return id;
    }

    public CompanyDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public CompanyDTO setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public CompanyDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getExchange() {
        return exchange;
    }

    public CompanyDTO setExchange(String exchange) {
        this.exchange = exchange;
        return this;
    }

    public String getIndustry() {
        return industry;
    }

    public CompanyDTO setIndustry(String industry) {
        this.industry = industry;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public CompanyDTO setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCEO() {
        return CEO;
    }

    public CompanyDTO setCEO(String CEO) {
        this.CEO = CEO;
        return this;
    }

    public String getIssueType() {
        return issueType;
    }

    public CompanyDTO setIssueType(String issueType) {
        this.issueType = issueType;
        return this;
    }

    public String getSector() {
        return sector;
    }

    public CompanyDTO setSector(String sector) {
        this.sector = sector;
        return this;
    }
}
