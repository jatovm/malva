package malva.java.lang;

import malva.TestCase;

public class DoubleTest extends TestCase {

  public static void testNew() {
    assertEquals(0.0d, new Double(0));
    assertEquals(0.0d, new Double("0.0"));
    assertEquals(-0.0d, new Double("-0.0"));
    assertEquals(0.0d, new Double(".0"));
    assertEquals(0.0d, new Double("0."));
    assertThrows(new Block() {
      @Override public void run() {
        new Double("");
      }
    }, NumberFormatException.class);
  }

  public static void testByteValue() {
    assertEquals((byte)0.0d, new Double("0.0").byteValue());
    assertEquals((byte)-123.123d, new Double("-123.123").byteValue());
  }

  public static void testCompare() {
    assertTrue(Double.compare(0.0d, 0.1d) < 0);
    assertTrue(Double.compare(0.0d, 0.0d) == 0);
    assertTrue(Double.compare(0.1d, 0.0d) > 0);
    assertTrue(Double.compare(0.0d, -0.0d) > 0);
  }

  public static void testCompareTo() {
    assertTrue(new Double(0.0d).compareTo(new Double("0.1")) < 0);
    assertTrue(new Double(0.0d).compareTo(new Double("0.0")) == 0);
    assertTrue(new Double(0.1d).compareTo(new Double("0.0")) > 0);
    assertTrue(new Double(Double.NaN).compareTo(new Double(Double.NaN)) == 0);
    assertTrue(new Double(Double.NaN).compareTo(new Double(Double.POSITIVE_INFINITY)) > 0);
    assertTrue(new Double(0.0d).compareTo(new Double(-0.0d)) > 0);
  }

  public static void testDoubleToLongBits() {
    assertEquals(0x7ff0000000000000L, Double.doubleToLongBits(Double.POSITIVE_INFINITY));
    assertEquals(0xfff0000000000000L, Double.doubleToLongBits(Double.NEGATIVE_INFINITY));
    assertEquals(0x7ff8000000000000L, Double.doubleToLongBits(Double.NaN));
  }

  public static void testDoubleToRawLongBits() {
    assertEquals(0x7ff0000000000000L, Double.doubleToRawLongBits(Double.POSITIVE_INFINITY));
    assertEquals(0xfff0000000000000L, Double.doubleToRawLongBits(Double.NEGATIVE_INFINITY));
    assertEquals(0x7ff8000000000000L, Double.doubleToRawLongBits(Double.NaN));
  }

  public static void testDoubleValue() {
    assertEquals(0.0d, new Double("0.0").doubleValue());
  }

  public static void testEquals() {
    assertTrue(new Double(0.0).equals(new Double("0.0")));
    assertTrue(new Double(Double.NaN).equals(new Double(Double.NaN)));
    assertFalse(new Double(0.0d).equals(-0.0d));
  }

  public static void testFloatValue() {
    assertEquals(0.0f, new Double(0.0d).floatValue());
    assertEquals(-0.0f, new Double(-0.0d).floatValue());
  }

  public static void testHashCode() {
    assertEquals(0, new Double("0.0").hashCode());
    assertEquals(-2147483648, new Double("-0.0").hashCode());
    assertEquals(2067439042, new Double("123.123").hashCode());
  }

  public static void testIntValue() {
    assertEquals(0, new Double("0.0").intValue());
    assertEquals(0, new Double("-0.0").intValue());
    assertEquals(123, new Double("123.123").intValue());
  }

  public static void testIsInfinite() {
    assertTrue(new Double(Double.POSITIVE_INFINITY).isInfinite());
    assertTrue(Double.isInfinite(Double.POSITIVE_INFINITY));
  }

  public static void testIsNan() {
    assertTrue(new Double(Double.NaN).isNaN());
    assertTrue(Double.isNaN(Double.NaN));
  }

