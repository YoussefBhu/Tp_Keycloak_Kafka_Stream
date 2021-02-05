import { BrowserModule } from '@angular/platform-browser';
import { APP_INITIALIZER, NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { ProductsComponent } from './Components/products/products.component';
import { ClientsComponent } from './Components/clients/clients.component';
import { BillsComponent } from './Components/bills/bills.component';
import {KeycloackSecurityService} from './Services/keycloack-security.service'; 
import {KeycloakHttpInterceptor} from './Services/keycloak-http.interceptor';
import { NavBarComponent } from './Components/nav-bar/nav-bar.component';
import { HomeComponent } from './Components/home/home.component';

export function kcFactory(kcSecService:KeycloackSecurityService) {
  return ()=>kcSecService.init();
  }

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    ClientsComponent,
    BillsComponent,
    NavBarComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule
  ],
  providers: [
    { provide:APP_INITIALIZER, deps:[KeycloackSecurityService], useFactory:kcFactory, multi:true },
    { provide:HTTP_INTERCEPTORS, useClass:KeycloakHttpInterceptor, multi:true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
