package io.scout.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Guillermo, Gómez
 */
public class Product {

  private int productId;
  private String productName;
  private float actualPrice;
  private boolean flagState;
  private Brand brand;
  private List<ProductItem> listProducts;

  public Product() {
    this.listProducts = new ArrayList<ProductItem>();
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public float getActualPrice() {
    return actualPrice;
  }

  public void setActualPrice(float actualPrice) {
    this.actualPrice = actualPrice;
  }

  public boolean isFlagState() {
    return flagState;
  }

  public void setFlagState(boolean flagState) {
    this.flagState = flagState;
  }

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
  }

  public List<ProductItem> getListProducts() {
    return listProducts;
  }

  public void setListProducts(List<ProductItem> listProducts) {
    this.listProducts = listProducts;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 59 * hash + Objects.hashCode(this.productId);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Product other = (Product) obj;
    return Objects.equals(this.productId, other.productId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Product{");
    sb.append("productId=").append(productId);
    sb.append("}");
    return sb.toString();
  }
}
