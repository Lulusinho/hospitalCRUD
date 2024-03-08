package Utils;

public class Healthinsurance {
  public String name;
  public double monthlypayment;

  @Override
  public String toString() {
    return "[" + this.name + this.monthlypayment + "]";
  }

  public Healthinsurance(String name, double pays) {
    this.name = name;
    this.monthlypayment = pays;
  }

  public double getMonthlypayment() {
    return monthlypayment;
  }

  public String getName() {
    return name;
  }

  public void setMonthlypayment(double monthlypayment) {
    this.monthlypayment = monthlypayment;
  }

  public void setName(String name) {
    this.name = name;
  }

}
