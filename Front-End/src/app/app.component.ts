import { Component, OnInit } from '@angular/core';
import {KeycloackSecurityService} from './Services/keycloack-security.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  constructor(private kcs : KeycloackSecurityService){}

  ngOnInit(): void {
   
  }
  
  title = 'Front-End';

  

}

