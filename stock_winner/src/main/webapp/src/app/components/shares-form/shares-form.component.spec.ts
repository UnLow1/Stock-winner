import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {SharesFormComponent} from './shares-form.component';

describe('SharesFormComponent', () => {
  let component: SharesFormComponent;
  let fixture: ComponentFixture<SharesFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SharesFormComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SharesFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
