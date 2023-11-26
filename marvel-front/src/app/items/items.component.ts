import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../service/api.service';

@Component({
  selector: 'app-items',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './items.component.html',
  styleUrl: './items.component.css'
})
export class ItemsComponent {

  constructor(private apiService: ApiService) { }

  data: any[] = [];

  consultBitacora(){
    this.apiService.getBitacora().subscribe( data => {
      this.data  = data;
    });
  }
}
