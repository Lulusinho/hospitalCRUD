package Utils;

public class Rooms {
  private String name;

  public Rooms(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
  
  @Override
  public String toString(){
    return this.name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
