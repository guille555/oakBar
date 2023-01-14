package io.scout.persistence;

import io.scout.model.Brand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLBrandQuery {

  private DBConnection connection = null;

  public SQLBrandQuery() {}

  public void saveBrand(String brandName) {
    this.connection = new DBConnection();
    String statement = "INSERT INTO brands(brand_name, flag_state) VALUES (?, ?)";
    PreparedStatement query = null;
    try(Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setString(1, brandName.toUpperCase());
      query.setBoolean(2, true);
      query.executeUpdate();
      query.close();
    } catch(SQLException exc) {
      System.err.println("ERROR SQL: Fail to save a brand object: " + exc.getMessage());
    }
  }

  public void updateBrand(Byte id, String brandName) {
    this.connection = new DBConnection();
    String statement = "UPDATE brands SET brand_name = ? WHERE ((flag_state = TRUE) AND (brand_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setString(1, brandName.toUpperCase());
      query.setByte(2, id.byteValue());
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to update the brand object: " + exc.getMessage());
    }
  }

  public void eraseBrand(Byte id) {
    this.connection = new DBConnection();
    String statement = "UPDATE brands SET flag_state = FALSE WHERE ((flag_state = TRUE) AND (brand_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setByte(1, id.byteValue());
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to erase the brand object: " + exc.getMessage());
    }
  }

  /*public void deleteBrand(Byte id) {
    this.connection = new DBConnection();
    String statement = "DELETE FROM brands WHERE ((flag_state = TRUE) AND (brand_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setByte(1, id.byteValue());
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to delete the brand object: " + exc.getMessage());
    }
  }*/

  public Brand getBrandById(Byte id) {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM brands WHERE (brand_id = ?)";
    PreparedStatement query = null;
    ResultSet result = null;
    Brand brand = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setByte(1, id.byteValue());
      result = query.executeQuery();
      while (result.next()) {
        byte resultId = result.getByte("brand_id");
        Byte brandId = Byte.valueOf(resultId);
        brand = new Brand();
        brand.setBrandId(brandId);
        brand.setBrandName(result.getString("brand_name"));
        brand.setFlagState(result.getBoolean("flag_state"));
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to fetch brand object: " + exc.getMessage());
    }
    return brand;
  }

  public List<Brand> getAllBrands() {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM brands ORDER BY brand_name";
    PreparedStatement query = null;
    ResultSet result = null;
    List<Brand> listBrands = new ArrayList<Brand>();
    try(Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      result = query.executeQuery();
      while (result.next()) {
        Brand brand = new Brand();
        brand.setBrandId(result.getByte("brand_id"));
        brand.setBrandName(result.getString("brand_name"));
        brand.setFlagState(result.getBoolean("flag_state"));
        listBrands.add(brand);
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR: Fail to get all brands objects: " + exc.getMessage());
    }
    return listBrands;
  }

  public List<Brand> getAllBrandsActive() {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM brands WHERE (flag_State = TRUE) ORDER BY brand_name";
    PreparedStatement query = null;
    ResultSet result = null;
    List<Brand> listBrands = new ArrayList<Brand>();
    try(Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      result = query.executeQuery();
      while (result.next()) {
        Brand brand = new Brand();
        brand.setBrandId(result.getByte("brand_id"));
        brand.setBrandName(result.getString("brand_name"));
        brand.setFlagState(result.getBoolean("flag_state"));
        listBrands.add(brand);
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR: Fail to get all actives brands objects: " + exc.getMessage());
    }
    return listBrands;
  }
}
