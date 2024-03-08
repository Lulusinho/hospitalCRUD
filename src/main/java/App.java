import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.apache.commons.csv.CSVRecord;

import Parser.Parsercsv;

public class App {
  public static void main(String[] args) {
    final Path programResourcePath = FileSystems.getDefault().getPath("src/main/resources/");
    try {
      Parsercsv parser = new Parsercsv(programResourcePath, "/Person/Doctor.csv", "ID", "nome", "data_nascimento",
          "Endereco_ID");
      for (CSVRecord record : parser.parser) {
        System.out.println(record.get("ID"));
      }
      parser.parser.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
