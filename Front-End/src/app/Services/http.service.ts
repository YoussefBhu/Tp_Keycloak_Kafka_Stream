import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http:HttpClient) { }

  GetProducts(){
    return this.http.get('http://localhost:8082/PRODUCT-SERVICE/products')
  }

  GetClients(){
    return this.http.get('http://localhost:8082/CUSTOMER-SERVICE/customers')
  }

  GetBills(){
    return this.http.get('http://localhost:8082/BILLING-SERVICE/bills')
  }
  
}
