package DBhospital.Persons;

import java.sql.Statement;

import DBhospital.Connector;
import DBhospital.Utils.AddresPersistency;
import Person.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonPersistance {

  public static int insert(String type, Person person) {
    type.toUpperCase();
    int mykey = -1;
    Connection con = Connector.getMyConnection();
    String insertstr = new String("INSERT INTO PERSON (BIRTH, NAM, ADDRES_NUM, ADDRES_CEP, PERSON_TYPE)");
    AddresPersistency.register(person.addres);
    try (PreparedStatement insert = con
        .prepareStatement(insertstr + "VALUES (?, ?, ?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS);) {
      insert.setString(1, person.birthdate);
      insert.setString(2, person.name);
      insert.setInt(3, person.addres.number);
      insert.setInt(4, person.addres.code);
      insert.setString(5, type.toString());
      insert.executeUpdate();
      con.commit();
      ResultSet key = insert.getGeneratedKeys();
      if (key.next()) {
        mykey = key.getInt(1);
        return mykey;
      }

    } catch (SQLException e) {
      System.out.println(e.getSQLState() + e.getLocalizedMessage() + " deu errado");
      System.out.println(person.addres.code);
    }
    return mykey;
  }

  public static void update(Person person) {
    String sttm = new String("");
  }
}
