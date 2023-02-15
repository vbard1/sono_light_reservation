import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-accueil',
  templateUrl: './admin-accueil.component.html',
  styleUrls: ['./admin-accueil.component.scss']
})
export class ADMINAccueilComponent {
  tabselector!: string;
  selected !: string;
<<<<<<< HEAD

=======
      
>>>>>>> 08c21cb (Màj boot projet et bases ecran compte (#32))
  ngOnInit(){
    this.tabselector='thirdTab'; //onglet par défaut, à l'ouverture
  }

  //permet de changer d'onglet et de garder la persistance du focus sur l'onglet (on voit que l'onglet est actif)
  onTabClick(tabId: string) {
    const tabs = document.getElementsByClassName('tab');
    for (let i = 0; i < tabs.length; i++) {
      const tab = tabs[i];
      if (tab.id === tabId) {
        let element =document.getElementById(tab.id);
        if(element){element.classList.add('selected');}
        this.tabselector=tabId;
      } else {
        tab.classList.remove('selected');
      }
<<<<<<< HEAD
=======
      
>>>>>>> 08c21cb (Màj boot projet et bases ecran compte (#32))
    }
  }
}
