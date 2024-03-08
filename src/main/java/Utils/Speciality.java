package Utils;

import java.util.ArrayList;

public class Speciality {
  private ArrayList<String> name;
  @Override
  public String toString(){
    return name.toString();
  }

  public Speciality() {
    this.name = new ArrayList<String>(3);
  }

  public Speciality(String input) {
    this.name = new ArrayList<String>(3);
    if (this.name.size() < 3) {
      this.name.add(input);
    }
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
