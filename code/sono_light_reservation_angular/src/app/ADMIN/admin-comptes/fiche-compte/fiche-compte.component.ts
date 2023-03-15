import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { ComptesService } from 'src/app/SERVICES/comptes.service';
import { Compte } from 'src/app/UTILS/comptes';

@Component({
  selector: 'app-fiche-compte',
  templateUrl: './fiche-compte.component.html',
  styleUrls: ['./fiche-compte.component.scss']
})
export class FicheCompteComponent {

  compteForm!: FormGroup;
  comptePreview$!: Observable<Compte>;
  telephoneRegEx!: RegExp;
  emailRegEx!: RegExp;
  cpRegEx!: RegExp

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private comptesService : ComptesService) { }

  ngOnInit() {
    this.telephoneRegEx = /^(?:(?:\+|00)33|0)\s*[1-9](?:[\s.-]*\d{2}){4}$/;
    this.emailRegEx =/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;

    //objet form TS, relié au form HTML
    this.compteForm = this.formBuilder.group({
      id: [Number],//TODO doit vérifier unchanged -> valeur par défaut préremplies par null(idée-> stocker l'id qui arrive de la base et vérifier avant de renvoyer le formulaire)
      nom: [null, Validators.required],
      prenom: [null, Validators.required],
      email: [null, [Validators.required, Validators.pattern(this.emailRegEx)]],
      telephone: [null, [Validators.required, Validators.pattern(this.telephoneRegEx)]],
      adresseNum: [null],
      adresseRue: [null],
      adresseCp: [null], /*code postal*/
      adresseVille: [null]
    });
    //déclenche les événements
    this.comptePreview$ = this.compteForm.valueChanges.pipe(
      map((formValue) => ({
        ...formValue
      }))
    );
  }

  onSubmitForm(): void {
    //TODO ne pas naviguer si le post ne marche pas/si le form n'est pas valide
    //this.comptesService.updateOrCreateCompte(id:number);
    this.router.navigateByUrl("/ADMIN/admin-accueil");
  }
  
  doNothing():void{
    console.log("OPERATION ANNULEE"); //TODO debug
    this.router.navigateByUrl("/ADMIN/admin-accueil");
  }
}
