import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../service/api.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpErrorResponse } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { PopupComponent } from '../popup/popup.component';

@Component({
  selector: 'app-items',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './items.component.html',
  styleUrl: './items.component.css'
})
export class ItemsComponent {

  constructor(private apiService: ApiService, private snackBar : MatSnackBar, public dialog : MatDialog) { }

  data: any[] = [];
  charactersData: any[] = [];
  comicsData: any[] = [];
  eventsData: any[] = [];
  seriesData: any[] = [];
  storiesData: any[] = [];
  nameCharacters: string = " ";
  mostrarPopUp : boolean = false;
  imagenUrl: any = "";

  consultBitacora(){
    this.apiService.getBitacora().subscribe( data => {
        if(data != null && data != undefined){
          this.data  = data;
        }
        else{
          this.snackBar.open('No se encontraron resultados en la búsqueda...', 'Cerrar');
        }
    },
    (error: HttpErrorResponse) => {
      this.snackBar.open('No se encontraron resultados en la búsqueda...', 'Cerrar');
      console.log(error);
    });
  }
  consulCharacteres(name : string, id: string){

    let banderaNombre  = name != null && name != undefined && name !='' ? true : false;
    let banderaId      = id != null && id != undefined && id != '' ? true : false;
    
    if(banderaNombre || banderaId){   
          if(banderaNombre && banderaId){
            this.snackBar.open('Solo se puede seleccionar el nombre o ID', 'Cerrar');
          }
          else {
            let idCharacter = parseInt(id); 
            this.apiService.getCharacters(name, idCharacter).subscribe( data =>{
              if(data != null && data != undefined){
                let result = data;
                this.charactersData = result;
                this.comicsData = result.comics;
                this.eventsData = result.events;
                this.seriesData = result.series;
                this.storiesData = result.stories;
                this.nameCharacters = result.name;
                console.log(data);
              }
              else{
                this.snackBar.open('No se encontraron resultados en la búsqueda...', 'Cerrar');
              }
            },
            (error: HttpErrorResponse) => {
              this.snackBar.open('No se encontraron resultados en la búsqueda...', 'Cerrar');
              console.log(error);
            });
          }
    }
    else{
        this.snackBar.open('Favor de ingresar el Nombre o Identificado del personaje.', 'Cerrar');
    }
  }

  getImage(link : string, type : string){

    this.apiService.getImageElemnt(link).subscribe( response => {
      
      let responseUrl = '';

      if(type == 'c'){
        responseUrl = response.data.results[0].images[0].path;
      }
      else {
        responseUrl = response.data.results[0].thumbnail.path;
      }

      if(responseUrl != null && responseUrl != undefined && responseUrl != ''){
        const dialogRef = this.dialog.open(PopupComponent, {
          data: { imagenUrl : responseUrl  + '/detail.jpg'}
        });
      }
      else {
        this.snackBar.open('No hay información ...', 'Cerrar');
      }
    });
  }
  cleanBitacora(): void {
    this.data = [];
  }

  cleanCharacters() : void {
    this.comicsData = [];
    this.eventsData = [];
    this.seriesData = [];
    this.storiesData = [];
  }
}
