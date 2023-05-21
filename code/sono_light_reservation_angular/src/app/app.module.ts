import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';

import { HttpClientModule } from '@angular/common/http';
import { AdminHomeComponent } from './ADMIN/admin-home/admin-home.component';
import { AdminEquipmentComponent } from './ADMIN/admin-equipment/admin-equipment.component';
import { AdminReservationComponent } from './ADMIN/admin-reservation/admin-reservation.component';
import { AdminUserListComponent } from './ADMIN/admin-user-list/admin-user-list.component';
import { AdminUserDetailsComponent } from './ADMIN/admin-user-details/admin-user-details.component';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    PageNotFoundComponent,
    AdminEquipmentComponent,
    AdminUserListComponent,
    AdminReservationComponent,
    AdminUserDetailsComponent,
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
