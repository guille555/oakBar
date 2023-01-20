package io.scout.persistence;

import io.scout.model.Brand;
import io.scout.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Guillermo, Gómez
 */
public class SQLProductQuery {

  private DBConnection connection = null;

  public SQLProductQuery() {}

  public void saveProduct(String productName, float actualPrice, short brandId) {
    this.connection = new DBConnection();
    String statement = "INSERT INTO products(product_name, actual_price, flag_state, brand_id) VALUES (?, ?, TRUE, ?)";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setString(1, productName.toUpperCase());
      query.setFloat(2, actualPrice);
      query.setShort(3, brandId);
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to save 'Product' object: " + exc.getMessage());
    }
  }

  public void updateProduct(int id, String productName, float actualPrice, short brandId) {
    this.connection = new DBConnection();
    String statement = "UPDATE products SET product_name = ?, actual_price = ?, brand_id = ? WHERE ((flag_state = TRUE) AND (product_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setString(1, productName.toUpperCase());
      query.setFloat(2, actualPrice);
      query.setShort(3, brandId);
      query.setInt(4, id);
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to update 'Product' object: " + exc.getMessage());
    }
  }

  public void eraseProduct(int id) {
    this.connection = new DBConnection();
    String statement = "UPDATE products SET flag_state = FALSE WHERE ((flag_state = TRUE) AND (product_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setInt(1, id);
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to erase 'Product' object: " + exc.getMessage());
    }
  }

  /*public void deleteProduct(int id) {
    this.connection = new DBConnection();
    String statement = "DELETE FROM products WHERE ((flag_state = TRUE) AND (product_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setInt(1, id);
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to delete 'Product' object: " + exc.getMessage());
    }
  }*/

  private Brand searchBrandById(short id) {
    SQLBrandQuery querys = null;
    Brand brand = null;
    querys = new SQLBrandQuery();
    brand = querys.getBrandById(id);
    return brand;
  }

  public Product getProductById(int id) {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM products WHERE ((flag_state = TRUE) AND (product_id = ?))";
    PreparedStatement query = null;
    ResultSet result = null;
    Brand brand = null;
    Product product = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setInt(1, id);
      result = query.executeQuery();
      while (result.next()) {
        brand = this.searchBrandById(result.getShort("brand_id"));
        if (brand != null) {
          product = new Product();
          product.setProductId(result.getInt("product_id"));
          product.setProductName(result.getString("product_name"));
          product.setActualPrice(result.getFloat("actual_price"));
          product.setFlagState(result.getBoolean("flag_state"));
          product.setBrand(brand);
        } else {
          throw new SQLException("Fail to bring 'Brand' object");
        }
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to fetch 'Product' object: " + exc.getMessage());
    }
    return product;
  }

  public List<Product> getAllProducts() {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM products ORDER BY product_name";
    PreparedStatement query = null;
    ResultSet result = null;
    Brand brand = null;
    Product product = null;
    List<Product> listProducts = new ArrayList<Product>();
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      result = query.executeQuery();
      while (result.next()) {
        brand = this.searchBrandById(result.getShort("brand_id"));
        if (brand != null) {
          product = new Product();
          product.setProductId(result.getInt("product_id"));
          product.setProductName(result.getString("product_name"));
          product.setActualPrice(result.getFloat("actual_price"));
          product.setFlagState(result.getBoolean("flag_state"));
          product.setBrand(brand);
          listProducts.add(product);
        } else {
          throw new SQLException("Fail to bring 'Brand' object");
        }
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to fetch all 'Product' objects: " + exc.getMessage());
    }
    return listProducts;
  }

  public List<Product> getAllProductsByState(boolean flagState) {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM products WHERE (flag_state = ?) ORDER BY product_name";
    PreparedStatement query = null;
    ResultSet result = null;
    Brand brand = null;
    Product product = null;
    List<Product> listProducts = new ArrayList<Product>();
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setBoolean(1, flagState);
      result = query.executeQuery();
      while (result.next()) {
        brand = this.searchBrandById(result.getShort("brand_id"));
        if (brand != null) {
          product = new Product();
          product.setProductId(result.getInt("product_id"));
          product.setProductName(result.getString("product_name"));
          product.setActualPrice(result.getFloat("actual_price"));
          product.setFlagState(result.getBoolean("flag_state"));
          product.setBrand(brand);
          listProducts.add(product);
        } else {
          throw new SQLException("ERROR SQL: 'Brand' object empty");
        }
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to fetch all 'Product' objects: " + exc.getMessage());
    }
    return listProducts;
  }
}
