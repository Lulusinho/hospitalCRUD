package DBhospital.Persons;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DBhospital.Connector;
import DBhospital.Utils.InsurancePersistency;
import Person.Pacient;

public class PacientPersistency {
  public static void register(Pacient pacient) {
    Connection conn = Connector.getMyConnection();
    int personid = PersonPersistance.insert("pacient", pacient);
    String statemant = new String("INSERT INTO PACIENT (PERSON_ID, CPF)");
    try (PreparedStatement insert = conn.prepareStatement(statemant + "VALUES(?, ?)")) {
      insert.setInt(1, personid);
      insert.setString(2, pacient.cpf);
      insert.execute();
      conn.commit();
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + e.getLocalizedMessage() + " deu errado");
    }
    InsurancePersistency.register(pacient, personid);
  }

  public static void update() {
  }

  public static void delete() {
  }

  public static ArrayList<Pacient> Doctorquery() {
    return new ArrayList<>();
  }

}
