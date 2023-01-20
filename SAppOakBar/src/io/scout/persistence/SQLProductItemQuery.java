package io.scout.persistence;

import io.scout.model.Detail;
import io.scout.model.Product;
import io.scout.model.ProductItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Guillermo, Gómez
 */
public class SQLProductItemQuery {

  private DBConnection connection = null;

  private Product searchProductById(int id) {
    Product product = null;
    SQLProductQuery querys = null;
    querys = new SQLProductQuery();
    product = querys.getProductById(id);
    return product;
  }

  private Detail searchDetailById(long id) {
    Detail detail = null;
    SQLDetailQuery querys = null;
    querys = new SQLDetailQuery();
    detail = querys.getDetailById(id);
    return detail;
  }

  public void saveProductItem(boolean flagSold, int productId, long detailId) {
    this.connection = new DBConnection();
    Product product = null;
    String statement = "INSERT INTO product_items(elaboration_date, price, flag_sold, flag_state, product_id, detail_id) VALUES (CURRENT_TIMESTAMP, ?, ?, TRUE, ?, ?)";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      product = this.searchProductById(productId);
      if (product != null) {
        query = conn.prepareStatement(statement);
        query.setFloat(1, product.getActualPrice());
        query.setBoolean(2, flagSold);
        query.setInt(3, productId);
        query.setLong(4, detailId);
        query.executeUpdate();
      } else {
        throw new SQLException("ERROR SQL: Empty 'Product' object");
      }
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to save 'ProductItem' object: " + exc.getMessage());
    }
  }

  public void updateProductItem(long id, boolean flagSold, int productId, long detailId) {
    this.connection = new DBConnection();
    String statement = "UPDATE product_items SET flag_sold = ?, product_id = ?, detail_id = ? WHERE ((flag_state = TRUE) AND (product_item_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setBoolean(1, flagSold);
      query.setInt(2, productId);
      query.setLong(3, detailId);
      query.setLong(4, id);
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to update 'ProductItem' object: " + exc.getMessage());
    }
  }

  public void eraseProductItem(long id) {
    this.connection = new DBConnection();
    String statement = "UPDATE product_items SET flag_state = FALSE WHERE ((flag_state = TRUE) AND (product_item_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setLong(1, id);
      query.executeQuery();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to erase 'ProductItem' object: " + exc.getMessage());
    }
  }

  /*public void deleteProductItem(long id) {
    this.connection = new DBConnection();
    String statement = "DELETE FROM product_items WHERE ((flag_state = TRUE) AND (product_item_id = ?))";
    PreparedStatement query = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setLong(1, id);
      query.executeUpdate();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to delete 'ProductItem' object: " + exc.getMessage());
    }
  }*/

  public ProductItem getProductItemById(long id) {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM product_items WHERE ((flag_state = TRUE) AND (product_item_id = ?))";
    PreparedStatement query = null;
    ResultSet result = null;
    Product product = null;
    Detail detail = null;
    ProductItem productItem = null;
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setLong(1, id);
      result = query.executeQuery();
      productItem = new ProductItem();
      while (result.next()) {
        product = this.searchProductById(result.getInt("product_id"));
        detail = this.searchDetailById(result.getLong("detail_id"));
        if ((product != null) && (detail != null)) {
          productItem.setProductItemId(result.getInt("product_item_id"));
          productItem.setElaboratinDate(result.getDate("elaboration_date"));
          productItem.setPrice(result.getFloat("price"));
          productItem.setFlagSold(result.getBoolean("flag_sold"));
          productItem.setFlagState(result.getBoolean("flag_state"));
          productItem.setProduct(product);
          productItem.setDetail(detail);
        } else {
          throw new SQLException("ERROR SQL: 'Product' or 'Detail' object are empty");
        }
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to fetch 'ProductItem' object: " + exc.getMessage());
    }
    return productItem;
  }

  public List<ProductItem> getAllProductItems() {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM product_items ORDER BY elaboration_date";
    PreparedStatement query = null;
    ResultSet result = null;
    Product product = null;
    Detail detail = null;
    ProductItem productItem = null;
    List<ProductItem> listProductItems = new ArrayList<ProductItem>();
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      result = query.executeQuery();
      while (result.next()) {
        product = this.searchProductById(result.getInt("product_id"));
        detail = this.searchDetailById(result.getLong("detail_id"));
        if ((product != null) && (detail != null)) {
          productItem = new ProductItem();
          productItem.setProductItemId(result.getLong("product_item_id"));
          productItem.setPrice(result.getFloat("price"));
          productItem.setFlagSold(result.getBoolean("flag_sold"));
          productItem.setFlagState(result.getBoolean("flag_state"));
          productItem.setProduct(product);
          productItem.setDetail(detail);
          listProductItems.add(productItem);
        } else {
          throw new SQLException("ERROR SQL: 'Product' or 'Detail' object ");
        }
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to fetch all 'ProductItem' objects");
    }
    return listProductItems;
  }

  public List<ProductItem> getAllProductItemsByState(boolean flagState) {
    this.connection = new DBConnection();
    String statement = "SELECT * FROM product_items WHERE (flag_state = ?) ORDER BY elaboration_date";
    PreparedStatement query = null;
    ResultSet result = null;
    Product product = null;
    Detail detail = null;
    ProductItem productItem = null;
    List<ProductItem> listProductItems = new ArrayList<ProductItem>();
    try (Connection conn = this.connection.getConnection()) {
      query = conn.prepareStatement(statement);
      query.setBoolean(1, flagState);
      result = query.executeQuery();
      while (result.next()) {
        product = this.searchProductById(result.getInt("product_id"));
        detail = this.searchDetailById(result.getLong("detail_id"));
        if ((product != null) && (detail != null)) {
          productItem = new ProductItem();
          productItem.setProductItemId(result.getLong("product_item_id"));
          productItem.setPrice(result.getFloat("price"));
          productItem.setFlagSold(result.getBoolean("flag_sold"));
          productItem.setFlagState(result.getBoolean("flag_state"));
          productItem.setProduct(product);
          productItem.setDetail(detail);
          listProductItems.add(productItem);
        } else {
          throw new SQLException("ERROR SQL: 'Product' or 'Detail' object ");
        }
      }
      result.close();
      query.close();
    } catch (SQLException exc) {
      System.err.println("ERROR SQL: Fail to fetch all 'ProductItem' objects");
    }
    return listProductItems;
  }
}
