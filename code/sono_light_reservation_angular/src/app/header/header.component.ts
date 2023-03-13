import { Component, OnInit } from '@angular/core';
import { Link } from '../shared/models/UTILS/links.models';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit {
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
