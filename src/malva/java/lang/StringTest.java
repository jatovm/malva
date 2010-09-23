package malva.java.lang;

import java.io.UnsupportedEncodingException;
import malva.TestCase;

public class StringTest extends TestCase {
  public static void testNewInstance() throws Exception {
    assertEquals("", new String());
    assertEquals("å", new String(new byte[] { (byte)195, (byte)165 }, java.nio.charset.Charset.forName("UTF-8")));
  }

  public static void testToString() {
    assertEquals("class java.lang.String", String.class.toString());
  }

  public static void main(String[] args) throws Exception {
    testNewInstance();
    testToString();
  }
}
