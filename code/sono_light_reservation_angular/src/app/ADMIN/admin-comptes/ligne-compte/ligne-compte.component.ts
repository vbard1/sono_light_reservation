import { Component, Input } from '@angular/core';
import { Compte } from 'src/app/UTILS/comptes';



@Component({
  selector: 'app-ligne-compte',
  templateUrl: './ligne-compte.component.html',
  styleUrls: ['./ligne-compte.component.scss']
})
export class LigneCompteComponent {
  @Input() ligne!:Compte;
}
