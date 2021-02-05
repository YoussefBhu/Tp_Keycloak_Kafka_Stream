import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {KeycloackSecurityService} from './keycloack-security.service'

@Injectable({
  providedIn: 'root'
  })
export class KeycloakHttpInterceptor implements HttpInterceptor {

  constructor(private KcS : KeycloackSecurityService ) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if(!this.KcS.kc.authenticated) return next.handle(request);
    let req= request.clone({
    setHeaders: {
      Authorization: 'Bearer '+this.KcS.kc.token
    }
    });
    return next.handle(req);
  }
 
}
