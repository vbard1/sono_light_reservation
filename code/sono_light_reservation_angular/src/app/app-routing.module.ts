import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ADMINAccueilComponent } from './ADMIN/admin-accueil/admin-accueil.component';
import { FicheCompteComponent } from './ADMIN/admin-comptes/fiche-compte/fiche-compte.component';
import { AppComponent } from './app.component';
import { CLIENTAccueilComponent } from './CLIENT/client-accueil/client-accueil.component';
import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';
import { HomeComponent } from './home/home.component';
const routes: Routes = [
  { path: 'AppComponent', component: AppComponent },
  { path: 'ADMIN/admin-accueil', component: ADMINAccueilComponent },
  { path: 'ADMIN/fiche-compte', component: FicheCompteComponent }, // Ajoutez ce chemin de route
  { path: 'CLIENT/client-accueil', component: CLIENTAccueilComponent },
  { path: '**', component: PageNotFoundComponent },
  { path: 'HomeComponent', component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
