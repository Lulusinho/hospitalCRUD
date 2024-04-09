package DB;

import org.junit.Test;

import DBhospital.DAO;
import Person.Doctor;
import Person.Pacient;
import Person.Person;
import Utils.Addres;
import Utils.Healthinsurance;
import Utils.Speciality;
import actions.Appointment;

public class Insertiontest {

  @Test
  public void testdoc() {
    Person person = new Person("lulu", "04122003", new Addres("nova barra", "barra do garças", 12345, 12345));
    Doctor doc = new Doctor(person, new Speciality("fisio"), 234, 1234);
    if (DAO.save(doc)) {
      return;
    }
    throw new AssertionError();

  }

  @Test
  public void testpacient() {
    Person person = new Person("luis", "11020202", new Addres("lugr", "outro lugar", 4321, 4321));
    Pacient pacient = new Pacient(person, "39093992821", new Healthinsurance("barra", 1234));
    DAO.save(pacient);

  }
  @Test
  public void testprocedure() {
    Person person = new Person("lulu", "04122003", new Addres("nova barra", "barra do garças", 12345, 12345));
    Doctor doc = new Doctor(person, new Speciality("fisio"), 234, 1234);
    Person person1 = new Person("luis", "11020202", new Addres("lugr", "outro lugar", 4321, 4321));
    Pacient pacient = new Pacient(person1, "39093992821", new Healthinsurance("barra", 1234));
    Appointment appointment = new Appointment(pacient, doc, "HOJE");
    DAO.save(appointment);
  }

}
