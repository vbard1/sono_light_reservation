import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { ADMINAccueilComponent } from './ADMIN/admin-accueil/admin-accueil.component';
import { CLIENTAccueilComponent } from './CLIENT/client-accueil/client-accueil.component';
import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';
import { ADMINMaterielComponent } from './ADMIN/admin-materiel/admin-materiel.component';
import { AdminComptesComponent } from './ADMIN/admin-comptes/admin-comptes.component';
import { AdminReservationComponent } from './ADMIN/admin-reservation/admin-reservation.component';
import { FicheCompteComponent } from './ADMIN/admin-comptes/fiche-compte/fiche-compte.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    AppComponent,
    ADMINAccueilComponent,
    CLIENTAccueilComponent,
    PageNotFoundComponent,
    ADMINMaterielComponent,
    AdminComptesComponent,
    AdminReservationComponent,
    FicheCompteComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
