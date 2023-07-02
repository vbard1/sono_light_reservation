import { Component } from '@angular/core';
import { Validators } from '@angular/forms';
import { FormBuilder, NgForm } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { ContactService } from '../SERVICES/contact.service';
@Component({
  selector: 'app-form-contact',
  templateUrl: './form-contact.component.html',
  styleUrls: ['./form-contact.component.scss'],
})
export class FormContactComponent {
  contactForm = this.fb.group({
    name: [
      '',
      [Validators.required, Validators.maxLength(15), Validators.minLength(2)],
    ],
    object: [
      '',
      [Validators.required, Validators.maxLength(255), Validators.minLength(4)],
    ],
    email: [
      '',
      [
        Validators.required,
        Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$'),
      ],
    ],
    message: ['', Validators.required],
  });

  constructor(
    private fb: FormBuilder,
    private contactService: ContactService
  ) {}

  sendForm() {
    const formValueAsString = JSON.stringify(this.contactForm.value);
    this.contactService.sendEmail(formValueAsString).subscribe((data) => {
      if (data.message == 'success') {
        alert('Email sent successfully');
        this.contactForm?.reset();
      } else {
        alert('Something went wrong');
      }
    });
  }
}
