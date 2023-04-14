import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddInsuranceComponentComponent } from './add-insurance-component.component';

describe('AddInsuranceComponentComponent', () => {
  let component: AddInsuranceComponentComponent;
  let fixture: ComponentFixture<AddInsuranceComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddInsuranceComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddInsuranceComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
