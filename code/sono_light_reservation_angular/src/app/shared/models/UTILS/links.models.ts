export class Link {
  private _name: string;
  private _link: string;
  constructor(name: string, link: string) {
    (this._name = name), (this._link = link);
  }

  /**
   * Getter name
   * @return {string}
   */
  public get name(): string {
    return this._name;
  }

  /**
   * Setter name
   * @param {string} value
   */
  public set name(value: string) {
    this._name = value;
  }

  /**
   * Getter link
   * @return {string}
   */
  public get link(): string {
    return this._link;
  }

  /**
   * Setter link
   * @param {string} value
   */
  public set link(value: string) {
    this._link = value;
  }
}
