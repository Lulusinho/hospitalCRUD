package Parser;

import org.apache.commons.csv.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class CSVSpecifier {
  public File data;
  public boolean fileAlreadyExist;
  public CSVFormat format;

  public CSVSpecifier(String fname) throws IOException {
    File[] files = Path.of("./src/main/resources/").toFile().listFiles();
    for (File file : files) {
      if (file.getName().equals(fname)) {
        this.data = file;
        this.fileAlreadyExist = true;
        return;
      }
    }
    this.data = new File("./src/main/resources/" + fname);
    this.data.createNewFile();
    this.fileAlreadyExist = false;
  }

  public void setformat(String[] HEADERS) {
    if (this.fileAlreadyExist == true) {
      this.format = CSVFormat.DEFAULT.builder()
          .setHeader(HEADERS)
          .setNullString("N/A")
          .setAutoFlush(true)
          .setSkipHeaderRecord(this.fileAlreadyExist)
          .setIgnoreEmptyLines(true)
          .build();
    } else {
      this.format = CSVFormat.DEFAULT.builder()
          .setHeader(HEADERS).setSkipHeaderRecord(this.fileAlreadyExist)
          .setNullString("N/A")
          .setAutoFlush(true)
          .setIgnoreEmptyLines(true)
          .build();
    }

  }

}
