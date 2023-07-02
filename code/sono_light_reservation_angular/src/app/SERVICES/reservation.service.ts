import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservation } from '../MODELS/Reservation.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) { }

  getReservationsByClient(clientId: number): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${environment.api_url}/${clientId}`);
  }

  getReservationById(id: number): Observable<Reservation> {
    return this.http.get<Reservation>(`${environment.api_url}/${id}`);
  }

  addReservation(reservation: Reservation): Observable<Reservation> {
    return this.http.post<Reservation>(environment.api_url, reservation);
  }

  updateReservation(reservation: Reservation): Observable<Reservation> {
    return this.http.put<Reservation>(environment.api_url, reservation);
  }

  deleteReservation(id: number): Observable<any> {
    return this.http.delete(`${environment.api_url}/${id}`);
  }
}