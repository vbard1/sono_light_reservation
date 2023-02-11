import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LigneCompteComponent } from './ligne-compte.component';



describe('LigneCompteComponent', () => {
  let component: LigneCompteComponent;
  let fixture: ComponentFixture<LigneCompteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LigneCompteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(LigneCompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  
});
