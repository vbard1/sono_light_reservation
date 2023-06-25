import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/MODELS/User.model';
import { UserService } from 'src/app/SERVICES/User.service';

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
      console.log(users);
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

      this.userService.deleteCompte(user_id).subscribe({});
      this.userService.getComptes().subscribe(users => {this.rows = users;});
    
  }
}
