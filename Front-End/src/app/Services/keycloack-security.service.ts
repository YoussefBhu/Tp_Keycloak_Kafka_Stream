import { Injectable } from '@angular/core';
import {KeycloakInstance} from "keycloak-js";
import {HttpClient} from "@angular/common/http";
declare var Keycloak: any;

@Injectable({
  providedIn: 'root'
})
export class KeycloackSecurityService {

  public kc:KeycloakInstance;
  
  constructor(private http:HttpClient) { }

  public async init(){
    const config = {
      'url':'http://localhost:8080/auth',
      'realm':'Tp',
      'clientId':'Front-End'
    }
    console.log("Test Initialisation");
    this.kc= new Keycloak(config);
    await this.kc.init({
    //onLoad:"login-required",
    onLoad:"check-sso",
    });
    }

    public CheckRole(role : string):boolean{ return this.kc.hasRealmRole(role); }

}