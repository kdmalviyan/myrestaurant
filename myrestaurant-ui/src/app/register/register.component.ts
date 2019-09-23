import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { RequiredValidator } from '@angular/forms/src/directives/validators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;

  constructor(private authService: AuthService, private formBuilder: FormBuilder) {
    this.registerForm = formBuilder.group({
      firstName: ['', Validators.required],
      lastName: [''],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required],
    });
  }

  ngOnInit() {}
  
  register() {
    console.log();
    this.authService.register(this.registerForm.value).pipe()
      .subscribe(
      data => {
        console.log(data);
      },
      error => {
        console.log(error);
      });
  }
}
