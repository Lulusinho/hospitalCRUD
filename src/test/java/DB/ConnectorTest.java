package DB;

import org.junit.Test;

public class ConnectorTest {
  @Test
  public void testconnection() {
    DBhospital.Connector.setconnection("jdbc:mysql://localhost:3307/HOSPITAL", "root", "luislindo");
  }
}
