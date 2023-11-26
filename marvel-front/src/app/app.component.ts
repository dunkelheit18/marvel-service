import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { ApiService } from './service/api.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  
  title = 'marvel-front';

  constructor(private apiService: ApiService) { }

  data: any[] = [];

  ngOnInit(): void {
    
  }

  consultBitacora(){
    this.apiService.getBitacora().subscribe( data => {
      this.data  = data;
    });
  }
}
