import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ADMINAccueilComponent } from './ADMIN/admin-accueil/admin-accueil.component';
import { FicheCompteComponent } from './ADMIN/admin-comptes/fiche-compte/fiche-compte.component';
import { AppComponent } from './app.component';
import { CLIENTAccueilComponent } from './CLIENT/client-accueil/client-accueil.component';
import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';
import { AdminComptesComponent } from './ADMIN/admin-comptes/admin-comptes.component';

const routes: Routes = [
  { path: 'AppComponent', component: AppComponent },
  { path: 'ADMIN/admin-accueil', component: ADMINAccueilComponent },
  { path: 'ADMIN/comptes', component: AdminComptesComponent },
  { path: 'ADMIN/fiche-compte/:id', component: FicheCompteComponent }, // route "fiche-compte/:id"
  { path: 'CLIENT/client-accueil', component: CLIENTAccueilComponent },
  { path: '', redirectTo: '/ADMIN/comptes', pathMatch: 'full' },
  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
