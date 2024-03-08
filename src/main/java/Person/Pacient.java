package Person;

import Utils.Healthinsurance;

public class Pacient extends Person implements Cloneable {
  public String cpf;
  public Healthinsurance plan;

  public Pacient(Pacient other) {
    super(other.name, other.birthdate, other.addres);
    this.cpf = other.cpf;
    this.plan = other.plan;
  }

  public Pacient(Person person, String cpf, Healthinsurance plan) {
    super(person);
    this.cpf = cpf;
    this.plan = plan;
  }

  @Override
  public String toString() {
    return "[" + this.cpf + super.toString() + this.plan + "]";
  }

  @Override
  public Pacient clone() {
    try {
      return (Pacient) super.clone();

    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

}
