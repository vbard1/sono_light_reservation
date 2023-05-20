import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';
import { AdminHomeComponent } from './ADMIN/adminHome/adminHome.component';
import { AdminUsersComponent } from './ADMIN/adminUsers/adminUsers.component';
import { UserDetailsComponent } from './ADMIN/adminUsers/userDetails/userDetails.component';
import { CLIENTAccueilComponent } from './USER/userHome/userHome.component';

const routes: Routes = [
  { path: 'AppComponent', component: AppComponent },
  { path: 'ADMIN/admin-accueil', component: AdminHomeComponent },
  { path: 'ADMIN/comptes', component: AdminUsersComponent },
  {
    path: 'ADMIN/fiche-compte/:user_id',
    component: UserDetailsComponent
  }, 
  { path: 'CLIENT/client-accueil', component: CLIENTAccueilComponent },
  { path: '', redirectTo: '/ADMIN/comptes', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
