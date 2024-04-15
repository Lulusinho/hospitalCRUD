package GUI;

/**
 * Tableinfo
 */
public class Tableinfo {
  public String birth;
  public String cpf;
  public String date;
  public String doc;
  public String pacient;
  public String type;

  public Tableinfo(String... strings) {
    birth = strings[0];
    cpf = strings[1];
    date = strings[2];
    doc = strings[3];
    pacient = strings[4];
    type = strings[5];

  }

  public String getBirth() {
    return birth;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getDoc() {
    return doc;
  }

  public void setDoc(String doc) {
    this.doc = doc;
  }

  public String getPacient() {
    return pacient;
  }

  public void setPacient(String pacient) {
    this.pacient = pacient;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
