package DB;

import java.sql.*;

import org.junit.Test;

import DBhospital.*;
import DBhospital.Persons.PacientPersistency;
import Person.*;
import Utils.*;

public class ConnectorTest {
  @Test
  public void testconnection() {
    Connection myConnection = Connector.getMyConnection();
    try {
      String a = myConnection.getCatalog();
      System.out.println(a);
    } catch (Exception e) {
      System.out.println("bbbbbb");
    }
  }

  @Test
  public void testinsert() {
    Addres addr = new Addres("logradouro", "são vicente", 6509, 877);
    try {
      Person person = new Person("luis", "04-12-2003", addr);
      // SpecialityPersistency.insert(4785, "fisio", "doctor");
      Doctor doc = new Doctor(person, new Speciality("legal", "luis"), 12.44, 2202);
      Healthinsurance plan = new Healthinsurance("bradesco", 400.5);
      Pacient pacient = new Pacient(person, "39093992821", plan);
      PacientPersistency.register(pacient);
    } catch (Exception e) {
      System.out.println("date ex");
    }
    try {
      Connector.getMyConnection().commit();
    } catch (SQLException e) {
      System.out.println(e.getSQLState());
      throw new AssertionError();
    }

  }
}
