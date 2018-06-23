export class Currency {
  private _name: string;
  private _rate: number;
  private _lastUpdate: Date;

  constructor(name: string, rate: number, lastUpdate: Date) {
    this._name = name;
    this._rate = rate;
    this._lastUpdate = lastUpdate;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get rate(): number {
    return this._rate;
  }

  set rate(value: number) {
    this._rate = value;
  }

  get lastUpdate(): Date {
    return this._lastUpdate;
  }

  set lastUpdate(value: Date) {
    this._lastUpdate = value;
  }

  public static fromJSON(jsonObj: any): Currency{
    return new Currency(jsonObj.name, +jsonObj.rate, new Date(jsonObj.lastUpdate));
  }

  public toJSON() {
    return {
      name: this.name,
      rate: this.rate,
      lastUpdate: this.lastUpdate
    }
  }
}
