package DBhospital.Persons;

import java.sql.*;

import DBhospital.Connector;
import DBhospital.Utils.*;
import Person.*;

public final class PacientPersistency {
  private static PreparedStatement insertStatement;
  private static PreparedStatement deleteStatement;
  private static PreparedStatement selectStatement;

  static {
    try {
      insertStatement = Connector.getMyConnection()
          .prepareStatement("INSERT INTO PACIENT (PERSON_ID, CPF)" + "VALUES(?, ?)");
      deleteStatement = Connector.getMyConnection().prepareStatement(
          """
                DELETE  PA, PE, AD, IR
                FROM `PACIENT` AS PA
                LEFT JOIN `PERSON` AS PE
                ON PA.`PERSON_ID` = PE.`PERSON_ID`
                LEFT JOIN `ADDRES` AS AD
                ON `AD`.`CEP` = PE.`ADDRES_CEP` AND AD.`NUM` = PE.`ADDRES_NUM`
                LEFT JOIN `INSURANCE` AS IR
                ON IR.`PACIENT_ID` = PA.`CPF`
                 WHERE `PA`.`CPF` = ?
              """);
      selectStatement = Connector.getMyConnection().prepareStatement("""
          SELECT * FROM `PACIENT` PA
          LEFT JOIN `PERSON` PE
          ON PA.`PERSON_ID` = PE.`PERSON_ID`
          LEFT JOIN `ADDRES` AD
          ON PE.`ADDRES_CEP` = AD.`CEP` AND PE.`ADDRES_NUM` = AD.`NUM`
          LEFT JOIN `INSURANCE` IR
          ON IR.`PACIENT_ID` = PA.`CPF` WHERE PE.? = ?
                          """);
    } catch (SQLException exception) {
      System.err.println("error instantiating pacient  " + exception.getSQLState() + exception.getMessage());
    }
  }

  public static void register(Pacient pacient) throws SQLException {
    int personid = PersonPersistance.insert("pacient", pacient);
    insertStatement.setInt(1, personid);
    insertStatement.setString(2, pacient.cpf);
    insertStatement.executeUpdate();
    InsurancePersistency.register(pacient);

  }

  public static int update(String oldcpf, Pacient pacient) throws SQLException {
    Connection myConnection = Connector.getMyConnection();
    InsurancePersistency.update(pacient);
    Integer id = getpersonid(oldcpf);
    PersonPersistance.update(pacient, "PACIENT", id);
    PreparedStatement update = myConnection.prepareStatement("UPDATE PACIENT SET CPF=? WHERE CPF=?");
    update.setString(1, pacient.cpf);
    update.setString(2, oldcpf);
    return update.executeUpdate();
  }

  public static int delete(Pacient pacient) throws SQLException {
    deleteStatement.setString(1, pacient.cpf);
    return deleteStatement.executeUpdate();
  }

  public static ResultSet getpacientset(String cpf) throws SQLException {
    selectStatement.setString(1, cpf);
    return selectStatement.executeQuery();
  }

  public static Integer getpersonid(String cpf) throws SQLException {
    String selectString = "SELECT PERSON_ID FROM PACIENT WHERE CPF=?";
    PreparedStatement select = Connector.getMyConnection().prepareStatement(selectString);
    select.setString(1, cpf);
    ResultSet tuple = select.executeQuery();
    if (tuple.next()) {
      return tuple.getInt(1);
    } else {

    }
    return null;
  }

}
