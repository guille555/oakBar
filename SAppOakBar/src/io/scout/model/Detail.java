package io.scout.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Guillermo, Gómez
 */
public class Detail {

  private Long detailId;
  private Date saleDate;
  private boolean flagState;
  private WayPay wayPay;
  private List<ProductItem> listProductItems;

  public Detail() {
    this.listProductItems = new ArrayList<ProductItem>();
  }

  public Long getDetailId() {
    return detailId;
  }

  public void setDetailId(Long detailId) {
    this.detailId = detailId;
  }

  public Date getSaleDate() {
    return saleDate;
  }

  public void setSaleDate(Date saleDate) {
    this.saleDate = saleDate;
  }

  public boolean isFlagState() {
    return flagState;
  }

  public void setFlagState(boolean flagState) {
    this.flagState = flagState;
  }

  public WayPay getWayPay() {
    return wayPay;
  }

  public void setWayPay(WayPay wayPay) {
    this.wayPay = wayPay;
  }

  public List<ProductItem> getListProductItems() {
    return listProductItems;
  }

  public void setListProductItems(List<ProductItem> listProductItems) {
    this.listProductItems = listProductItems;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 19 * hash + Objects.hashCode(this.detailId);
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
    final Detail other = (Detail) obj;
    return Objects.equals(this.detailId, other.detailId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Detail{");
    sb.append("detailId=").append(detailId);
    sb.append("}");
    return sb.toString();
  }
}
