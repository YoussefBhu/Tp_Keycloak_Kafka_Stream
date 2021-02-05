import { Component, OnInit } from '@angular/core';
import {KeycloackSecurityService} from '../../Services/keycloack-security.service';
import {HttpService} from '../../Services/http.service'
import {Router} from '@angular/router'

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrls: ['./bills.component.scss']
})
export class BillsComponent implements OnInit {

  Bills:any ; 
  BillsManager : Boolean ; 
  constructor(
    public KcS :KeycloackSecurityService,
    private httpdata : HttpService,
    private router : Router  ) { 
      if(!KcS.kc.authenticated){
        this.router.navigate(["/"]); 
      }
      this.BillsManager = KcS.CheckRole('BILLING_MANAGER');  
    }

  ngOnInit(): void {
    if(this.BillsManager){
      this.httpdata.GetBills().subscribe(data =>{
        this.Bills = data; 
        this.Bills = this.Bills._embedded.bills ; 
      });
    }
  }
}
