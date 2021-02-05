import { Component, OnInit } from '@angular/core';
import {KeycloackSecurityService} from '../../Services/keycloack-security.service';
import {HttpService} from '../../Services/http.service'
import {Router} from '@angular/router'

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {

  Products:any ; 
  ProductManager : Boolean ; 
  constructor(
    public KcS :KeycloackSecurityService,
    private httpdata : HttpService,
    private router : Router  ) { 
      if(!KcS.kc.authenticated){
        this.router.navigate(["/"]); 
      }
      this.ProductManager = KcS.CheckRole('PRODUCT_MANAGER'); 
    }

  ngOnInit(): void {
    if(this.ProductManager){
      this.httpdata.GetProducts().subscribe(data =>{
        this.Products = data; 
        this.Products = this.Products._embedded.products ; 
        console.log(this.Products)
      });
    }
  }

}
