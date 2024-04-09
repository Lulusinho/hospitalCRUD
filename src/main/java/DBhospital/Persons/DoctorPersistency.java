package DBhospital.Persons;

import java.sql.*;

import DBhospital.Connector;
import DBhospital.Utils.SpecialityPersistency;
import Person.*;

public final class DoctorPersistency {
  private static PreparedStatement insert;
  private static PreparedStatement deletestm;
  private static PreparedStatement select;

  static {
    try {
      insert = Connector.getMyConnection()
          .prepareStatement("INSERT INTO DOCTOR (CRM, PAYMENT, PERSON_ID)" + "VALUES(?, ?, ?)");
      deletestm = Connector.getMyConnection().prepareStatement(
          """
              DELETE AD, PE, DOC, SP
              FROM `DOCTOR` DOC
              LEFT JOIN `PERSON` PE ON DOC.`PERSON_ID` = PE.`PERSON_ID`
              LEFT JOIN `SPECIALITY` SP ON SP.`CRM` = DOC.CRM
              LEFT JOIN `ADDRES` AD ON AD.`CEP` = PE.`ADDRES_CEP` AND AD.NUM = PE.`ADDRES_NUM`
              WHERE DOC.`CRM` = ?
                  """);
      select = Connector.getMyConnection().prepareStatement("""
          SELECT *
          FROM `DOCTOR` DOC
          LEFT JOIN `PERSON` PE ON DOC.`PERSON_ID` = PE.`PERSON_ID`
          LEFT JOIN `SPECIALITY` SP ON SP.`CRM` = DOC.CRM
          LEFT JOIN `ADDRES` AD ON AD.`CEP` = PE.`ADDRES_CEP` AND AD.NUM = PE.`ADDRES_NUM`
           WHERE DOC.`CRM` = ?
            """);
    } catch (SQLException e) {
      System.err.println("error instantiating doctor  " + e.getSQLState() + e.getMessage());
    }
  }

  public static void register(Doctor doc) throws SQLException {
    SpecialityPersistency.insert(doc.crm, doc.doctorSpeciality.getName());
    int personid = PersonPersistance.insert("doctor", doc);
    insert.setInt(1, doc.crm);
    insert.setDouble(2, doc.payment);
    insert.setInt(3, personid);
    insert.execute();
  }

  public static int update(Doctor newdata, int oldcrm) throws SQLException {
    SpecialityPersistency.update(newdata.crm, oldcrm, newdata.doctorSpeciality.name);
    PersonPersistance.update(newdata, "DOCTOR", getpersonid(oldcrm));
    PreparedStatement update = Connector.getMyConnection().prepareStatement("UPDATE DOCTOR SET CRM=?, PAYMENT=?");
    update.setInt(1, newdata.crm);
    update.setDouble(2, newdata.payment);
    return update.executeUpdate();
  }

  public static int delete(Doctor doctortodelete) throws SQLException {
    deletestm.setInt(1, doctortodelete.crm);
    return deletestm.executeUpdate();
  }

  public static ResultSet Doctorquery(int crm) throws SQLException {
    select.setInt(1, crm);
    return select.executeQuery();
  }

  public static Integer getpersonid(Integer crm) throws SQLException {
    PreparedStatement select = Connector.getMyConnection().prepareStatement("SELECT PERSON_ID FROM DOCTOR WHERE CRM=?");
    select.setInt(1, crm);
    ResultSet tuple = select.executeQuery();
    if (tuple.next()) {
      return tuple.getInt(1);
    }
    return null;
  }

}