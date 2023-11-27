import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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