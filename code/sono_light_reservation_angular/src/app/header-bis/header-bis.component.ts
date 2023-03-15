import { Component } from '@angular/core';
import { Link } from '../shared/UTILS/links';

@Component({
  selector: 'app-header-bis',
  templateUrl: './header-bis.component.html',
  styleUrls: ['./header-bis.component.scss'],
})
export class HeaderBisComponent {
  links: Link[];
  constructor() {
    this.links = [];
  }
  ngOnInit(): void {
    this.links.push(
      new Link('Home', '/home'),
      new Link('Contact', '/contact'),
      new Link('Se Connecter/enregistrer', '/se connecter/enregistrer'),
      new Link('Nos Materials', '/nos materials')
    );
  }
}
