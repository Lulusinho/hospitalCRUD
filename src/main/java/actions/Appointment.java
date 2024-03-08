package actions;

import java.util.Date;
import java.util.ArrayList;

import Person.*;

public class Appointment {
  Pacient pacient;
  Doctor doc;
  Date date;

  // TODO: CSV
  public void marcar(Doctor med, Pacient pacient, Date date) {
  }

  public void cancelar(Appointment object) {
  }

  public ArrayList<Appointment> pesquisarPorPaciente(Pacient pacient) {
    return new ArrayList<Appointment>();
  }

}
