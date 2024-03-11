package Person;

import Utils.Addres;

import java.util.Date;

public class Person {
  public int idPerson;
  public String name;
  public Date birthdate;
  Addres addres;

  @Override
  public String toString() {
    return this.idPerson + "," + this.name + "," + this.birthdate + "," + this.addres.toString();
  }

  public Person(int id, String name, Date birth, Addres addres) {
    this.addres = new Addres(addres);
    this.name = name;
    this.birthdate = birth;
    this.idPerson = id;
  }

  public Person() {
    this.name = null;
  }

  public Person(Person other) {
    this.addres = other.addres;
    this.birthdate = other.birthdate;
    this.name = other.name;
  }

}
