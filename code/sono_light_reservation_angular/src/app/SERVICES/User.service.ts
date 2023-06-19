import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../MODELS/User.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {


  private baseUrl = 'http://localhost:9000';
  constructor(private http: HttpClient) { }

  getCompteById(user_id: number): Observable<User> {
    const url = `${this.baseUrl}/user/${user_id}`;
    return this.http.get<User>(url);
  }

  getComptes(): Observable<User[]> {
    const url = `${this.baseUrl}/user`;
    return this.http.get<User[]>(url);
  }


  updateCompte(formData: any): Observable<any> {
    const url = `${this.baseUrl}/user/${formData.user_id}`;

    //parse the formData to POST-able object
    const user = {
      user_id: formData.user_id,
      name: formData.name,
      firstname: formData.firstname,
      mail: formData.mail,
      phone: formData.phone,
      adress: formData.adress,
      level: formData.level
    };
    
    // put user object
    return this.http.put(url, user);
  }
  
  deleteCompte(user_id: number) {
    /**
      * On supprime l'utilisateur demandé TODO supprimer tout en base associé a l'utilisateur?
      */
    const url = `${this.baseUrl}/user/${user_id}`;

    // delete user object
    return this.http.delete(url);
 
  }
}

