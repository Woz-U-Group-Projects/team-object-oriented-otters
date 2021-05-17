import { Component, OnInit } from '@angular/core';
import { Globals } from '../../common/globals';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor() { }

  token = Globals.__APP_TOKEN__;

  ngOnInit() {
  }

}
