import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';
import { constants } from '../helpers/constants';

export class User {
  constructor(
    public status: string,
  ) { }
}

export class JwtResponse {
  constructor(
    public jwttoken: string,
  ) { }
}

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  constructor(
    private httpClient: HttpClient
  ) {
  }
  login(usr: string, pwd: string) {
    const endpoint = environment.baseUrl + constants.login;
    return this.httpClient.post<any>(endpoint,
      {
        'username': usr,
        'password': pwd
      }
    ).pipe(
      map(
        userData => {
          sessionStorage.setItem('username', usr);
          const tokenStr = 'Bearer ' + userData.token;
          sessionStorage.setItem('token', tokenStr);
          return userData;
        }
      )
      );
  }
  isUserLoggedIn() {
    const user = sessionStorage.getItem('username');
    // console.log(!(user === null))
    return !(user === null);
  }
  logOut() {
    sessionStorage.removeItem('username');
  }

  register(user) {
    return this.httpClient.post<any>('http://localhost:8081/user/customer', user).pipe(
      map(
        userData => {
          return userData;
        }
      )
    );
  }
}
