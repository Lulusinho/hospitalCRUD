package Utils;

public class Addres implements Cloneable {
  public String logradouro;
  public String bairro;
  public Integer code;
  public Integer number;

  public Addres(String logradouro, String bairro, Integer code, Integer number) {
    this.bairro = bairro;
    this.code = code;
    this.logradouro = logradouro;
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
    return this.logradouro + "," + this.bairro + "," + this.number+ "," + this.code;
  }


  public String[] stringfy() {
    return new String[] {String.valueOf(this.code), this.bairro, String.valueOf(this.number), this.logradouro };
  }

  public Addres(Addres other) {
    this.bairro = other.bairro;
    this.code = other.code;
    this.logradouro = other.logradouro;
    this.number = other.number;
  }

  public Addres copy() {
    return new Addres(this);
  }

  public String getBairro() {
    return bairro;
  }

  public Integer getCode() {
    return code;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public Integer getNumber() {
    return number;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }
}
