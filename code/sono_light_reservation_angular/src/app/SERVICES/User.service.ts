import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../MODELS/User.model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})

export class UserService {

  constructor(private http: HttpClient) { }

  getCompteById(user_id: number): Observable<User> {
    const url = `${environment.api_url}user/${user_id}`;
    return this.http.get<User>(url);
  }

  getComptes(): Observable<User[]> {
    const url = `${environment.api_url}user`;
    return this.http.get<User[]>(url);
  }


  updateCompte(formData: any): Observable<any> {
    const url = `${environment.api_url}user/${formData.user_id}`;
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
    const url = `${environment.api_url}user/${user_id}`;

    // delete user object
    return this.http.delete(url);
 
  }
}

