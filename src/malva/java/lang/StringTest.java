package malva.java.lang;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

import malva.TestCase;

public class StringTest extends TestCase {
  public static void testNewInstance() throws Exception {
    assertEquals("", new String());
    assertEquals("å", new String(new byte[] { (byte)195, (byte)165 }, Charset.forName("UTF-8")));
    assertEquals("åäö", new String("åäö"));
  }

  public static void testCharAt() {
    assertEquals('a', "a".charAt(0));
    // API documentation says charAt() throws IndexOutOfBoundException but
    // implementation throws StringIndexOutOfBoundsException.
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        "a".charAt(1);
      }
    }, StringIndexOutOfBoundsException.class);
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        "a".charAt(-1);
      }
    }, StringIndexOutOfBoundsException.class);
  }

  // codePointAt
  // codePointBefore
  // codePointCount

  public static void testCompareTo() {
    assertTrue("".compareTo("") == 0);
    assertTrue(("" + "").compareTo("") == 0);
    assertTrue(("".compareTo(" ") < 0));
    assertTrue("Ä".compareTo("ä") < 0);
    assertTrue((" ".compareTo("") > 0));
    assertTrue("ä".compareTo("Ä") > 0);
  }

  public static void testCompareToIgnoreCase() {
    assertTrue("Ä".compareToIgnoreCase("ä") == 0);
    assertTrue(("B".compareToIgnoreCase("a") > 0));
  }

  public static void testConcat() {
    assertEquals("caress", "cares".concat("s"));
    assertEquals("together", "to".concat("get").concat("her"));
    assertEquals("", "".concat(""));
  }

  public static void testContains() {
    assertTrue("".contains(""));
    assertTrue(" ".contains(" "));
    assertFalse("A".contains("a"));
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        "".contains(null);
      }
    }, NullPointerException.class);
  }

  // contentEquals

  public static void testCopyValueOf() {
    assertEquals(" ", String.copyValueOf(new char[] {' '}, 0, 1));
    assertThrows(new Block(){
      @Override public void run() {
        String.copyValueOf(new char[] {' '}, 0, 2);
      }
    }, StringIndexOutOfBoundsException.class);
    assertEquals("åäö", String.copyValueOf(new char[] {'å', 'ä', 'ö'}));
  }

  public static void testEndsWith() {
    assertTrue("åäö".endsWith("ö"));
  }

  // equals
  // equalsIgnoreCase
  // format

  public static void testGetBytes() {
    assertEquals(new String("åäö".getBytes(Charset.defaultCharset())), new String("åäö".getBytes()));
  }

  public static void testGetChars() {
    final char[] chars = new char[3];
    "abc".getChars(0, 3, chars, 0);
    assertEquals(new String(new char[]{'a', 'b', 'c'}), new String(chars));
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        "abc".getChars(0, 4, chars, 0);
      }
    }, StringIndexOutOfBoundsException.class);
  }

  public static void testHashCode() {
    assertEquals(0, "".hashCode());
    assertEquals(hash(" "), " ".hashCode());
    assertEquals(hash("åäö"), "åäö".hashCode());
  }

  /** According to API documentation String.hashCode is: s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1] */
  private static int hash(String str) {
    char[] chars = new char[str.length()];
    str.getChars(0, str.length(), chars, 0);
    int hashCode = 0;
    for (int i=0; i<chars.length; i++) {
      hashCode += (int)chars[i] * (int)Math.pow(31, (chars.length-(i+1)));
    }
    return hashCode;
  }

  public static void testIndexOf() {
    assertEquals(0, "åäö".indexOf("å"));
    assertEquals(0, "åäö".indexOf('å'));
    assertEquals(1, "äää".indexOf("ä", 1));
    assertEquals(1, "äää".indexOf('ä', 1));
    assertEquals(-1, "".indexOf(" "));
  }

  public static void testIntern() {
    String str1 = "abc";
    assertTrue(str1.intern() == "ABC".toLowerCase().intern());
    assertTrue(str1.intern() == (" " + "" + "AB" + "C" + "").trim().toLowerCase().intern());
  }

  // isEmpty

  public static void testLastIndexOf() {
    assertEquals(1, "ää".lastIndexOf("ä"));
    assertEquals(0, "a".lastIndexOf('a'));
    assertEquals(0, "aba".lastIndexOf("a", 1));
    assertEquals(-1, "".lastIndexOf(" "));
  }

  // length
  // matches
  // offsetByCodePoints

  public static void testRegionMatches() {
    assertTrue ("åäö".regionMatches(0, "abcåäö", 3, 3));
    assertFalse("åäö".regionMatches(-1, "abcåäö", 3, 3));
    assertFalse("åäö".regionMatches(0, "abcåäö", 7, 3));
    assertFalse("åäö".regionMatches(0, "abcåäö", 3, 4));
    assertTrue ("åäö".regionMatches(true, 0, "aBcåÄö", 3, 3));
  }

  public static void testReplace() {
    assertEquals("mosquito in your collar", "mesquite in your cellar".replace('e', 'o'));
    assertEquals("the way of bayonets", "the war of baronets".replace('r', 'y'));
    assertEquals("starring with a turtle tortoise", "sparring with a purple porpoise".replace('p', 't'));
    assertEquals("JonL", "JonL".replace('q', 'x'));
    assertEquals("Testing", "Resting".replace("Rest".subSequence(0, 1), "T".subSequence(0,1)));
    assertEquals("  ", " ".replace(" ", "  "));
  }

  // replaceAll
  // replaceFirst
  // split

  public static void testStartsWith() {
    assertTrue ("åäö".startsWith("ä", 1));
    assertTrue ("åäö".startsWith("å"));
    assertFalse("åäö".startsWith("ä", 0));
  }

  public static void testSubSequence() {
    assertEquals("åäö", "åäö".subSequence(0, 3));
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        "".subSequence(0, 1);
      }
    }, StringIndexOutOfBoundsException.class);
  }

  public static void testSubstring() {
    assertEquals("happy", "unhappy".substring(2));
    assertEquals("bison", "Harbison".substring(3));
    assertEquals("", "emptiness".substring(9));
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        "".substring(1);
      }
    }, StringIndexOutOfBoundsException.class);
  }

  public static void testToCharArray() {
    assertEquals(' ', " ".toCharArray()[0]);
    assertEquals('å', "åäö".toCharArray()[0]);
  }

  public static void testToLowerCase() {
    assertEquals("french fries", "French Fries".toLowerCase(Locale.US));
    assertEquals("ümlaut", "Ümlaut".toLowerCase(Locale.GERMAN));
    assertEquals(" ", " ".toLowerCase());
  }

  public static void testToString() {
    assertEquals("class java.lang.String", String.class.toString());
  }

  public static void testToUpperCase() {
    assertEquals("TEST", "test".toUpperCase());
    assertEquals("ÜMLAUT", "ümlaut".toUpperCase());
    assertEquals(" ", " ".toUpperCase());
  }

  public static void testTrim() {
    assertEquals("", " ".trim());
    assertEquals("a", " a ".trim());
    assertEquals("a a", "a a\n".trim());
  }

  // TODO:
  // See this discussion about the inconsistent exceptions that are thrown by
  // String.valueOf(): http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4417678
  public static void testValueOf() {
    assertEquals("abc", String.valueOf("abc"));
    // See http://stackoverflow.com/questions/3131865/why-does-string-valueofnull-throw-a-nullpointerexception
    assertThrows(new Block(){
      @Override public void run() {
        String.valueOf(null);
      }
    }, NullPointerException.class);
    assertEquals("null" , String.valueOf((Object)null));
    assertEquals("true" , String.valueOf(true));
    assertEquals("false", String.valueOf(false));
    assertEquals("å"    , String.valueOf('å'));
    assertEquals("0"    , String.valueOf(0));
    assertEquals("0"    , String.valueOf(0L));
    assertEquals("0.0"  , String.valueOf(0.0));
    assertEquals("äö", String.valueOf(new char[] {'å', 'ä', 'ö'}, 1, 2));
    assertThrows(new Block() {
      @Override public void run() {
        String.valueOf(new char[] {'å', 'ä', 'ö'}, 1, 3);
      }
    }, StringIndexOutOfBoundsException.class);
    // Make sure subsequent array modifications don't affect the created string
    // content.
    char[] chars = {'å', 'ä', 'ö'};
    String str = String.valueOf(chars);
    assertEquals("åäö", str);
    chars[0] = 'a';
    assertEquals("åäö", str);
  }

  public static void main(String[] args) throws Exception {
    testCharAt();
    testCompareTo();
    testCompareToIgnoreCase();
    testConcat();
    testContains();
    testCopyValueOf();
    testEndsWith();
    testGetBytes();
    testGetChars();
    testHashCode();
    testIndexOf();
    testIntern();
    testLastIndexOf();
    testNewInstance();
    testRegionMatches();
    testReplace();
    testReplace();
    testStartsWith();
    testSubSequence();
    testSubstring();
    testToCharArray();
    testToLowerCase();
    testToString();
    testToUpperCase();
    testTrim();
    testValueOf();
  }
}
