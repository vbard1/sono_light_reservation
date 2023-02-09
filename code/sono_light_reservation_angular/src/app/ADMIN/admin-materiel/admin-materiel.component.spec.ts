import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ADMINMaterielComponent } from './admin-materiel.component';

describe('ADMINMaterielComponent', () => {
  let component: ADMINMaterielComponent;
  let fixture: ComponentFixture<ADMINMaterielComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ADMINMaterielComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ADMINMaterielComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
