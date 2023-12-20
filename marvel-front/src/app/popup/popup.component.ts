import { Component, Inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-popup',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './popup.component.html',
  styleUrl: './popup.component.css'
})
export class PopupComponent {
  
  constructor(public dialogRef : MatDialogRef<PopupComponent>, @Inject(MAT_DIALOG_DATA) public data : any ) {

  }

  closePopUp() {
    this.dialogRef.close();
    this.data.imagenUrl = '';
  }
}
