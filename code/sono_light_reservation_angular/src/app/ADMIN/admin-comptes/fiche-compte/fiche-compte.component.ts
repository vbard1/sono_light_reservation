import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ComptesService } from 'src/app/SERVICES/comptes.service';
import { User } from 'src/app/UTILS/User';

@Component({
  selector: 'app-fiche-compte',
  templateUrl: './fiche-compte.component.html',
  styleUrls: ['./fiche-compte.component.scss']
})
export class FicheCompteComponent implements OnInit {

  userForm!: FormGroup;
  comptePreview$!: Observable<User>;
  phoneRegEx!: RegExp;
  emailRegEx!: RegExp;
  cpRegEx!: RegExp;
  id!: string;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private comptesService: ComptesService
  ) {
    this.phoneRegEx = /^(?:(?:\+|00)33|0)\s*[1-9](?:[\s.-]*\d{2}){4}$/;
    this.emailRegEx = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;
    this.cpRegEx = /^\d{5}$/;
  }

  ngOnInit(): void {
    // Initialisation du formulaire
    this.userForm = this.formBuilder.group({
      user_id: [null],
      name: [null, Validators.required],
      firstname: [null, Validators.required],
      email: [null, [Validators.required, Validators.pattern(this.emailRegEx)]],
      phone: [null, [Validators.required, Validators.pattern(this.phoneRegEx)]],
      address:[null]
    });

    // Récupération de l'ID à partir de l'URL
    this.route.paramMap.pipe(
      map(params => {
        this.id = params.get('user_id')!;
        return this.id;
      })
    ).subscribe();
    console.log(this.id);


    // Récupération des informations du compte à partir du service
    this.comptesService.getCompteById(Number(this.id)).subscribe({
      next: (user: User) => {
        // Populate the form with the retrieved account data
        this.userForm.patchValue({
          user_id: user.user_id,
          name: user.name,
          firstname: user.firstname,
          email: user.email,
          phone: user.phone,
          address: user.address 
        });
      },
        error: (err) => {
          console.log("Une erreur est survenue lors de la récupération du compte : ", err);
        },
        complete: () => {
          console.log("Récupération du compte terminée");
        }
      });
      
    }
    
  onSubmitForm(): void {
    if (this.userForm.invalid) {
      console.log("Le formulaire n'est pas valide");
      return;
    }

    const formData = this.userForm.value;
    this.comptesService.updateCompte(formData).subscribe({
      next: () => {
        console.log("Le compte a été mis à jour avec succès");
        this.router.navigateByUrl("/ADMIN/admin-accueil");
      },
      error: (err) => {
        console.log("Une erreur est survenue lors de la mise à jour du compte : ", err);
      },
      complete: () => {
        console.log("Mise à jour du compte terminée");
      }
    });
  }

  doNothing(): void {
    console.log("OPERATION ANNULEE"); //TODO debug
    this.router.navigateByUrl("/ADMIN/admin-accueil");
  }
}
