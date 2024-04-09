package DBhospital.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DBhospital.Connector;
import Utils.Addres;

public final class AddresPersistency {

  public static void register(Addres addres) throws SQLException {
    Connection myConnection = Connector.getMyConnection();
    PreparedStatement insertstm = myConnection
        .prepareStatement("INSERT INTO ADDRES (PUBLIC_AREA, DISTRICT, NUM, CEP)"
            + "VALUES (?, ?, ?, ?)");
    insertstm.setString(1, addres.public_area);
    insertstm.setString(2, addres.district);
    insertstm.setInt(3, addres.number);
    insertstm.setInt(4, addres.code);
    insertstm.execute();
  }

  public static void update(Addres addres) throws SQLException {
    Connection myConnection = Connector.getMyConnection();
    PreparedStatement updtsttm = myConnection
        .prepareStatement("UPDATE ADDRES SET PUBLIC_AREA=?, DISTRICT=?, NUM=?, CEP=?");
    updtsttm.setString(1, addres.public_area);
    updtsttm.setString(2, addres.district);
    updtsttm.setInt(3, addres.number);
    updtsttm.setInt(4, addres.code);
    updtsttm.executeUpdate();
  }

  public static void delete() {
  }

  public static ArrayList<Addres> AddresQuery() {
    return new ArrayList<>();
  }

}
