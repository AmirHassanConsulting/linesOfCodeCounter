package com.exxeta.loccounter.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

  /**
   * This method generates a database connection.
   *
   * @param url      The URL of the database
   * @param username The username for the database connection
   * @param password The password for the database connection
   * @return The database connection object
   * @throws SQLException If an error occurs while establishing the connection
   */
  public static Connection generateConnection(String url, String username, String password)
      throws SQLException {
    try {
      // Load the JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      // Establish the database connection
      Connection connection = DriverManager.getConnection(url, username, password);

      return connection;
    } catch (ClassNotFoundException e) {
      // Log the error
      System.out.println("Error: Failed to load JDBC driver");
      e.printStackTrace();
      throw new SQLException("Failed to load JDBC driver");
    } catch (SQLException e) {
      // Log the error
      System.out.println("Error: Failed to establish database connection");
      e.printStackTrace();
      throw e;
    }
  }
}
