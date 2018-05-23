package pl.stockWinner.models.entity;

import pl.stockWinner.models.dto.CompanyDTO;

import javax.persistence.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String symbol;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String exchange;

    @Column(nullable = false)
    private String industry;

    @Column
    private String website;

    @Column
    private String description;

    @Column
    private String CEO;

    @Column
    private String issueType;

    @Column
    private String sector;

    public Company() {
    }

    public Company(String symbol, String companyName, String exchange, String industry, String website, String description, String CEO, String issueType, String sector) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.exchange = exchange;
        this.industry = industry;
        this.website = website;
        this.description = description;
        this.CEO = CEO;
        this.issueType = issueType;
        this.sector = sector;
    }

    public Company build() {
        return this;
    }

    public Long getId() {
        return id;
    }

    public Company setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSymbol() {
        return symbol;
    }

    public Company setSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Company setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getExchange() {
        return exchange;
    }

    public Company setExchange(String exchange) {
        this.exchange = exchange;
        return this;
    }

    public String getIndustry() {
        return industry;
    }

    public Company setIndustry(String industry) {
        this.industry = industry;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public Company setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Company setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCEO() {
        return CEO;
    }

    public Company setCEO(String CEO) {
        this.CEO = CEO;
        return this;
    }

    public String getIssueType() {
        return issueType;
    }

    public Company setIssueType(String issueType) {
        this.issueType = issueType;
        return this;
    }

    public String getSector() {
        return sector;
    }

    public Company setSector(String sector) {
        this.sector = sector;
        return this;
    }
}
