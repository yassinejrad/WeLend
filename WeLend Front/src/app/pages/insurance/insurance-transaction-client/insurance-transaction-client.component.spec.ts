import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsuranceTransactionClientComponent } from './insurance-transaction-client.component';

describe('InsuranceTransactionClientComponent', () => {
  let component: InsuranceTransactionClientComponent;
  let fixture: ComponentFixture<InsuranceTransactionClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsuranceTransactionClientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InsuranceTransactionClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
