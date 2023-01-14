package io.scout.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Guillermo, Gómez
 */
public class DBConnection {

  private final String URL = "jdbc:mysql://localhost:3306/oakBarDB";
  private final String USER = "root";
  private final String PASSWORD = "root*123Admin";

  public DBConnection() {}

  public Connection getConnection() {
    Connection connection = null;
    try {
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch(SQLException exc) {
      System.err.println("ERROR: Fail connection: " + exc.getMessage());
    }
    return connection;
  }
}
