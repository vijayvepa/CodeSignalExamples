import { TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { inject } from '@angular/core';

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppComponent],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have the 'arrays' title`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('arrays');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h1')?.textContent).toContain('Hello, arrays');
  });
	
	it('should execute arrays example', () => {
		const component = new AppComponent();
		const output = component.arrayExample();
		console.log("Output:" + output);
		expect(output).toEqual('Array: Apt 101,Apt 102,Apt 103,Apt 201,vacant,Apt 203,Apt 301,Apt 302,Apt 303');
	})
});
