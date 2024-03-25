package actions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import DBhospital.Connector;
import Person.*;

public class Procedure {
  public ProcedureType pt;
  public Pacient pacient;
  public Doctor doc;
  public String date;
  public Integer durationtime;

  private Procedure(Pacient pacient, Doctor doc, String date, Integer durationtime) {
    this.pacient = new Pacient(pacient);
    this.doc = new Doctor(doc);
    this.date = new String(date);
    this.durationtime = durationtime;
  }

  public void marcar(Doctor med, Pacient pacient, String date) {
    Connection myConnection = Connector.getMyConnection();
    if (myConnection == null) {
      System.out.println("ELE É NULL");
      return;
    }
    try (PreparedStatement insertstm = myConnection
        .prepareStatement(
            "INSERT INTO ADDRES (PACIENT_ID, DOCTOR_ID, PROCEDURE_DATE, PRICE, DURATION, ROOM, PROCEDURE_TYPE)"
                + "VALUES (?, ?, ?, ?)")) {

      insertstm.execute();
      myConnection.commit();
    } catch (Exception e) {
      System.err.println("erro ao inserir" + e.getLocalizedMessage());
      System.err.println(e.getMessage());
      System.exit(-2);
    }

  }

  public void cancelar(Procedure object) {
  }

  public ArrayList<Doctor> pesquisarPorMedico(Pacient object) {
    return new ArrayList<Doctor>();
  }

  public double totalvalue() {
    return (double) (this.doc.payment * this.durationtime) + this.pt.price;
  };

  public enum ProcedureType {
    FARINGOPLATIA(1500), NEUROCIRURGIA(1000);

    public final double price;

    private ProcedureType(int procedureCost) {
      this.price = procedureCost;
    }
  }

}