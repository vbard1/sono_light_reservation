import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FicheReservationComponent } from './fiche-reservation.component';

describe('FicheReservationComponent', () => {
  let component: FicheReservationComponent;
  let fixture: ComponentFixture<FicheReservationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FicheReservationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FicheReservationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
