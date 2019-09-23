import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username: string;
  password: string;

  constructor(private authService: AuthService, private router : Router) { }

  ngOnInit() {
  }

  login() {
    this.authService.login(this.username, this.password).pipe()
      .subscribe(
      data => {
        console.log(data);
        if(data.token){
          this.router.navigateByUrl('home');
        }
      },
      error => {
        console.log(error);
      });
  }

}
