package DBhospital.Persons;

import java.sql.*;
import java.util.ArrayList;

import DBhospital.Connector;
import DBhospital.Utils.SpecialityPersistency;
import Person.*;

public final class DoctorPersistency {

  public static void register(Doctor doc) {
    Connection conn = Connector.getMyConnection();
    SpecialityPersistency.insert(doc.crm, doc.doctorSpeciality.getName());
    int personid = PersonPersistance.insert("doctor", doc);
    String statemant = new String("INSERT INTO DOCTOR (CRM, PAYMENT, PERSON_ID)");
    try (PreparedStatement insert = conn.prepareStatement(statemant + "VALUES(?, ?, ?)")) {
      insert.setInt(1, doc.crm);
      insert.setDouble(2, doc.payment);
      insert.setInt(3, personid);
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

  public static ArrayList<Doctor> Doctorquery() {
    return new ArrayList<>();
  }

}