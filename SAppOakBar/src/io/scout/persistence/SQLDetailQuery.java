package io.scout.persistence;

import io.scout.model.Detail;
import io.scout.model.WayPay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Guillermo, Gómez
 */
public class SQLDetailQuery {

  private DBConnection connection = null;

  public SQLDetailQuery() {}

  public void saveDetail(byte wayPayId) {
    this.connection = new DBConnection();
    String statement = "INSERT INTO details (sale_date, flag_state, way_pay_id) VALUES (CURRENT_TIMESTAMP, TRUE, ?)";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setByte(1, wayPayId);
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to save 'Detail' object: " + exc.getMessage());
    }
  }

  public void updateDetail(long id, byte way_pay_id) {
    this.connection = new DBConnection();
    String statement = "UPDATE details SET way_pay_id = ? WHERE ((flag_state = TRUE) AND (detail_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setByte(1, way_pay_id);
      query.setLong(2, id);
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to update 'Dettail' object: " + exc.getMessage());
    }
  }

  public void eraseDetail(long id) {
    this.connection = new DBConnection();
    String statement = "UPDATE details SET flag_state = FALSE WHERE ((flag_state = TRUE) AND (detail_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setLong(1, id);
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to erase 'Detail' object: " + exc.getMessage());
    }
  }

  private WayPay searchWayPay(byte id) {
    SQLWayPayQuery querys = null;
    WayPay wayPay = null;
    querys = new SQLWayPayQuery();
    wayPay = querys.getWayPayById(id);
    return wayPay;
  }

  public Detail getDetailById(long id) {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM details WHERE ((flag_state = TRUE) AND (detail_id = ?))";
    PreparedStatement query = null;
    ResultSet result = null;
    Detail detail = null;
    WayPay wayPay = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setLong(1, id);
      result = query.executeQuery();
      detail = new Detail();
      while (result.next()) {
        wayPay = this.searchWayPay(result.getByte("way_pay_id"));
        if (wayPay != null) {
          detail.setDetailId(result.getLong("detail_id"));
          detail.setSaleDate(result.getDate("sale_date"));
          detail.setWayPay(wayPay);
        } else {
          throw new SQLException("'WayPay' object nof found");
        }
      }
      result.close();
      query.close();
    } catch (Exception exc) {
      System.err.println("ERROR SQL: Fail to bring 'Detail' object: " + exc.getMessage());
    }
    return detail;
  }

  public List<Detail> getAllDetails() {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM details ORDER BY sale_date DESC";
    PreparedStatement query = null;
    ResultSet result = null;
    Detail detail = null;
    WayPay wayPay = null;
    List<Detail> listDetails = new ArrayList<Detail>();
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      result = query.executeQuery();
      while (result.next()) {
        detail = new Detail();
        wayPay = this.searchWayPay(result.getByte("way_pay_id"));
        if (wayPay != null) {
          detail.setDetailId(result.getLong("detail_id"));
          detail.setSaleDate(result.getDate("sale_date"));
          detail.setFlagState(result.getBoolean("flag_state"));
          detail.setWayPay(wayPay);
          listDetails.add(detail);
        } else {
          throw new SQLException("'WayPay' object nof found");
        }
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to bring all 'Detail' objects: " + exc.getMessage());
    }
    return listDetails;
  }

  public List<Detail> getAllDetailsByState(boolean flagState) {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM details WHERE (flag_state = ?) ORDER BY sale_date DESC";
    PreparedStatement query = null;
    ResultSet result = null;
    Detail detail = null;
    WayPay wayPay = null;
    List<Detail> listDetails = new ArrayList<Detail>();
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setBoolean(1, flagState);
      result = query.executeQuery();
      while (result.next()) {
        wayPay = this.searchWayPay(result.getByte("way_pay_id"));
        detail = new Detail();
        if (wayPay != null) {
          detail.setDetailId(result.getLong("detail_id"));
          detail.setSaleDate(result.getDate("sale_date"));
          detail.setFlagState(result.getBoolean("flag_state"));
          detail.setWayPay(wayPay);
          listDetails.add(detail);
        } else {
          throw new SQLException("'WayPay' object nof found");
        }
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to bring the 'Detail' objects: " + exc.getMessage());
    }
    return listDetails;
  }
}
