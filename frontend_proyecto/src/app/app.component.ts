import { Component } from '@angular/core';

/* The AppComponent class is the root component of the application and manages the title of the system
for managing clients. */
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Sistema de Gestion de Clientes';
}