import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Compte } from '../models/compte.model';

@Injectable({
  providedIn: 'root'
})
export class ComptesService {

    liste : Compte[] = [
        { id: 1, nom: 'Simpson', prenom: 'Bart', email: 'email@example.com', telephone: '555-555-5555', adresseNum: 123, adresseRue:"Rue éverlor",adresseCp:69003,adresseVille:"Lyon" },
        { id: 2, nom: 'Simpson', prenom:'Maggie', email: 'email@example.com', telephone: '555-555-5555', adresseNum: 123, adresseRue:"Rue éverlor",adresseCp:69003,adresseVille:"Lyon" },
        { id: 3, nom: 'Simpson', prenom:'Homer', email: 'email@example.com', telephone: '555-555-5555', adresseNum: 123, adresseRue:"Rue éverlor",adresseCp:69003,adresseVille:"Lyon" },
        { id: 4, nom: 'Simpson', prenom:'Marge', email: 'point.email@demaiil.com', telephone: '000 00 00 00 00 ', adresseNum: 123, adresseRue:"Rue éverlor",adresseCp:69003,adresseVille:"Lyon" },
    ];
    /**
     * récupère tous les comptes du serveur
     */
    getComptes():Compte[]{
    //temporaire : exemple de comptes en brut
    return this.liste;
    }

    updateCompte(id: number){
    //TODO
    }
    /*
    private baseUrl = 'http://localhost:9000';
    constructor(private http: HttpClient) {}

    getComptes(): Observable<Compte[]> {
        const url = `${this.baseUrl}/comptes`;
        return this.http.get<Compte[]>(url);
    }

    updateCompte(id: number){
        //TODO
    }*/

}