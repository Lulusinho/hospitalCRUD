package DB;

import org.junit.Test;

import DBhospital.DAO;
import Person.Doctor;
import Person.Pacient;
import Person.Person;
import Utils.Addres;
import Utils.Healthinsurance;
import Utils.Speciality;

public class Deletetest {
  
  @Test
  public void testdeletedoc() {
    Person person = new Person("lulu", "04122003", new Addres("nova barra", "barra do garças", 12345, 12345));
    Doctor doc = new Doctor(person, new Speciality("fisio"), 234, 1234);
      DAO.delete(doc);
  }

  @Test 
  public void deletepacient() {
    Person person = new Person("luis", "11020202", new Addres("lugr", "outro lugar", 4321, 4321));
    Pacient pacient = new Pacient(person, "39093992821", new Healthinsurance("barra", 1234));
    DAO.delete(pacient);
  }
}
