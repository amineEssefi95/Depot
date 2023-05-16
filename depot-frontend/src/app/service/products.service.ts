import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../modal/product";

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  baseURL: string = "http://localhost:8080/product";
  constructor(private httpClient: HttpClient) {}

  getAllProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.baseURL);
  }

  getAllAvailbleProductsByCategorie(category: String): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.baseURL + `/getAllAvailbleProductsByCategorie/${category}`);
  }
}
