import { Component } from '@angular/core';
import { Compte } from 'src/app/UTILS/comptes';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-comptes',
  templateUrl: './admin-comptes.component.html',
  styleUrls: ['./admin-comptes.component.scss']
})
export class  AdminComptesComponent {
  lignes: Compte[] = [
    { id: 1, nom: 'Nom', prenom:'Prenom', email: 'email@example.com', telephone: '555-555-5555', adresseNum: 123, adresseRue:"Rue éverlor",adresseCp:69003,adresseVille:"Lyon" },
    { id: 2, nom: 'Nom', prenom:'Prenom', email: 'email@example.com', telephone: '555-555-5555', adresseNum: 123, adresseRue:"Rue éverlor",adresseCp:69003,adresseVille:"Lyon" },
    { id: 3, nom: 'Nom', prenom:'Prenom', email: 'email@example.com', telephone: '555-555-5555', adresseNum: 123, adresseRue:"Rue éverlor",adresseCp:69003,adresseVille:"Lyon" },
    { id: 4, nom: 'Nom terriblement long', prenom:'Prenom terrible pour voir comment réagit le tableau', email: 'emailimprobabble@domaine trop chiant.com', telephone: '000 00 00 00 00 ', adresseNum: 123, adresseRue:"Rue éverlor",adresseCp:69003,adresseVille:"Lyon" },
  ];

  /**
   * On redirige vers la fiche compte en cas de clic
   * @param router 
   */
  constructor(private router: Router) { }
  voirFicheCompte() { 
    this.router.navigate(['/ADMIN/fiche-compte']);
  }
}
