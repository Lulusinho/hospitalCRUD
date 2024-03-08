package actions;

import java.util.ArrayList;
import java.util.Date;

import Person.Doctor;
import Person.Pacient;

public class Procedure {
  public ProcedureType pt;
  public Pacient pacient;
  public Doctor doc;
  public Date date;
  public Integer durationtime;

  private Procedure( Pacient pacient, Doctor doc, Date date, Integer durationtime) {
    this.pacient = new Pacient(pacient);
    this.doc = new Doctor(doc);
    this.date = new Date(date.getTime());
    this.durationtime = durationtime;
  }
  //TODO: CSV
  public void marcar(Doctor med, Pacient pacient, Date date) {
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