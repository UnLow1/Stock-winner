export interface IShare {
  ticker: string;
  volume: number;
  price: number;
  date: string;
}

export class Share {
  public ticker: string = '';
  public volume: number = 0;
  public price: number = 0;
  public date: string = '';

  constructor() {
  }

  public toJSON(): string {
    return JSON.stringify({
      ticker: this.ticker,
      volume: this.volume,
      price: this.price,
      date: this.date
    });
  }
}
