package Utils;


public class Speciality {
  public String[] name;

  @Override
  public String toString() {
    String var = new String("");
    StringBuffer var2 = new StringBuffer();
    for (var iterable : name) {
      var += iterable + ",";
    }
    if (var.endsWith(",")) {
      var2 = new StringBuffer(var);
      var2.deleteCharAt(var2.length() - 1);
    }
    return new String(var2);
  }

  public Speciality() {
    this.name = new String[3];
  }

  public Speciality(String... input) {
    if (input.length > 3) {
      return;
    }
    this.name = input.clone();
  }

  public String[] getName() {
    return name;
  }

  public void setName(String... name) {
    if (name.length < 3) {
      this.name = name;
    }
  }
}
