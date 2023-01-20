package io.scout.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Guillermo, Gómez
 */
public class Brand {

  private short brandId;
  private String brandName;
  private boolean flagState;
  private List<Product> listProducts;

  public Brand() {
    this.listProducts = new ArrayList<Product>();
  }

  public short getBrandId() {
    return brandId;
  }

  public void setBrandId(short brandId) {
    this.brandId = brandId;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  public boolean isFlagState() {
    return flagState;
  }

  public void setFlagState(boolean flagState) {
    this.flagState = flagState;
  }

  public List<Product> getListProducts() {
    return listProducts;
  }

  public void setListProducts(List<Product> listProducts) {
    this.listProducts = listProducts;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 29 * hash + Objects.hashCode(this.brandId);
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
    final Brand other = (Brand) obj;
    return Objects.equals(this.brandId, other.brandId);
  }

  @Override
  public String toString() {
    return "Brand{" + "brandId=" + brandId + "}";
  }
}
