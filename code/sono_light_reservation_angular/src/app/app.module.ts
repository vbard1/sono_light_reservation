import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';

import { HttpClientModule } from '@angular/common/http';
import { AdminHomeComponent } from './ADMIN/adminHome/adminHome.component';
import { AdminEquipmentComponent } from './ADMIN/adminEquipment/adminEquipment.component';
import { AdminReservationComponent } from './ADMIN/adminReservation/adminReservation.component';
import { AdminUsersComponent } from './ADMIN/adminUsers/adminUsers.component';
import { UserDetailsComponent } from './ADMIN/adminUsers/userDetails/userDetails.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    PageNotFoundComponent,
    AdminEquipmentComponent,
    AdminUsersComponent,
    AdminReservationComponent,
    UserDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
