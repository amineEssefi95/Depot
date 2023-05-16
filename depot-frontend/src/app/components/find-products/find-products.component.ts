import { Component } from '@angular/core';
import {ProductsService} from "../../service/products.service";

@Component({
  selector: 'app-find-products',
  templateUrl: './find-products.component.html',
  styleUrls: ['./find-products.component.scss']
})
export class FindProductsComponent {

  searchText: String = '';
  products: any[] = [];

  constructor(private productService: ProductsService) { }

  ngOnInit() {
    this.getAllProducts();
  }

  getAllProducts() {
    this.productService.getAllProducts().subscribe(
      (res) => (this.products = res),
      (err) => console.log(err),
    )
  }

  getAllAvailbleProductsByCategorie() {
    this.productService.getAllAvailbleProductsByCategorie(this.searchText).subscribe(
      (res) => (this.products = res),
      (err) => console.log(err),
    )
  }

  searchAvailbleByCategory() {
    if (this.searchText === '') {
      this.getAllProducts();
    } else {
      this.getAllAvailbleProductsByCategorie();
    }
  }


}
