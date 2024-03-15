package Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Speciality {
  private ArrayList<String> name;

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
    this.name = new ArrayList<String>(3);
  }

  public Speciality(String... input) {
    if (input.length > 3) {
      return;
    }
    this.name = new ArrayList<String>(Arrays.asList(input));
  }

  public ArrayList<String> getName() {
    return name;
  }

  public void setName(String name) {
    if (this.name.size() < 3) {
      this.name.add(name);
    }
  }

}
