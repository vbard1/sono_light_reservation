import { AdminEquipmentDetailsComponent } from './ADMIN/admin-equipment-details/admin-equipment-details.component';
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
import { NgModule } from '@angular/core';
import { PageNotFoundComponent } from './GENERAL/page-not-found/page-not-found.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    AdminHomeComponent,
    PageNotFoundComponent,
    AdminEquipmentListComponent,
    AdminUserListComponent,
    AdminReservationComponent,
    AdminUserDetailsComponent,
    AdminEquipmentDetailsComponent,
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
