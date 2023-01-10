package io.scout.model;

import java.util.Objects;

/**
 * @author Guillermo, Gómez
 */
public class WayPay {

  private Byte wayPayId;
  private String denomination;
  private boolean flagState;

  public WayPay() {}

  public Byte getWayPayId() {
    return wayPayId;
  }

  public String getDenomination() {
    return denomination;
  }

  public void setDenomination(String denomination) {
    this.denomination = denomination;
  }

  public boolean isFlagState() {
    return flagState;
  }

  public void setFlagState(boolean flagState) {
    this.flagState = flagState;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 11 * hash + Objects.hashCode(this.wayPayId);
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
    final WayPay other = (WayPay) obj;
    return Objects.equals(this.wayPayId, other.wayPayId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("WayPay{");
    sb.append("wayPayId=").append(wayPayId);
    sb.append("}");
    return sb.toString();
  }
}
