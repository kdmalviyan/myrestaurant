import { Injectable, Injector } from '@angular/core';
import 'rxjs/add/operator/do';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpResponse,
  HttpEvent,
  HttpErrorResponse,


} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor(private router: Router) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const access_token = sessionStorage.getItem('token');
    let changepwdReq = req;
    if (access_token) {
      changepwdReq = req.clone({
        headers: req.headers
          .set('Authorization', access_token)
      });
    }

    return next.handle(changepwdReq).do(
      event => {
        if (event instanceof HttpResponse) {
        }
      },
      err => {
        if (err instanceof HttpErrorResponse) {
          if (err.status === 401) {
            sessionStorage.clearAll();
            this.router.navigate(['/login']);
          }
        }
      }
    );
  }
}
