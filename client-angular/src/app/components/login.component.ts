import { Component, OnInit } from '@angular/core';
import { Login } from 'src/app/models/login';
import { LoginService } from 'src/app/services/login.service';
import { Globals } from '../common/globals';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) {}
  
  login: Login = new Login();
  
  doLogin(login){
    this.loginService.doLogin(login).subscribe(resp=>{
      
      const keys = resp.headers.keys();
      Globals.__APP_TOKEN__ = resp.headers.get("Authorization");

      console.log(Globals.__APP_TOKEN__);

      this.router.navigate(['/register']);
      
    }, error =>{
      console.log(error.status);
    });
  }
  

  ngOnInit() {
  }

}
