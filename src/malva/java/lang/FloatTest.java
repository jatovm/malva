package malva.java.lang;

import malva.TestCase;

public class FloatTest extends TestCase {

  public static void testNew() {
    assertEquals(0.0f, new Float(0));
    assertEquals(0.0f, new Float("0.0"));
    assertEquals(-0.0f, new Float("-0.0"));
    assertEquals(0.0f, new Float(".0"));
    assertEquals(0.0f, new Float("0."));
    assertThrows(new Block() {
      @Override public void run() {
        new Float("");
      }
    }, NumberFormatException.class);
  }

  public static void testByteValue() {
    assertEquals((byte)0.0f, new Float("0.0").byteValue());
    assertEquals((byte)-123.123f, new Float("-123.123").byteValue());
  }

  public static void testCompare() {
    assertTrue(Float.compare(0.0f, 0.1f) < 0);
    assertTrue(Float.compare(0.0f, 0.0f) == 0);
    assertTrue(Float.compare(0.1f, 0.0f) > 0);
    assertTrue(Float.compare(0.0f, -0.0f) > 0);
  }

  public static void testCompareTo() {
    assertTrue(new Float(0.0f).compareTo(new Float("0.1")) < 0);
    assertTrue(new Float(0.0f).compareTo(new Float("0.0")) == 0);
    assertTrue(new Float(0.1f).compareTo(new Float("0.0")) > 0);
    assertTrue(new Float(Float.NaN).compareTo(new Float(Float.NaN)) == 0);
    assertTrue(new Float(Float.NaN).compareTo(new Float(Float.POSITIVE_INFINITY)) > 0);
    assertTrue(new Float(0.0f).compareTo(new Float(-0.0f)) > 0);
  }

  public static void testFloatToLongBits() {
    assertEquals(0x7f800000, Float.floatToIntBits(Float.POSITIVE_INFINITY));
    assertEquals(0xff800000, Float.floatToIntBits(Float.NEGATIVE_INFINITY));
    assertEquals(0x7fc00000, Float.floatToIntBits(Float.NaN));
  }

  public static void testFloatToRawLongBits() {
    assertEquals(0x7f800000, Float.floatToRawIntBits(Float.POSITIVE_INFINITY));
    assertEquals(0xff800000, Float.floatToRawIntBits(Float.NEGATIVE_INFINITY));
    assertEquals(0x7fc00000, Float.floatToRawIntBits(Float.NaN));
  }

  public static void testFloatValue() {
    assertEquals(0.0f, new Float("0.0").floatValue());
    assertEquals(0.0f, new Float(0.0f).floatValue());
    assertEquals(-0.0f, new Float(-0.0f).floatValue());
  }

  public static void testEquals() {
    assertTrue(new Float(0.0).equals(new Float("0.0")));
    assertTrue(new Float(Float.NaN).equals(new Float(Float.NaN)));
    assertFalse(new Float(0.0f).equals(-0.0f));
  }


  public static void testHashCode() {
    assertEquals(0, new Float("0.0").hashCode());
    assertEquals(-2147483648, new Float("-0.0").hashCode());
    assertEquals(1123434234, new Float("123.123").hashCode());
  }

  public static void testIntValue() {
    assertEquals(0, new Float("0.0").intValue());
    assertEquals(0, new Float("-0.0").intValue());
    assertEquals(123, new Float("123.123").intValue());
  }

  public static void testIsInfinite() {
    assertTrue(new Float(Float.POSITIVE_INFINITY).isInfinite());
    assertTrue(Float.isInfinite(Float.POSITIVE_INFINITY));
  }

  public static void testIsNan() {
    assertTrue(new Float(Float.NaN).isNaN());
    assertTrue(Float.isNaN(Float.NaN));
  }

