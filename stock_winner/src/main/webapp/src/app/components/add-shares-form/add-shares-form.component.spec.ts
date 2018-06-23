import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {AddSharesFormComponent} from './add-shares-form.component';

describe('AddSharesFormComponent', () => {
  let component: AddSharesFormComponent;
  let fixture: ComponentFixture<AddSharesFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AddSharesFormComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddSharesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
