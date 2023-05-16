import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {TableModule} from "primeng/table";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FindProductsComponent } from './components/find-products/find-products.component';
import {InputTextModule} from "primeng/inputtext";
import {ButtonModule} from "primeng/button";

@NgModule({
  declarations: [
    AppComponent,
    FindProductsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    TableModule,
    InputTextModule,
    ButtonModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
