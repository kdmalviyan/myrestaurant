import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';


export class User{
  constructor(
    public status:string,
     ) {}
}

export class JwtResponse{
  constructor(
    public jwttoken:string,
     ) {}
}

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  constructor(
    private httpClient:HttpClient
  ) { 
     }
     login(username: string, password: string) {      
      return this.httpClient.post<any>('http://localhost:8081/authenticate',{"username":"Manoj","password":"manoj"}).pipe(
       map(
         userData => {          
          sessionStorage.setItem('username',username);
          let tokenStr= 'Bearer '+userData.token;
          sessionStorage.setItem('token', tokenStr);          
          return userData;
         }
       )
      );
    }
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    //console.log(!(user === null))
    return !(user === null)
  }
  logOut() {
    sessionStorage.removeItem('username')
  }  

  register(fisrtName: string , lastName: string , email: string , phone : string, username: string, password: string) {      
    return this.httpClient.post<any>('http://localhost:8081/user/customer',{"firstName":"Manoj",
    "lastName":"singh",
    "username":"Manoj",
    "password":"manoj",
    "email":"manojsinghgmailcom",
    "phone":"9786758858"}).pipe(
     map(
       userData => {
        return userData;
       }
     )
    );
  }
  
}
