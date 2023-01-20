package io.scout.model;

import java.util.Date;
import java.util.Objects;

/**
 * @author Guillermo, Gómez
 */
public class ProductItem {

  private long productItemId;
  private Date elaboratinDate;
  private float price;
  private boolean flagSold;
  private boolean flagState;
  private Product product;
  private Detail detail;

  public ProductItem() {}

  public long getProductItemId() {
    return productItemId;
  }

  public void setProductItemId(long productItemId) {
    this.productItemId = productItemId;
  }

  public Date getElaboratinDate() {
    return elaboratinDate;
  }

  public void setElaboratinDate(Date elaboratinDate) {
    this.elaboratinDate = elaboratinDate;
  }

  public float getPrice() {
    return price;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public boolean isFlagSold() {
    return flagSold;
  }

  public void setFlagSold(boolean flagSold) {
    this.flagSold = flagSold;
  }

  public boolean isFlagState() {
    return flagState;
  }

  public void setFlagState(boolean flagState) {
    this.flagState = flagState;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Detail getDetail() {
    return detail;
  }

  public void setDetail(Detail detail) {
    this.detail = detail;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 83 * hash + Objects.hashCode(this.productItemId);
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
    final ProductItem other = (ProductItem) obj;
    return Objects.equals(this.productItemId, other.productItemId);
  }

  @Override
  public String toString() {
    return "ProductItem{" + "productItemId=" + productItemId + "}";
  }
}
