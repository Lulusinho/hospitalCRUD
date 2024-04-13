package DBhospital.Utils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import DBhospital.Connector;
import actions.Procedure;

public final class ProcedurePersistency {
  private static PreparedStatement insertstm;
  private static PreparedStatement deletestm;

  static {
    var con = Connector.getMyConnection();
    try {

      insertstm = con.prepareStatement("""
              INSERT INTO
              `HOSPITAL_PROCEDURE`
              (`PACIENT_ID`, `DOCTOR_ID`, `PROCEDURE_DATE`, `PRICE`, `DURATION`, `ROOM`, `PROCEDURE_TYPE`)
              VALUES(?, ?, ?, ?, ?, ?, ?)
          """);
      deletestm = con.prepareStatement("""
          DELETE HP
          FROM `HOSPITAL_PROCEDURE` HP
          WHERE `HP`.`DOCTOR_ID`= ? AND `HP`.`PACIENT_ID`= ? AND `HP`.`ROOM`=?
            """);

    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
    }
  }

  public static int insert(Procedure procedure, String room) throws SQLException {
    insertstm.setString(1, procedure.pacient.cpf);
    insertstm.setInt(2, procedure.doc.crm);
    insertstm.setString(3, procedure.date);
    insertstm.setDouble(4, procedure.cost);
    insertstm.setDouble(5, procedure.durationtime);
    insertstm.setString(6, room);
    insertstm.setString(7, procedure.type);
    return insertstm.executeUpdate();
  }

  public static int delete(Procedure object) throws SQLException {
    deletestm.setInt(1, object.doc.crm);
    deletestm.setString(2, object.pacient.cpf);
    deletestm.setString(3, object.room);
    return deletestm.executeUpdate();
  }
}
