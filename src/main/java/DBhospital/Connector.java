package DBhospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connector {
  private static Connection myConnection;
  public static boolean isclosed = true;

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOSPITAL", "root", "luislindo");
      isclosed = false;
      myConnection.setAutoCommit(false);
    } catch (ClassNotFoundException | SQLException sqle) {
      System.out.println(sqle.getMessage() + "Driver not found");
      System.exit(1);
    }

  }

  public static Connection getMyConnection() {
    return myConnection;
  }

  public static void close() {
    try {
      myConnection.close();
    } catch (SQLException e) {
      System.err.println(e.getMessage() + "ERROR on close");
    }
  }

}
