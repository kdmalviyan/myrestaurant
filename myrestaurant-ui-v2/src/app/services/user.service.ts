import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseUrl = 'localhost:8080'
  constructor(private http: HttpClient) { }
  public signup(user) {
    return this.http.post(environment.baseUrl + 'user/customer', user).toPromise();
  }
}
