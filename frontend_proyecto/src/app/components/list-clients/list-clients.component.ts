import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/models/client';
import { ClientService } from 'src/app/service/client.service';

/* The ListClientsComponent class is responsible for displaying a list of clients, allowing the user to
create, edit, and delete clients. */

@Component({
  selector: 'app-list-clients',
  templateUrl: './list-clients.component.html',
  styleUrls: ['./list-clients.component.css']
})

export class ListClientsComponent {
  clients: Client[] = [];

  constructor(
    private clientService: ClientService,
    private router: Router
  ){}
  
  ngOnInit(): void {
    this.getAllClients();
  }

  getAllClients(): void {
    this.clientService.getAllClients().subscribe(data => {
      this.clients = data;
    });
  }

  navigateToCreateClient(): void {
    this.router.navigate(['/clients/create']);
  }

  navigateToEditClient(id: number): void {
    this.router.navigate([`/clients/edit/${id}`]);
  }

  deleteClient(id: number): void {
    this.clientService.deleteClient(id).subscribe(() => {
    this.clients = this.clients.filter(client => client.id !== id);
    });
  }
}