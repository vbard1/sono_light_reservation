import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CLIENTAccueilComponent } from './client-accueil.component';

describe('CLIENTAccueilComponent', () => {
  let component: CLIENTAccueilComponent;
  let fixture: ComponentFixture<CLIENTAccueilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CLIENTAccueilComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CLIENTAccueilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
