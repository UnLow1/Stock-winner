export interface IChart {
  high: number;
  low: number;
  volume: number;
  label: number;
  changeOverTime: number;
  date: string;
  open: number;
  close: number;
}

export class Chart {

  public high: number = 0;
  public low: number = 0;
  public volume: number = 0;
  public label: number = 0;
  public changeOverTime: number = 0;
  public date: string = '';
  public open: number = 0;
  public close: number = 0;

  constructor() {
  }

  public toJSON(): string {
    return JSON.stringify({
      high: this.high,
      low: this.low,
      volume: this.volume,
      label: this.label,
      changeOverTime: this.changeOverTime,
      date: this.date,
      open: this.open,
      close: this.close
    });
  }
}
