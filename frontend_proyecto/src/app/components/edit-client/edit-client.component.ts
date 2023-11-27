import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Client } from 'src/app/models/client';
import { ClientService } from 'src/app/service/client.service';

/* The EditClientComponent class is responsible for editing and updating a client's information in an
Angular application. */

@Component({
  selector: 'app-edit-client',
  templateUrl: './edit-client.component.html',
  styleUrls: ['./edit-client.component.css']
})

export class EditClientComponent implements OnInit{

  client: Client = new Client();
  clientId: number = 0;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private clientService: ClientService,
  ) {}
  
    ngOnInit(): void {
      this.route.params.subscribe((params) => {
        this.clientId = +params['id'];
        this.clientService.getClientById(this.clientId).subscribe(
          data => {
            this.client = data;
          }
        );
      });
    }

    onSubmit() {
      this.clientService.updateClient(this.clientId, this.client).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['/clients']);
        }
      );
    }
}