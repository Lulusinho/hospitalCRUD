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

  public static int insert(String type, Person person) throws SQLException {
    type.toUpperCase();
    int mykey = -1;
    Connection con = Connector.getMyConnection();
    String insertstr = new String("INSERT INTO PERSON (BIRTH, NAM, ADDRES_NUM, ADDRES_CEP, PERSON_TYPE)");
    AddresPersistency.register(person.addres);
    PreparedStatement insert = con
        .prepareStatement(insertstr + "VALUES (?, ?, ?, ?, ?)",
            Statement.RETURN_GENERATED_KEYS);
    insert.setString(1, person.birthdate);
    insert.setString(2, person.name);
    insert.setInt(3, person.addres.number);
    insert.setInt(4, person.addres.code);
    insert.setString(5, type.toString());
    insert.executeUpdate();
    ResultSet key = insert.getGeneratedKeys();
    if (key.next()) {
      mykey = key.getInt(1);
      return mykey;
    }
    return mykey;
  }

  public static int update(Person person, String type, int id) throws SQLException {
    type.toUpperCase();
    AddresPersistency.update(person.addres);
    String uptstr = "UPDATE PERSON SET NAM = ?, BIRTH = ?, ADDRES_NUM = ?, ADDRES_CEP = ?, PERSON_TYPE = ? WHERE PERSON_ID = ?";
    PreparedStatement stmt = Connector.getMyConnection().prepareStatement(uptstr);
    stmt.setString(1, person.name);
    stmt.setString(2, person.birthdate);
    stmt.setInt(3, person.addres.number);
    stmt.setInt(4, person.addres.code);
    stmt.setString(5, type);
    stmt.setInt(6, id);
    return stmt.executeUpdate();
  }

}
