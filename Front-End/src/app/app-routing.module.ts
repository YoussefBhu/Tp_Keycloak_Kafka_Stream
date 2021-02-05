import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductsComponent } from '../app/Components/products/products.component'
import { ClientsComponent } from '../app/Components/clients/clients.component'
import { BillsComponent } from '../app/Components/bills/bills.component'
import { HomeComponent } from '../app/Components/home/home.component'

const routes: Routes = [
  { path: "Bills",component:BillsComponent},
  { path: "Products",component:ProductsComponent}, 
  { path: "Clients",component:ClientsComponent},
  { path: "",component:HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
