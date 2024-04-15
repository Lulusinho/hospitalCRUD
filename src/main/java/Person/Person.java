package Person;

import Utils.Addres;

public class Person {
  public String name;
  public String birthdate;
  public Addres addres;

  @Override
  public String toString() {
    return this.name + "," + this.birthdate + "," + this.addres.toString();
  }

  public Person(String name, String birth, Addres addres) {
    this.addres = new Addres(addres);
    this.name = name;
    this.birthdate = birth;
  }

  public Person() {
    this.addres = null;
  }

  public Person(Person other) {
    if (other == null) {
      return;
    }
    this.addres = other.addres;
    this.birthdate = other.birthdate;
    this.name = other.name;
  }

}
