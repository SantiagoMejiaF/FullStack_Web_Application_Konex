import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

/* The MenuComponent class is responsible for handling the logout functionality and refreshing the
page. */
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  isLogged = true;

  constructor(private router: Router){}

  onLogOut(): void {
    window.location.reload();
    this.router.navigate(['/']);
  }
}