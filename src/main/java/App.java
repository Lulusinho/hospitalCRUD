import Person.*;
import Utils.Addres;
import Utils.Healthinsurance;
import Utils.Speciality;
import actions.Appointment;
import actions.Procedure;
import DBhospital.DAO;

public class App {
  public static void main(String[] args) {
    Person person = new Person("Luis", "nasci", new Addres("nova Barra", "barra do garças", 123, 321));
    Doctor doc = new Doctor(person, new Speciality("fisio", "cardio"), 12.45, 444);
    DAO.save(doc);
    person.addres = new Addres("centro", "barra", 321, 123);
    person.name = "roberto";
    Pacient pacient = new Pacient(person, "39093992821", new Healthinsurance("bradesco", 127.00));
    DAO.save(pacient);
    Procedure procedure = new Procedure.ProcedureBuilder().setCost(60, 12.5).setDate("24/12").setDoctor(doc)
        .setPacient(pacient).setType("FARINGOPLASTIA").setroom("sala").build();
    DAO.save(procedure);
    Appointment appointment = new Appointment(pacient, doc, "27/12");
    DAO.save(appointment);
    DAO.delete(appointment);
    DAO.delete(procedure);

  }
}
