import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Compte } from '../UTILS/comptes';

@Injectable({
  providedIn: 'root'
})
export class ComptesService {
    getCompteById(id: number) : Observable<Compte> {
      const url = `${this.baseUrl}/user/${id}`;
      return this.http.get<Compte>(url);
    }
    
    private baseUrl = 'http://localhost:9000';
    constructor(private http: HttpClient) {}

    getComptes(): Observable<Compte[]> {

        const url = `${this.baseUrl}/user`;
        return this.http.get<Compte[]>(url);
    }

    
    updateCompte(formData: any): Observable<any> {
        const url = `${this.baseUrl}/user`;       
      
        // Créer un objet avec les données à envoyer dans la requête HTTP POST
        const data = {
          id: formData.id,
          nom: formData.nom,
          prenom: formData.prenom,
          email: formData.email,
          telephone: formData.telephone,
          adresse: formData.adresse
        };
      
        // Envoyer la requête HTTP POST
        return this.http.post(url, data);
      }

}