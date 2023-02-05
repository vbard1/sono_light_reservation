import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ADMINAccueilComponent } from './admin-accueil.component';

describe('ADMINAccueilComponent', () => {
  let component: ADMINAccueilComponent;
  let fixture: ComponentFixture<ADMINAccueilComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ADMINAccueilComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ADMINAccueilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
