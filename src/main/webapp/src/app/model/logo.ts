export interface ILogo {
  url: string;
}

export class Logo {

  public url: string = '';

  constructor() {}

  public toJSON(): string {
    return JSON.stringify({
      url: this.url
    });
  }
}
