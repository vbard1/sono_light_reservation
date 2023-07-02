import { MAT_DATE_LOCALE, MatNativeDateModule } from '@angular/material/core';

import { AdminEquipmentListComponent } from './ADMIN/admin-equipment-list/admin-equipment-list.component';
import { AdminHomeComponent } from './ADMIN/admin-home/admin-home.component';
import { AdminReservationComponent } from './ADMIN/admin-reservation/admin-reservation.component';
import { AdminUserDetailsComponent } from './ADMIN/admin-user-details/admin-user-details.component';
import { AdminUserListComponent } from './ADMIN/admin-user-list/admin-user-list.component';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { NgModule } from '@angular/core';
import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';
import { ReactiveFormsModule } from '@angular/forms';
import { UserHomeComponent } from './USER/user-home/user-home.component';
import { FormContactComponent } from './form-contact/form-contact.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    PageNotFoundComponent,
    AdminEquipmentListComponent,
    AdminUserListComponent,
    AdminReservationComponent,
    AdminUserDetailsComponent,
    UserHomeComponent,
    FormContactComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatIconModule,
    MatExpansionModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule, 
  ],
  providers: [{provide: MAT_DATE_LOCALE, useValue: 'fr-FR'},],
  bootstrap: [AppComponent]
})
export class AppModule {}
