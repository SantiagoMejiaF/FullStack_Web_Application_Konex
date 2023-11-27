import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListClientsComponent } from './components/list-clients/list-clients.component';
import { CreateClientComponent } from './components/create-client/create-client.component';
import { EditClientComponent } from './components/edit-client/edit-client.component';
import { SearchClientsComponent } from './components/search-clients/search-clients.component';


/* The AppRoutingModule class defines the routes for navigating between different components in the
application. */

const routes: Routes = [
  { path: '', redirectTo: 'clients', pathMatch: 'full' },
  { path: 'clients', component: ListClientsComponent },
  { path: 'clients/create', component: CreateClientComponent },
  { path: 'clients/edit/:id', component: EditClientComponent},
  { path: 'clients/search', component: SearchClientsComponent},
  { path: '**', redirectTo: 'clients', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
