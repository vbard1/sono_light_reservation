import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserReservationDetailsComponent } from './user-reservation-details.component';

describe('UserReservationDetailsComponent', () => {
  let component: UserReservationDetailsComponent;
  let fixture: ComponentFixture<UserReservationDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UserReservationDetailsComponent]
    });
    fixture = TestBed.createComponent(UserReservationDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
