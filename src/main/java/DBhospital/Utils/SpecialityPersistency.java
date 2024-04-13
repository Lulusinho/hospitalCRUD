package DBhospital.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import DBhospital.Connector;

public final class SpecialityPersistency {

  public static void insert(Integer crm, String... data) throws SQLException {
    Connection con = Connector.getMyConnection();
    String insertstr = new String("INSERT INTO SPECIALITY (CRM, SPT1, SPT2, SPT3)");
    PreparedStatement insert = con
        .prepareStatement(insertstr + "VALUES (?, ?, ?, ?)");
    int counter = 1;
    insert.setInt(1, crm);
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
        break;
    }
    insert.executeUpdate();
  }

  public static void update(Integer crm, Integer oldcrm, String... data) throws SQLException {
    PreparedStatement update = Connector.getMyConnection()
        .prepareStatement("UPDATE SPECIALITY SET SPT1=?, SPT2=?, SPT3=?, CRM=?  WHERE CRM=?");
    switch (data.length) {
      case 1:
        update.setString(1, data[0]);
        update.setNull(2, Types.VARCHAR);
        update.setNull(3, Types.VARCHAR);

        break;
      case 2:
        update.setString(1, data[0]);
        update.setString(2, data[1]);
        update.setNull(3, Types.VARCHAR);

        break;
      case 3:
        update.setString(1, data[0]);
        update.setString(2, data[1]);
        update.setString(3, data[2]);

        break;

      default:
        return;
    }
    update.setInt(4, crm);
    update.setInt(5, oldcrm);
    update.executeUpdate();
  }

}
