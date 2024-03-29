import { ActivatedRoute, Router } from "@angular/router";
import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Observable, map } from "rxjs";

import { User } from "src/app/MODELS/User.model";
import { UserService } from "src/app/SERVICES/User.service";

@Component({
  selector: 'app-admin-user-details',
  templateUrl: './admin-user-details.component.html',
  styleUrls: ['./admin-user-details.component.scss']
})
export class AdminUserDetailsComponent implements OnInit {

  userForm!: FormGroup;
  comptePreview$!: Observable<User>;
  phoneRegEx!: RegExp;
  emailRegEx!: RegExp;
  cpRegEx!: RegExp;
  id!: string;

  /**html related attributes (styling classes, enum) */
  saveButtonColor: string = 'btn-save';
  cancelButtonColor: string = 'btn-cancel';

  levels: { value:string, numero:number }[] = [
    { value: "USER", numero:2},
    { value: "ADMIN", numero:1},
    { value: "SUPER_ADMIN", numero:0}
  ];

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserService
  ) {
    this.phoneRegEx = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/;
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
      address:[null],
      level: [null] 
    });

    // Récupération de l'ID à partir de l'URL
    this.route.paramMap.pipe(
      map(params => {
        this.id = params.get('user_id')!;
      })
    ).subscribe();


    // Récupération des informations du compte à partir du service
    this.userService.getCompteById(Number(this.id)).subscribe({
      next: (user: User) => {
        const levelLabel = this.levels.find(level => level.value === user.level)?.value;
        console.log(levelLabel);
        this.userForm.patchValue({
          user_id: user.user_id,
          name: user.name,
          firstname: user.firstname,
          email: user.email,
          phone: user.phone,
          address: user.address,
          level: levelLabel
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
    const selectedLevel = this.userForm.get('level')?.value;
    const numero = this.levels.find(level => level.value === selectedLevel)?.numero;

    if (numero !== undefined) {
      formData.level = numero;
    }

    this.userService.updateCompte(formData).subscribe({
      next: () => {
        this.router.navigateByUrl("/ADMIN/admin-accueil");
      }
    });
  }

  doNothing(): void {
    this.router.navigateByUrl("/ADMIN/admin-accueil");
  }
}
