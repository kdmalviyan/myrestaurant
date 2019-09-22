import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/service/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  username: string;
  password: string;


  constructor(private authService: AuthService,  private formBuilder: FormBuilder) { }

  ngOnInit() {    
      this.firstName ="";
      this.lastName="";
      this.email="";
      this.phone="";
      this. username = "";
      this. password="";    
  }


  onSubmit() {
    console.log("dsfsdf"+this.firstName)
    return this.firstName;

  }
}
