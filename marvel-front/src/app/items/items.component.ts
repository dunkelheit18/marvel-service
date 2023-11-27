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
  charactersData: any[] = [];
  comicsData: any[] = [];
  eventsData: any[] = [];
  seriesData: any[] = [];
  storiesData: any[] = [];

  consultBitacora(){
    this.apiService.getBitacora().subscribe( data => {
        this.data  = data;
    });
  }
  consulCharacteres(name : string){

    if(name != null && name != undefined && name !=''){
      this.apiService.getCharacters(name).subscribe( data =>{
        let result = data;
        this.charactersData = result;
        this.comicsData = result.comics;
        this.eventsData = result.events;
        this.seriesData = result.series;
        this.storiesData = result.stories;
        console.log(data);
      });
    }
  }
}
