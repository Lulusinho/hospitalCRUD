package actions;

import java.util.ArrayList;

import DBhospital.DAO;
import Person.*;

public class Appointment {
  private Pacient pacient;
  private Doctor doc;
  private String date;

  public Appointment() {
  }

  public Appointment(Pacient pacient, Doctor doc, String date) {
    this.pacient = new Pacient(pacient);
    this.doc = new Doctor(doc);
    this.date = new String(date);

  }

  public void save() {
    DAO.save(this);

  }

  public void update(Appointment newdata) {
    DAO.update(newdata, this.doc.crm, this.pacient.cpf);
    this.date = newdata.date;
    this.doc = newdata.doc;
    this.pacient = newdata.pacient;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setDoc(Doctor doc) {
    this.doc = doc;
  }

  public void setPacient(Pacient pacient) {
    this.pacient = pacient;
  }

  public Doctor getDoc() {
    return doc;
  }

  public String getDate() {
    return date;
  }

  public Pacient getPacient() {
    return pacient;
  }

  public void cancelar() {
    DAO.delete(this);
  }

  public ArrayList<Appointment> pesquisarPorPaciente(Pacient pacient) {
    return new ArrayList<Appointment>();
  }

}
