package Utils;

import static org.junit.Assert.*;


public class AddresTest {

  public static boolean copytest() {
    Addres endereco1 = new Addres("rua", "nova barra", 112, 400);
    Addres endereco2 = new Addres("praca", "nova barra norte", 001, 800);
    endereco1 = endereco2.clone();
    endereco1.bairro = "luis";
    try {
      assertEquals(endereco1.bairro, endereco2.bairro);
      assertEquals(endereco1.hashCode(), endereco2.hashCode());

      return true;
    } catch (AssertionError e) {
      return false;
    }
  }

}
