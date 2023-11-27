import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from 'src/app/models/client';
import { ClientDTO } from 'src/app/models/clientDTO';
import { CityService } from 'src/app/service/city.service';
import { ClientService } from 'src/app/service/client.service';
import { ConcessionaireService } from 'src/app/service/concessionaire.service';
import { LocalityService } from 'src/app/service/locality.service';

@Component({
  selector: 'app-create-client',
  templateUrl: './create-client.component.html',
  styleUrls: ['./create-client.component.css']
})
export class CreateClientComponent {
  
  client: Client = new Client();
  localities: string[] = [];
  concessionaires: string[] = [];
  cities: string[] = [];

  selectedCity: string = '';
  selectedCityId: number = 0;

  selectedConcessionaire: string = '';
  selectedConcessionaireId: number = 0;

  selectedLocality: string = '';
  selectedLocalityId: number = 0;

  constructor(
    private clientService: ClientService,
    private localityService: LocalityService,
    private concessionaireService: ConcessionaireService,
    private cityService: CityService,
    private router: Router
  ){}

  ngOnInit(): void {
    this.getAllCitiesNames();
  }

  getAllCitiesNames() {
    this.cityService.getAllCitiesNames().subscribe(
      data => {
        this.cities = data;
      }
    );
  }
  
  onCitySelected() {
    this.cityService.getCityIdByName(this.selectedCity).subscribe(
      data => {
        this.selectedCityId = data;
        this.loadConcessionaires();
      },
      error => console.log(error)
    );
  }

  loadConcessionaires() {
    this.concessionaireService.getAllConcessionairesByCity(this.selectedCityId).subscribe(
      data => {
        this.concessionaires = data;
      },
      error => console.log(error)
    );
  }

  onConcessionaireSelected() {
    this.concessionaireService.getConcessionaireIdByName(this.selectedConcessionaire).subscribe(
      data => {
        console.log('Selected Concessionaire ID:', data);
        this.selectedConcessionaireId = data;
        this.loadLocalities();
      },
      error => console.log(error)
    );
  }

  loadLocalities() {
    this.localityService.getLocalitiesByConcessionaireId(this.selectedConcessionaireId).subscribe(
      data => {
        this.localities = data;
      },
      error => console.log(error)
    );
  }

  goToClientsList() {
    this.router.navigate(['/clients']);
  }

  onSubmit() 
  {
    const completeClient: ClientDTO = {
      fullName: this.client.fullName,
      idNumber: this.client.idNumber,
      address: this.client.address,
      phoneNumber: this.client.phoneNumber,
      email: this.client.email,
      locality: {
        localityName: this.selectedLocality,
        concessionaire: {
          concessionaireName: this.selectedConcessionaire,
          city: {
            cityName: this.selectedCity,
          },
        },
      },
    };
    
    this.clientService.createClient(completeClient).subscribe(
      data => {
        console.log(data);
        this.goToClientsList();
      },
      error => console.log(error)
    );
  }
}