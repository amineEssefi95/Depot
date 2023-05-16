import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {FindProductsComponent} from "./components/find-products/find-products.component";

const routes: Routes = [ { path: '', component: FindProductsComponent} ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