  public static void testLongBitsToFloat() {
    assertEquals(1.4E-45f, Float.intBitsToFloat(1));
    assertEquals(Float.POSITIVE_INFINITY, Float.intBitsToFloat(0x7f800000));
    assertEquals(Float.NEGATIVE_INFINITY, Float.intBitsToFloat(0xff800000));
    assertEquals(Float.NaN, Float.intBitsToFloat(0x7f800001));
    assertEquals(Float.NaN, Float.intBitsToFloat(0x7fffffff));
    assertEquals(Float.NaN, Float.intBitsToFloat(0xff800001));
    assertEquals(Float.NaN, Float.intBitsToFloat(0xffffffff));
  }

  public static void testLongValue() {
    assertEquals(0l, new Float(0.0f).longValue());
    assertEquals(9223372036854775807l, new Float(Float.MAX_VALUE).longValue());
  }

  public static void testParseFloat() {
    assertEquals(0.0f, Float.parseFloat("0.0"));
    assertEquals(-0.0f, Float.parseFloat("-0.0"));
    assertEquals(0.0f, Float.parseFloat(".0"));
    assertEquals(0.0f, Float.parseFloat("0."));
    assertThrows(new Block() {
      @Override public void run() {
        Float.parseFloat("");
      }
    }, NumberFormatException.class);
  }

  public static void testShortValue() {
    assertEquals((short)0, new Float("0.0").shortValue());
    assertEquals((short)0, new Float("-0.0").shortValue());
    assertEquals((short)123, new Float("123.123").shortValue());
  }

  public static void testToHexString() {
    assertEquals("0x0.0p0", Float.toHexString(0));
    assertEquals("NaN", Float.toHexString(Float.NaN));
    assertEquals("Infinity", Float.toHexString(Float.POSITIVE_INFINITY));
    assertEquals("-Infinity", Float.toHexString(Float.NEGATIVE_INFINITY));

    assertEquals("0x1.0p0", Float.toHexString(1.0f));
    assertEquals("-0x1.0p0", Float.toHexString(-1.0f));
    assertEquals("0x1.8p1", Float.toHexString(3.0f));
    assertEquals("0x1.0p-1", Float.toHexString(0.5f));
    assertEquals("0x1.fffffep127", Float.toHexString(Float.MAX_VALUE));
    assertEquals("0x1.0p-126", Float.toHexString(Float.MIN_NORMAL));
    assertEquals("0x0.000002p-126", Float.toHexString(Float.MIN_VALUE));
  }

  public static void testToString() {
    assertEquals("0.0", Float.toString(0));
    assertEquals("NaN", Float.toString(Float.NaN));
    assertEquals("Infinity", Float.toString(Float.POSITIVE_INFINITY));
    assertEquals("-Infinity", Float.toString(Float.NEGATIVE_INFINITY));
  }

  public static void testValueOf() {
    assertThrows(new Block() {
      @Override public void run() {
        Float.valueOf(null);
      }
    }, NullPointerException.class);

    assertEquals(Float.NaN, Float.valueOf("NaN"));
    assertEquals(Float.POSITIVE_INFINITY, Float.valueOf("Infinity"));
    assertEquals(Float.NEGATIVE_INFINITY, Float.valueOf("-Infinity\n"));
    assertEquals(0.1f, Float.valueOf("0.1f"));
    assertEquals(Float.MIN_VALUE, Float.valueOf(" 0x0.000002p-126"));
    assertEquals(0.0f, Float.valueOf("0x0.0p0"));
  }

  public static void main(String[] args) throws Exception {
    testNew();
    testByteValue();
    testCompare();
    testCompareTo();
    testFloatToLongBits();
    testFloatToRawLongBits();
    testFloatValue();
    testEquals();
    testFloatValue();
    testHashCode();
    testIntValue();
    testIsInfinite();
    testIsNan();
    testLongBitsToFloat();
    testLongValue();
    testParseFloat();
    testShortValue();
    testToHexString();
    testToString();
    testValueOf();
  }
}
