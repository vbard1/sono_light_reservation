import { Component } from '@angular/core';
import { Compte } from 'src/app/MODELS/compte.model';
import { Router } from '@angular/router';
import { ComptesService } from 'src/app/SERVICES/comptes.service';

@Component({
  selector: 'app-admin-comptes',
  templateUrl: './admin-comptes.component.html',
  styleUrls: ['./admin-comptes.component.scss']
})
export class  AdminComptesComponent {
  lignes!: Compte[]; //une ligne = un compte
  constructor(private router: Router, private comptesService : ComptesService) { }
  
  /**au démarrage, on récupère la liste des comtpes */
  ngOnInit():void{
    this.lignes = this.comptesService.getComptes();
    /*this.comptesService.getComptes().subscribe(comptes => {
      this.lignes = comptes;
    });*/
  }

  /**
   * On redirige vers la fiche compte en cas de clic
   */
  voirFicheCompte() { 
    this.router.navigate(['/ADMIN/fiche-compte']);
  }
}
