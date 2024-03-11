
import java.io.IOException;
import java.util.Date;

import Parser.*;
import Person.*;
import Utils.*;

public class App {
  public static void main(String[] args) {
    Person ps = new Person(Sequence.nextValue(), "LUIS", new Date(), new Addres("logradouro", "bairro", 2078, 700882999));

    Parser driver = null;
    Doctor doc = new Doctor(ps, new Speciality("neuro"), 9999, 123430);

    try {
      driver = new Parser("Doctor.csv", "CRM", "name", "Especialidade", "valor_Hora");
      driver.write.printRecord(doc);

      driver.write.flush();

      driver.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
