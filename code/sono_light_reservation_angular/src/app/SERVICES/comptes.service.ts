import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../UTILS/User';

@Injectable({
  providedIn: 'root'
})
export class ComptesService {
    private baseUrl = 'http://localhost:9000';
    constructor(private http: HttpClient) {}
    
    getCompteById(user_id: number) : Observable<User> {
      const url = `${this.baseUrl}/user/${user_id}`;
      return this.http.get<User>(url);
    }
    
    getComptes(): Observable<User[]> {
        const url = `${this.baseUrl}/user`;
        return this.http.get<User[]>(url);
    }

    
    updateCompte(formData: any): Observable<any> {
        const url = `${this.baseUrl}/user`;       

        //parse the formData to POST-able object
        const user = {
          user_id: formData.user_id,
          name: formData.name,
          firstname: formData.firstname,
          mail: formData.mail,
          phone: formData.phone,
          adress: formData.adress
        };
        
        // post user object
        return this.http.post(url, user);
      }

}