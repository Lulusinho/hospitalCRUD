package DBhospital.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import DBhospital.Connector;
import Utils.Addres;

public final class AddresPersistency {

  public static void register(Addres addres) {
    Connection myConnection = Connector.getMyConnection();
    if (myConnection == null) {
      System.out.println("ELE É NULL");
      return;
    }
    try (PreparedStatement insertstm = myConnection
        .prepareStatement("INSERT INTO ADDRES (PUBLIC_AREA, DISTRICT, NUM, CEP)"
            + "VALUES (?, ?, ?, ?)")) {
      insertstm.setString(1, addres.public_area);
      insertstm.setString(2, addres.district);
      insertstm.setInt(3, addres.number);
      insertstm.setInt(4, addres.code);
      insertstm.execute();
      myConnection.commit();
    } catch (Exception e) {
      System.err.println("erro ao inserir" + e.getLocalizedMessage());
      System.err.println(e.getMessage());
      System.exit(-2);
    }

  }

  public static void update(Addres addres) {}

  public static void delete() {
  }

  public static ArrayList<Addres> AddresQuery() {
    return new ArrayList<>();
  }

}
