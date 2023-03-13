export class SocialLinks {
  private _alt: string;
  private _link: string;
  private _image: string;
  constructor(alt: string, link: string, image: string) {
    this._alt = alt;
    this._link = link;
    this._image = image;
  }

  /**
   * Getter alt
   * @return {string}
   */
  public get alt(): string {
    return this._alt;
  }

  /**
   * Setter alt
   * @param {string} value
   */
  public set alt(value: string) {
    this._alt = value;
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

  /**
   * Getter image
   * @return {string}
   */
  public get image(): string {
    return this._image;
  }

  /**
   * Setter image
   * @param {string} value
   */
  public set image(value: string) {
    this._image = value;
  }
}
