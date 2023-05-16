import { Component } from '@angular/core';
import { User } from 'src/app/UTILS/User';
import { Router } from '@angular/router';
import { ComptesService } from 'src/app/SERVICES/comptes.service';

@Component({
  selector: 'app-admin-comptes',
  templateUrl: './admin-comptes.component.html',
  styleUrls: ['./admin-comptes.component.scss']
})

export class  AdminComptesComponent {
  rows!: User[]; //une ligne = un compte
  constructor(private router: Router, private comptesService : ComptesService) { }
  
  /**au démarrage, on récupère la liste des comtpes */
  ngOnInit():void{
    this.comptesService.getComptes().subscribe(users => {
      this.rows = users;
    });
  }

  /**
   * On redirige vers la fiche compte en cas de clic
   */
  voirFicheCompte(user_id: number) {
    this.router.navigate(['/ADMIN/fiche-compte', user_id]);
  }
}
