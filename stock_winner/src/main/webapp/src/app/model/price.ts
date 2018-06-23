export interface IPrice {
  price: number;
}

export class Price {

  public price: number = 0;

  constructor() {
  }

  public toJSON(): string {
    return JSON.stringify({
      price: this.price
    });
  }
}
