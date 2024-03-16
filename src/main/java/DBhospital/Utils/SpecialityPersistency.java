package DBhospital.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import DBhospital.Connector;

public final class SpecialityPersistency {

  public static void insert(Integer crm, String... data) {
    Connection con = Connector.getMyConnection();
    String insertstr = new String("INSERT INTO SPECIALITY (CRM, SPT1, SPT2, SPT3)");
    try (PreparedStatement insert = con
        .prepareStatement(insertstr + "VALUES (?, ?, ?, ?)");) {
      int counter = 1;
      insert.setInt(counter, crm);
      for (String string : data) {
        counter++;
        insert.setString(counter, string);
      }
      switch (counter) {
        case 2:
          insert.setNull(3, Types.VARCHAR);
          insert.setNull(4, Types.VARCHAR);
          break;
        case 3:
          insert.setNull(4, Types.VARCHAR);
          break;

        default:
      }
      insert.execute();
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + "deu errado");
    }
  }

}
