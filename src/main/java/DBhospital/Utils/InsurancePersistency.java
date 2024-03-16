package DBhospital.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DBhospital.Connector;
import Person.Pacient;

public class InsurancePersistency {
  public static void register(Pacient pacient, int id) {
    Connection conn = Connector.getMyConnection();

    String statemant = new String("INSERT INTO INSURANCE (PACIENT_ID, ISRC_NAME, PAYMENT)");
    try (PreparedStatement insert = conn.prepareStatement(statemant + "VALUES(?, ?, ?)")) {
      insert.setInt(1, id);
      insert.setString(2, pacient.plan.name);
      insert.setDouble(3, pacient.plan.monthlypayment);
      insert.execute();
      conn.commit();
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + e.getLocalizedMessage() + " deu errado");
    }
  }

  public static void update() {
  }

  public static void delete() {
  }

  public static ArrayList<Pacient> Doctorquery() {
    return new ArrayList<>();
  }

}
