import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {CurrenciesFormComponent} from './currencies-form.component';

describe('CurrenciesFormComponent', () => {
  let component: CurrenciesFormComponent;
  let fixture: ComponentFixture<CurrenciesFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [CurrenciesFormComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CurrenciesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
