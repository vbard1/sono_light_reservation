import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheCompteComponent } from './userDetails.component';

describe('FicheCompteComponent', () => {
  let component: FicheCompteComponent;
  let fixture: ComponentFixture<FicheCompteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FicheCompteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FicheCompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
