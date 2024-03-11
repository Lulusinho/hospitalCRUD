package Parser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.*;

public class Parser {
  public CSVSpecifier specifier;
  public CSVParser read;
  public CSVPrinter write;

  public Parser(String filename, String... Headers) throws IOException {

    this.specifier = new CSVSpecifier(filename);
    this.specifier.setformat(Headers);

    Reader reader = new FileReader(this.specifier.data);
    this.read = this.specifier.format.parse(reader);

    FileWriter writer = new FileWriter(this.specifier.data, true);
    this.write = this.specifier.format.print(writer);
  }

  public void storetuple(List<String> str) throws IOException{
    this.write.printRecord(str);
  }

  public List<String> searchTuple(String keyword) {
    ArrayList<String> result = new ArrayList<String>(1);
    for (CSVRecord record : this.read) {
      if (record.toString().contains(keyword)) {
        result.add(record.toString());
      }
    }
    if (result.size() <= 0) {
      return null;
    }
    return result;
  }

  public void close() {
    try {
      this.write.flush();
      this.write.close();
      this.read.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
