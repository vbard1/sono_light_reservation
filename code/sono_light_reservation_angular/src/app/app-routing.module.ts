import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';
import { AdminHomeComponent } from './ADMIN/admin-home/admin-home.component';
import { AdminUserListComponent } from './ADMIN/admin-user-list/admin-user-list.component';
import { AdminUserDetailsComponent } from './ADMIN/admin-user-details/admin-user-details.component';
import { UserHomeComponent } from './USER/user-home/user-home.component';

const routes: Routes = [
  { path: 'AppComponent', component: AppComponent },
  { path: 'ADMIN/admin-accueil', component: AdminHomeComponent },
  { path: 'ADMIN/comptes', component: AdminUserListComponent },
  {
    path: 'ADMIN/fiche-compte/:user_id',
    component: AdminUserDetailsComponent,
  },
  { path: 'CLIENT/client-accueil', component: UserHomeComponent },
  { path: '', redirectTo: '/ADMIN/comptes', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent },
  { path: 'HomeComponent', component: UserHomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
