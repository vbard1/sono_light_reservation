import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
<<<<<<< HEAD
import { ADMINAccueilComponent } from './ADMIN/admin-accueil/admin-accueil.component';
import { CLIENTAccueilComponent } from './CLIENT/client-accueil/client-accueil.component';
=======

>>>>>>> developpement
import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
<<<<<<< HEAD
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { CarousselComponent } from './caroussel/caroussel.component';
import { LocalisationComponent } from './localisation/localisation.component';
import { MatIconModule } from '@angular/material/icon';
=======
import { MatNativeDateModule, MAT_DATE_LOCALE } from '@angular/material/core';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatExpansionModule} from '@angular/material/expansion';
import { AdminHomeComponent } from './ADMIN/admin-home/admin-home.component';
import { AdminEquipmentListComponent } from './ADMIN/admin-equipment-list/admin-equipment-list.component';
import { AdminReservationComponent } from './ADMIN/admin-reservation/admin-reservation.component';
import { AdminUserListComponent } from './ADMIN/admin-user-list/admin-user-list.component';
import { AdminUserDetailsComponent } from './ADMIN/admin-user-details/admin-user-details.component';
import { UserHomeComponent } from './USER/user-home/user-home.component';

>>>>>>> developpement

@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    PageNotFoundComponent,
    AdminEquipmentListComponent,
    AdminUserListComponent,
    AdminReservationComponent,
<<<<<<< HEAD
    FicheCompteComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    CarousselComponent,
    LocalisationComponent,
=======
    AdminUserDetailsComponent,
    UserHomeComponent,
>>>>>>> developpement
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule,
<<<<<<< HEAD
    FormsModule,
    MatIconModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
=======
    MatSnackBarModule,
    MatIconModule,
    MatExpansionModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule, 
  ],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'fr-FR'},],
  bootstrap: [AppComponent]
>>>>>>> developpement
})
export class AppModule {}
