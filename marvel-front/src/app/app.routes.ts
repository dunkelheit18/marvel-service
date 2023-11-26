import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import path from 'path';
import { ItemsComponent } from './items/items.component';
import { Router } from 'express';
import { HttpClientModule } from '@angular/common/http';

export const routes: Routes = [

    { path: '', component: ItemsComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
