import { Component } from '@angular/core';
import { Compte } from 'src/app/shared/models/UTILS/comptes';

@Component({
  selector: 'app-admin-comptes',
  templateUrl: './admin-comptes.component.html',
  styleUrls: ['./admin-comptes.component.scss'],
})
export class AdminComptesComponent {
  lignes: Compte[] = [
    {
      id: 1,
      nom: 'Prénom Nom',
      email: 'email@example.com',
      telephone: '555-555-5555',
      adresse: '123 Main St',
    },
    {
      id: 2,
      nom: 'Autre Prénom Nom',
      email: 'a@example.com',
      telephone: '555-555-55',
      adresse: '456 Main St',
    },
    {
      id: 2,
      nom: 'Autre Prénom Nom',
      email: 'aa@example.com',
      telephone: '555-555-555',
      adresse: ' TEST 456 Main St',
    },
    {
      id: 2,
      nom: 'j4AI UN  NOM   terriblement long',
      email: 'et surtout un email a la con @example.com',
      telephone: '000112233445566778899',
      adresse:
        'Une adresse à faire vomir le facteur, 69903 nulle part -sur - rien',
    },
  ];
}
