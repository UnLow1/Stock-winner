export interface ICompany {
  symbol: string;
  companyName: string;
  exchange: string;
  industry: string;
  website: string;
  description: string;
  CEO: string;
  issueType: string;
  sector: string;
}

export class Company {

  public symbol: string = '';
  public companyName: string = '';
  public exchange: string = '';
  public industry: string = '';
  public website: string = '';
  public description: string = '';
  public CEO: string = '';
  public issueType: string = '';
  public sector: string = '';

  constructor() {
  }

  public toJSON(): string {
    return JSON.stringify({
      symbol: this.symbol,
      companyName: this.companyName,
      exchange: this.exchange,
      industry: this.industry,
      website: this.website,
      description: this.description,
      CEO: this.CEO,
      issueType: this.issueType,
      sector: this.sector
    });
  }
}
