import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ADMINAccueilComponent } from './ADMIN/admin-accueil/admin-accueil.component';
import { CLIENTAccueilComponent } from './CLIENT/client-accueil/client-accueil.component';
import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    ADMINAccueilComponent,
    CLIENTAccueilComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
