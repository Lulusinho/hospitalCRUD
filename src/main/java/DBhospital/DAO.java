package DBhospital;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Person.*;
import actions.*;
import DBhospital.Persons.*;
import DBhospital.Utils.ProcedurePersistency;

public final class DAO {
  private static PreparedStatement apptinsert;
  private static PreparedStatement appupdate;
  private static PreparedStatement appdelete;

  static {
    var con = Connector.getMyConnection();
    try {
      apptinsert = con.prepareStatement(
          "INSERT INTO `APPOINTMENT`( `PACIENT_ID`, `DOCTOR_ID`, `APPOINTMENT_DATE`) VALUES(?, ?, ?)");
      appupdate = con.prepareStatement(
          "UPDATE `APPOINTMENT` SET `APPOINTMENT_DATE`=?, `DOCTOR_ID`=?, `PACIENT_ID`=? WHERE `DOCTOR_ID` = ? AND `PACIENT_ID` = ?");
      appdelete = con.prepareStatement(
          "DELETE AP FROM `APPOINTMENT` AP WHERE `PACIENT_ID` = ? AND `DOCTOR_ID` = ?");
    } catch (SQLException e) {
      System.err.println("error instantiating DAO  " + e.getSQLState() + e.getMessage());
    }
  }

  public static boolean save(Pacient Object) {
    try {
      PacientPersistency.register(Object);
      Connector.getMyConnection().commit();
      return true;
    } catch (SQLException e) {
      return false;
    }

  }

  public static boolean save(Doctor Object) {
    try {
      DoctorPersistency.register(Object);
      Connector.getMyConnection().commit();
      return true;
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
      throw new RuntimeException();
    }

  }

  public static void save(Appointment Object) {
    try {
      apptinsert.setString(1, Object.getPacient().cpf);
      apptinsert.setInt(2, Object.getDoc().crm);
      apptinsert.setString(3, Object.getDate());
      apptinsert.executeUpdate();
      Connector.getMyConnection().commit();
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
      throw new RuntimeException();
    }

  }

  public static void save(Procedure Object) {
    try {
      ProcedurePersistency.insert(Object, Object.room);
      Connector.getMyConnection().commit();
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
      throw new RuntimeException();
    }

  }

  public static boolean delete(Pacient Object) {
    try {
      int result = PacientPersistency.delete(Object);
      if (result > 0) {
        Connector.getMyConnection().commit();
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
      return false;
    }
  }

  public static boolean delete(Doctor Object) {
    try {
      int result = DoctorPersistency.delete(Object);
      Connector.getMyConnection().commit();
      if (result > 0) {
        System.out.println("LUIS");
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
      return false;
    }
  }

  public static void delete(Appointment Object) {
    try {
      appdelete.setString(1, Object.getPacient().cpf);
      appdelete.setInt(2, Object.getDoc().crm);
      appdelete.executeUpdate();
      Connector.getMyConnection().commit();
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
    }

  }

  public static void delete(Procedure Object) {
    try {
      ProcedurePersistency.delete(Object);
      Connector.getMyConnection().commit();
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
    }
  }

  public static boolean update(Pacient Object, String oldcpf) {
    try {
      int result = PacientPersistency.update(oldcpf, Object);
      if (result > 0) {
        Connector.getMyConnection().commit();
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      return false;
    }

  }

  public static boolean update(Doctor newdoc, int oldcrm) {
    try {
      int result = DoctorPersistency.update(newdoc, oldcrm);
      if (result > 0) {
        Connector.getMyConnection().commit();
        return true;
      } else {
        return false;
      }
    } catch (SQLException e) {
      return false;
    }

  }

  public static void update(Appointment newdata, int oldcrm, String pacient) {
    try {
      appupdate.setString(1, newdata.getDate());
      appupdate.setInt(2, newdata.getDoc().crm);
      appupdate.setString(3, newdata.getPacient().cpf);
      appupdate.setInt(4, oldcrm);
      appupdate.setString(5, pacient);
      appupdate.executeUpdate();
      Connector.getMyConnection().commit();
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
    }

  }

  public static void update(Procedure object, Procedure oldobject) {
    try {
      ProcedurePersistency.delete(oldobject);
      ProcedurePersistency.insert(object, object.room);

      Connector.getMyConnection().commit();
    } catch (SQLException e) {
      System.out.println(e.getSQLState() + " " + e.getErrorCode());
      e.printStackTrace();
      throw new RuntimeException();
    }

  }

}
