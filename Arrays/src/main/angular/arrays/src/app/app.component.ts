import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'arrays';

	arrayExample() {
		const array = [
			["Apt 101", "Apt 102", "Apt 103"],
			["Apt 201", "Apt 202", "Apt 203"],
			["Apt 301", "Apt 302", "Apt 303"]
		]
		array[1][1] = 'vacant'
		return `Array: ${array}`;
   }
}

