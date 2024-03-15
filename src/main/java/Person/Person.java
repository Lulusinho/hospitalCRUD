package Person;

import Utils.Addres;

import java.util.Date;

public class Person {
  public String name;
  public Date birthdate;
  Addres addres;

  @Override
  public String toString() {
    return this.name + "," + this.birthdate + "," + this.addres.toString();
  }

  public Person(String name, Date birth, Addres addres) {
    this.addres = new Addres(addres);
    this.name = name;
    this.birthdate = birth;
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
