import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  constructor(private authService: AuthService) { }

  ngOnInit() {
  }

  login() {   
    this.authService.login('username', 'password').pipe()
    .subscribe(
        data => {
           console.log(data);
        },
        error => {
           console.log(error);
        });   
  }

}
