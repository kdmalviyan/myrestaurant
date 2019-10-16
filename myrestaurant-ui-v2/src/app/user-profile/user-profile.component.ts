import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { UserService } from 'app/services/user.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  userForm: FormGroup;

  constructor(fb: FormBuilder,
    private userService: UserService) {
    this.userForm = new FormGroup({
      companyName: new FormControl('Tavant Technologies Pvt. Ltd.', [Validators.required]),
      username: new FormControl('', [Validators.required]),
      firstName: new FormControl('', [Validators.required]),
      middleName: new FormControl(''),
      lastName: new FormControl('', [Validators.required]),
      email: new FormControl('', [Validators.required,
      Validators.email]),
      phone: new FormControl('', [Validators.required,
      Validators.minLength(10),
      Validators.maxLength(10), Validators.pattern('^[0-9]+$')]),
      address: new FormGroup({
        street: new FormControl('', [Validators.required]),
        city: new FormControl('', [Validators.required]),
        state: new FormControl('', [Validators.required]),
        country: new FormControl('', [Validators.required]),
        zip: new FormControl('', [Validators.required,
        Validators.minLength(6),
        Validators.maxLength(6), Validators.pattern('^[0-9]+$')])
      }),
      aboutMe: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required]),
      repassword: new FormControl('', [Validators.required]),
    });
  }

  ngOnInit() {
  }

  updateProfile() {
    console.log(JSON.stringify(this.userForm.value));
    const user = this.userForm.value;
    this.userService.signup(user).then(res => {
      console.log(JSON.stringify(res));
    });
  }
}
