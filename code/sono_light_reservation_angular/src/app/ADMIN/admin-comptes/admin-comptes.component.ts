import { Component } from '@angular/core';
import { Compte } from 'src/app/UTILS/comptes';

@Component({
  selector: 'app-admin-comptes',
  templateUrl: './admin-comptes.component.html',
  styleUrls: ['./admin-comptes.component.scss']
})
export class AdminComptesComponent {
  lignes: Compte[] = [
    { id: 1, nom: 'Prénom Nom', email: 'email@example.com', telephone: '555-555-5555', adresse: '123 Main St' },
    { id: 2, nom: 'Autre Prénom Nom', email: 'a@example.com', telephone: '555-555-55', adresse: '456 Main St' },
    { id: 2, nom: 'Autre Prénom Nom', email: 'aa@example.com', telephone: '555-555-555', adresse: ' TEST 456 Main St' },
    { id: 2, nom: 'Autre Prénom Nom', email: 'aaa@example.com', telephone: '555-555-5555', adresse: '456 Main St' }
  ];
  
}