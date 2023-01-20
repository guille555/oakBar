package io.scout.persistence;

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
public class SQLWayPayQuery {

  private DBConnection connection = null;

  public SQLWayPayQuery() {}

  public void saveWayPay(String denomination) {
    this.connection = new DBConnection();
    String statement = "INSERT INTO ways_pay(denomination, flag_state) VALUES (?, TRUE)";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setString(1, denomination.toUpperCase());
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to save 'WayPay' object: " + exc.getMessage());
    }
  }

  public void updateWayPay(byte id, String denomination) {
    this.connection = new DBConnection();
    String statement = "UPDATE ways_pay SET denomination = ? WHERE ((flag_state = TRUE) AND (way_pay_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setString(1, denomination.toUpperCase());
      query.setByte(2, id);
      query.executeUpdate();
      query.close();
    } catch (Exception exc) {
      System.err.println("ERROR SQL: Fail to update 'WayPay' object: " + exc.getMessage());
    }
  }

  public void eraseWayPay(byte id) {
    this.connection = new DBConnection();
    String statement = "UPDATE ways_pay SET flag_state = FALSE WHERE ((flag_state = TRUE) AND (way_pay_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setByte(1, id);
      query.executeUpdate();
      query.close();
    } catch (Exception exc) {
      System.err.println("ERROR SQL: Fail to erase 'WayPay' object: " + exc.getMessage());
    }
  }

  /*public void deleteWayPay(byte id) {
    this.connection = new DBConnection();
    String statement = "DELETE FROM ways_pay WHERE ((flag_state = TRUE) AND (way_pay_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setShort(1, id);
      query.close();
    } catch (Exception exc) {
      System.err.println("ERROR SQL: Fail to delete 'WayPay' object: " + exc.getMessage());
    }
  }*/

  public WayPay getWayPayById(byte id) {
    this.connection = new DBConnection();
    WayPay wayPay = null;
    String statement = "SELECT * FROM ways_pay WHERE ((flag_state = TRUE) AND (way_pay_id = ?))";
    ResultSet result = null;
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      wayPay = new WayPay();
      query = conn.prepareStatement(statement);
      query.setByte(1, id);
      result = query.executeQuery();
      while (result.next()) {
        wayPay.setWayPayId(result.getByte("way_pay_id"));
        wayPay.setDenomination(result.getString("denomination"));
        wayPay.setFlagState(result.getBoolean("flag_state"));
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to bring 'WayPay' object: " + exc.getMessage());
    }
    return wayPay;
  }

  public List<WayPay> getAllWaysPay() {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM ways_pay ORDER BY denomination";
    PreparedStatement query = null;
    ResultSet result = null;
    WayPay wayPay = null;
    List<WayPay> listWaysPay = null;
    try (Connection conn = this.connection.getConnection()) {
      listWaysPay = new ArrayList<WayPay>();
      query = conn.prepareStatement(statement);
      result = query.executeQuery();
      while (result.next()) {
        wayPay = new WayPay();
        wayPay.setWayPayId(result.getByte("way_pay_id"));
        wayPay.setDenomination(result.getString("denomination"));
        wayPay.setFlagState(result.getBoolean("flag_state"));
        listWaysPay.add(wayPay);
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to bring all 'WayPay' objects");
    }
    return listWaysPay;
  }

  public List<WayPay> getAllWaysPayByState(boolean flagState) {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM ways_pay WHERE (flag_state = ?) ORDER BY denomination";
    PreparedStatement query = null;
    ResultSet result = null;
    WayPay wayPay = null;
    List<WayPay> listWaysPay = new ArrayList<WayPay>();
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setBoolean(1, flagState);
      result = query.executeQuery();
      while (result.next()) {
        wayPay = new WayPay();
        wayPay.setWayPayId(result.getByte("way_pay_id"));
        wayPay.setDenomination(result.getString("denomination"));
        wayPay.setFlagState(result.getBoolean("flag_state"));
        listWaysPay.add(wayPay);
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to bring all 'WayPay' active objects: " + exc.getMessage());
    }
    return listWaysPay;
  }
}
