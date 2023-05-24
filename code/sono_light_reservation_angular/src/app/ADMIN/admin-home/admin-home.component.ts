import { Component } from '@angular/core';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.scss']
})
export class AdminHomeComponent {
  tabselector!: string;
  selected !: string;

  ngOnInit(){
    this.tabselector='secondTab'; //onglet par défaut, à l'ouverture
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
    }
  }
}
