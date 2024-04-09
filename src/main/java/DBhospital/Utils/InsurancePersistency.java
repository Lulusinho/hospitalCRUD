package DBhospital.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DBhospital.Connector;
import Person.Pacient;

public class InsurancePersistency {
  public static void register(Pacient pacient) throws SQLException {
    Connection conn = Connector.getMyConnection();

    String statemant = new String("INSERT INTO INSURANCE (PACIENT_ID, ISRC_NAME, PAYMENT)");
    PreparedStatement insert = conn.prepareStatement(statemant + "VALUES(?, ?, ?)");
    insert.setString(1, pacient.cpf);
    insert.setString(2, pacient.plan.name);
    insert.setDouble(3, pacient.plan.monthlypayment);
    insert.execute();
  }

  public static void update(Pacient pacient) {

  }

  public static void delete() {
  }

  public static ArrayList<Pacient> InsuranceQuery() {
    return new ArrayList<>();
  }

}
