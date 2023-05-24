import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/SERVICES/User.service';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-admin-comptes',
  templateUrl: './admin-user-list.component.html',
  styleUrls: ['./admin-user-list.component.scss']
})

export class  AdminUserListComponent {
  rows!: User[]; //une ligne = un compte
  constructor(private router: Router, private userService : UserService) { }
  
  /**au démarrage, on récupère la liste des comtpes */
  ngOnInit():void{
    this.userService.getComptes().subscribe(users => {
      this.rows = users;
    });
  }

  /**
   * On redirige vers la fiche compte en cas de clic
   */
  seeUserDetails(user_id: number) {
    this.router.navigate(['/ADMIN/fiche-compte', user_id]);
  }

  /**
   * On supprime l'utilisateur demandé TODO supprimer tout en base associé a l'utilisateur?
   */
  deleteUser(user_id: number) {

      this.userService.deleteCompte(user_id).subscribe({
        next: () => {
          console.log('Utilisateur supprimé avec succès');
          // Réactualiser la liste des utilisateurs ou effectuer toute autre action nécessaire
        },
        error: (error) => {
          console.log('Erreur lors de la suppression de l\'utilisateur :', error);
        },
        complete: () => {
          console.log('Suppression de l\'utilisateur terminée');
        }
      });
      this.userService.getComptes().subscribe(users => {
        this.rows = users;
      });
    
  }
}
