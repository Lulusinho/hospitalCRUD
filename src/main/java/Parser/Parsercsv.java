package Parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.commons.csv.*;

public class Parsercsv {
  public File data;
  public CSVFormat format;
  public CSVParser parser;
  public CSVPrinter printer;
  public Iterable<CSVRecord> tuples;

  public Parsercsv(Path pathdir, String fname, String... HEADERS) throws IOException {
    this.data = new File(pathdir.toAbsolutePath() + fname);
    if (!data.exists()) {
      data.createNewFile();
    }
    this.format = CSVFormat.DEFAULT.builder()
        .setHeader(HEADERS)
        .setNullString("N/A")
        .setAutoFlush(true)
        .setSkipHeaderRecord(false)
        .build();
    Reader read = new FileReader(this.data);
    this.parser = this.format.parse(read);

  }

  public String search(String key) {
    return "luis";
  }

  public void close() {
    try {
      this.printer.flush();
      this.printer.close();
    } catch (IOException e) {
    }
  }

}
