package DBhospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connector {
  public static Connection myConnection = null;
  public static boolean isclosed = true;
  public static String currentQuery;

  private Connector() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");

    } catch (ClassNotFoundException e) {
      System.out.println(e.getMessage() + "Driver not found");
      System.exit(1);
    }
  }

  public static void setconnection(String url, String user, String password) {
    try {
      myConnection = DriverManager.getConnection(url, user, password);
      isclosed = false;
    } catch (SQLException e) {
      System.err.println(e.getMessage() + "Connectivity issues");
      System.exit(1);
    }
  }

  public static void close() {
    try {
      myConnection.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage() + "ERROR on close");
    }
  }

}
