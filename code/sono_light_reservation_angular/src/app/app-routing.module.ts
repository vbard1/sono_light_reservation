import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ADMINAccueilComponent } from './ADMIN/admin-accueil/admin-accueil.component';
import { AppComponent } from './app.component';
import { CLIENTAccueilComponent } from './CLIENT/client-accueil/client-accueil.component';
import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },

  { path: 'ADMIN/admin-accueil', component: ADMINAccueilComponent },
  { path: 'CLIENT/client-accueil', component: CLIENTAccueilComponent },

  { path: '**', component: PageNotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
