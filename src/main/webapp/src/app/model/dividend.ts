export interface IDividend {
  exDate: string;
  paymentDate: string;
  recordDate: string;
  declaredDate: string;
  amount: number;
  flag: string;
  type: string;
  qualified: string;
  indicated: number;
}

export class Dividend {
  public exDate: string = '';
  public paymentDate: string = '';
  public recordDate: string = '';
  public declaredDate: string = '';
  public amount: number = 0;
  public flag: string = '';
  public type: string = '';
  public qualified: string = '';
  public indicated: number = 0;

  constructor() {}

  public toJSON(): string {
    return JSON.stringify({
      exDate: this.exDate,
      paymentDate: this.paymentDate,
      recordDate: this.recordDate,
      declaredDate: this.declaredDate,
      amount: this.amount,
      flag: this.flag,
      type: this.type,
      qualified: this.qualified,
      indicated: this.indicated
    });
  }
}
