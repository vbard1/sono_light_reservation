import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { map, Observable } from 'rxjs';
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
  constructor(private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit() {
    this.telephoneRegEx = /^(?:(?:\+|00)33|0)\s*[1-9](?:[\s.-]*\d{2}){4}$/;
    this.compteForm = this.formBuilder.group({
      id: [null],//doit vérifier unchanged -> valeur par défaut préremplies par null(idée-> stocker l'id qui arrive de la base et vérifier avant de renvoyer le formulaire)
      nom: [null, Validators.required],
      prenom: [null, Validators.required],
      email: [null, Validators.required],
      telephone: [null, [Validators.required, Validators.pattern(this.telephoneRegEx)]],
      adresseNum: [null],
      adresseRue: [null],
      adresseCp: [null],
      adresseVille: [null]
    });
    this.comptePreview$ = this.compteForm.valueChanges.pipe(
      map((formValue) => ({
        ...formValue
      }))
    );
  }

  onSubmitForm(): void {
    //console.log(this.compteForm.value); //debug
    console.log("ENREGISTRER ICI"); //debug
    this.router.navigateByUrl("/ADMIN/admin-accueil");
  }
  doNothing():void{
    console.log("OPERATION ANNULEE");
    this.router.navigateByUrl("/ADMIN/admin-accueil");
    
  }
}
