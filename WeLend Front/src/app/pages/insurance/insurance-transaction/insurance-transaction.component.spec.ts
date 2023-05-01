import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsuranceTransactionComponent } from './insurance-transaction.component';

describe('InsuranceTransactionComponent', () => {
  let component: InsuranceTransactionComponent;
  let fixture: ComponentFixture<InsuranceTransactionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsuranceTransactionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsuranceTransactionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