  public static void testLongBitsToDouble() {
    assertEquals(4.9E-324, Double.longBitsToDouble(1));
    assertEquals(Double.POSITIVE_INFINITY, Double.longBitsToDouble(0x7ff0000000000000L));
    assertEquals(Double.NEGATIVE_INFINITY, Double.longBitsToDouble(0xfff0000000000000L));
    assertEquals(Double.NaN, Double.longBitsToDouble(0x7ff0000000000001L));
    assertEquals(Double.NaN, Double.longBitsToDouble(0x7fffffffffffffffL));
    assertEquals(Double.NaN, Double.longBitsToDouble(0xfff0000000000001L));
    assertEquals(Double.NaN, Double.longBitsToDouble(0xffffffffffffffffL));
  }

  public static void testLongValue() {
    assertEquals(0l, new Double(0.0d).longValue());
    assertEquals(9223372036854775807l, new Double(Double.MAX_VALUE).longValue());
  }

  public static void testParseDouble() {
    assertEquals(0.0d, Double.parseDouble("0.0"));
    assertEquals(-0.0d, Double.parseDouble("-0.0"));
    assertEquals(0.0d, Double.parseDouble(".0"));
    assertEquals(0.0d, Double.parseDouble("0."));
    assertThrows(new Block() {
      @Override public void run() {
        Double.parseDouble("");
      }
    }, NumberFormatException.class);
  }

  public static void testShortValue() {
    assertEquals((short)0, new Double("0.0").shortValue());
    assertEquals((short)0, new Double("-0.0").shortValue());
    assertEquals((short)123, new Double("123.123").shortValue());
  }

  public static void testToHexString() {
    assertEquals("0x0.0p0", Double.toHexString(0));
    assertEquals("NaN", Double.toHexString(Double.NaN));
    assertEquals("Infinity", Double.toHexString(Double.POSITIVE_INFINITY));
    assertEquals("-Infinity", Double.toHexString(Double.NEGATIVE_INFINITY));

    assertEquals("0x1.0p0", Double.toHexString(1.0));
    assertEquals("-0x1.0p0", Double.toHexString(-1.0));
    assertEquals("0x1.8p1", Double.toHexString(3.0));
    assertEquals("0x1.0p-1", Double.toHexString(0.5));
    assertEquals("0x1.fffffffffffffp1023", Double.toHexString(Double.MAX_VALUE));
    assertEquals("0x1.0p-1022", Double.toHexString(Double.MIN_NORMAL));
    assertEquals("0x0.0000000000001p-1022", Double.toHexString(Double.MIN_VALUE));
  }

  public static void testToString() {
    assertEquals("0.0", Double.toString(0));
    assertEquals("NaN", Double.toString(Double.NaN));
    assertEquals("Infinity", Double.toString(Double.POSITIVE_INFINITY));
    assertEquals("-Infinity", Double.toString(Double.NEGATIVE_INFINITY));
  }

  public static void testValueOf() {
    assertThrows(new Block() {
      @Override public void run() {
        Double.valueOf(null);
      }
    }, NullPointerException.class);

    assertEquals(Double.NaN, Double.valueOf("NaN"));
    assertEquals(Double.POSITIVE_INFINITY, Double.valueOf("Infinity"));
    assertEquals(Double.NEGATIVE_INFINITY, Double.valueOf("-Infinity\n"));
    assertEquals(0.1d, Double.valueOf("0.1f"));
    assertEquals(Double.MIN_VALUE, Double.valueOf(" 0x0.0000000000001p-1022"));
    assertEquals(0.0d, Double.valueOf("0x0.0p0"));
  }

  public static void main(String[] args) throws Exception {
    testNew();
    testByteValue();
    testCompare();
    testCompareTo();
    testDoubleToLongBits();
    testDoubleToRawLongBits();
    testDoubleValue();
    testEquals();
    testFloatValue();
    testHashCode();
    testIntValue();
    testIsInfinite();
    testIsNan();
    testLongBitsToDouble();
    testLongValue();
    testParseDouble();
    testShortValue();
    testToHexString();
    testToString();
    testValueOf();
  }
}
