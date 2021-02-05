import { Component, OnInit } from '@angular/core';
import {KeycloackSecurityService} from '../../Services/keycloack-security.service'
@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {

  constructor(public KcS :KeycloackSecurityService) { }

  ngOnInit(): void {
  }
  onLogout() { this.KcS.kc.logout(); }
  onChangePassword() { this.KcS.kc.accountManagement(); }
  onLogin() { this.KcS.kc.login(); }
}
