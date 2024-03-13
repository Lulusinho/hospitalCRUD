package Utils;

public class Addres implements Cloneable {
  public String public_area;
  public String district;
  public Integer code;
  public Integer number;

  public Addres(String public_area, String district, Integer code, Integer number) {
    this.district = district;
    this.code = code;
    this.public_area = public_area;
    this.number = number;
  }

  @Override
  public Addres clone() {
    try {
      System.out.println("da certo");
      return (Addres) super.clone();

    } catch (CloneNotSupportedException e) {
      System.out.println("não da certo");
      return new Addres(this);
    }
  }
  @Override
  public String toString() {
    return this.public_area + "," + this.district + "," + this.number+ "," + this.code;
  }


  public String[] stringfy() {
    return new String[] {String.valueOf(this.code), this.district, String.valueOf(this.number), this.public_area };
  }

  public Addres(Addres other) {
    this.district = other.district;
    this.code = other.code;
    this.public_area = other.public_area;
    this.number = other.number;
  }

  public Addres copy() {
    return new Addres(this);
  }

  public String getdistrict() {
    return district;
  }

  public Integer getCode() {
    return code;
  }

  public String getpublic_area() {
    return public_area;
  }

  public Integer getNumber() {
    return number;
  }

  public void setdistrict(String district) {
    this.district = district;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public void setpublic_area(String public_area) {
    this.public_area = public_area;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }
}
