package DBhospital;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Person.*;


public class DoctorPersistency {
  private static Doctor doctoquery;

  public static void setDoctor(Doctor doc) {
    DoctorPersistency.doctoquery = new Doctor(doc);
  }

  public static void register() throws SQLException {
    PreparedStatement query = Connector.myConnection
        .prepareStatement("INSERT INTO DOCTOR(PERSON_ID, CRM, SPECIALITY, PAYMENT)" + "VALUES (?, ?, ?)");
    query.setInt(1, 234);
    query.setInt(2, doctoquery.crm);
    query.setDouble(3, 12.45);
    query.execute();
  }

  public static void update() {
  }

  public static void delete() {
  }

  public static ArrayList<Doctor> query() {
    return new ArrayList<>();
  }

}