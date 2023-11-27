import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { Client } from 'src/app/models/client';
import { ClientService } from 'src/app/service/client.service';

/* The SearchClientsComponent class is a TypeScript component that handles searching for clients based
on different criteria. */

@Component({
  selector: 'app-search-clients',
  templateUrl: './search-clients.component.html',
  styleUrls: ['./search-clients.component.css']
})
export class SearchClientsComponent implements OnInit {
  searchForm: FormGroup;
  clients$: Observable<Client[]>;

  constructor(
    private formBuilder: FormBuilder,
    private clientService: ClientService,
  ) {
    this.searchForm = this.formBuilder.group({
      city: [''],
      locality: [''],
      concessionaire: ['']
    });
  }

  ngOnInit(): void {
    this.searchClients();
  }

  searchClients(): void {
    const { city, locality, concessionaire } = this.searchForm.value;
    if (locality) {
      this.clients$ = this.clientService.searchClientsByLocality(locality);
    } else if (city) {
      this.clients$ = this.clientService.searchClientsByCity(city);
    } else if (concessionaire) {
      this.clients$ = this.clientService.searchClientsByConcessionaire(concessionaire);
    } else {
      this.clients$ = this.clientService.searchClients('', '', '');
    }
  }
}