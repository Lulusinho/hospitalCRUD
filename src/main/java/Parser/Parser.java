package Parser;

import java.io.File;

public interface Parser {
  public void open(File data);

  public void loadFilememmory();

  public void storetuple(String str);

  public String search(String str);

  public void close();
}
