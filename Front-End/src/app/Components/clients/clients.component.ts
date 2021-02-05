import { Component, OnInit } from '@angular/core';
import {KeycloackSecurityService} from '../../Services/keycloack-security.service';
import {HttpService} from '../../Services/http.service'
import {Router} from '@angular/router'

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.scss']
})
export class ClientsComponent implements OnInit {  
  Clients:any ; 
  ClientsManager : Boolean ; 
  constructor(
    public KcS :KeycloackSecurityService,
    private httpdata : HttpService,
    private router : Router  ) { 
      if(!KcS.kc.authenticated){
        this.router.navigate(["/"]); 
      }
      this.ClientsManager = KcS.CheckRole('CUSTOMER_MANAGER'); 
      
    }

  ngOnInit(): void {
    if(this.ClientsManager){
      this.httpdata.GetClients().subscribe(data =>{
        console.log(data)
        this.Clients = data; 
        this.Clients = this.Clients._embedded.customers ; 
      });
    }
  }

}
