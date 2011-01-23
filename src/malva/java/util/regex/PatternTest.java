package malva.java.util.regex;

import java.util.regex.Pattern;

import malva.TestCase;

public class PatternTest extends TestCase {
  // compile
  // flags
  // matcher
  // pattern

  public static void testQuote() {
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        Pattern.quote(null);
      }
    }, NullPointerException.class);
    assertEquals("\\Qhello, world\\E", Pattern.quote("hello, world"));
  }

  // split
  // toString

  public static void main(String[] args) {
    testQuote();
  }
}
