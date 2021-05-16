import { Component, OnInit } from '@angular/core';
import { Login } from 'src/app/models/login';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService) {}
  
  login: Login = new Login();
  
  doLogin(login){
    this.loginService.doLogin(login).subscribe(login=>{
      console.log("Logged in");
    }, error =>{
      console.log(error.toString());
    });
  }
  

  ngOnInit() {
  }

}
