package malva.java.lang;

import malva.TestCase;

public class LongTest extends TestCase {

  public static void testNew() {
    assertEquals(42l, new Long(42));
    assertEquals(42l, new Long(42l));
    assertEquals(42l, new Long("42"));
    assertEquals(0l, new Long(0));

    assertThrows(new Block() {
      @Override public void run() {
        new Long("");
      }
    }, NumberFormatException.class);
  }

  public static void testBitCount() {
    assertEquals(0, Long.bitCount(0l));
    assertEquals(63, Long.bitCount(Long.MAX_VALUE));
    assertEquals(62, Long.bitCount(Long.MAX_VALUE - 1));
    assertEquals(1, Long.bitCount(Long.MAX_VALUE + 1));
    assertEquals(1, Long.bitCount(Long.MIN_VALUE));
    assertEquals(63, Long.bitCount(Long.MIN_VALUE - 1));
    assertEquals(2, Long.bitCount(Long.MIN_VALUE + 1));
  }

  public static void testByteValue() {
    assertEquals(new Byte("0"), new Long(0l).byteValue());
    assertEquals(new Byte("127"), new Long(127l).byteValue());
  }

  public static void testCompareTo() {
    assertTrue(0l == new Long(0l));
    assertTrue(-1l <= new Long(0l));
    assertTrue(1l >= new Long(0l));
    assertTrue(Long.MAX_VALUE > Long.MIN_VALUE);
  }

  public static void testDecode() {
    assertEquals(0l, Long.decode("0"));
    assertEquals(0l, Long.decode("0x0"));
    assertEquals(0l, Long.decode("0X0"));
    assertEquals(0l, Long.decode("#0"));
    assertEquals(0l, Long.decode("00"));
  }

  public static void testDoubleValue() {
    assertEquals(0d, new Long(0l).doubleValue());
    assertEquals(-1d, new Long(-1l).doubleValue());
    assertEquals(9.223372036854776E18, new Long(Long.MAX_VALUE).doubleValue());
    assertEquals(-9.223372036854776E18, new Long(Long.MIN_VALUE).doubleValue());
  }

  public static void testEquals() {
    assertTrue(new Long(0l).equals(0l));
    assertTrue(new Long(Long.MAX_VALUE).equals(Long.MAX_VALUE));
    assertTrue(new Long(Long.MIN_VALUE).equals(Long.MIN_VALUE));
  }

  public static void testFloatValue() {
    assertEquals(0f, new Long(0l).floatValue());
    assertEquals(-1f, new Long(-1l).floatValue());
    assertEquals(9.223372E18f, new Long(Long.MAX_VALUE).floatValue());
    assertEquals(-9.223372E18f, new Long(Long.MIN_VALUE).floatValue());
  }

  public static void testGetLong() throws Exception {
    System.setProperty("MALVA_TEST_LONG_MAX", new Long(Long.MAX_VALUE).toString());
    System.setProperty("MALVA_TEST_LONG_MIN", new Long(Long.MIN_VALUE).toString());
    assertEquals(Long.MAX_VALUE, Long.getLong("MALVA_TEST_LONG_MAX"));
    assertEquals(Long.MIN_VALUE, Long.getLong("MALVA_TEST_LONG_MIN"));
    assertEquals(Long.MAX_VALUE, Long.getLong("MALVA_DOES_NOT_EXIST", Long.MAX_VALUE));
    System.clearProperty("MALVA_TEST_LONG_MAX");
    System.clearProperty("MALVA_TEST_LONG_MIN");
  }

  public static void testHashCode() {
    // (int)(this.longValue()^(this.longValue()>>>32))
    assertEquals(0, new Long(0).hashCode());
    long val = Long.MAX_VALUE;
    int expected = (int)(val^val>>>32);
    assertEquals(-2147483648, expected);
    val = Long.MIN_VALUE;
    expected = (int)(val^val>>>32);
    assertEquals(-2147483648, expected);
  }

  public static void testHighestOneBit() {
    assertEquals(0l, Long.highestOneBit(0l));
    assertEquals(4611686018427387904l, Long.highestOneBit(Long.MAX_VALUE));
    assertEquals(-9223372036854775808l, Long.highestOneBit(Long.MIN_VALUE));
  }

  public static void testIntValue() {
    assertEquals(0, new Long(0).intValue());
    assertEquals(-1, new Long(Long.MAX_VALUE).intValue());
    assertEquals(0, new Long(Long.MIN_VALUE).intValue());
  }

  public static void testLongValue() {
    assertEquals(0l, new Long(0).longValue());
    assertEquals(Long.MAX_VALUE, new Long(Long.MAX_VALUE).longValue());
    assertEquals(Long.MIN_VALUE, new Long(Long.MIN_VALUE).longValue());
  }

  public static void testLowestOneBit() {
    assertEquals(0l, Long.lowestOneBit(0l));
    assertEquals(1l, Long.lowestOneBit(Long.MAX_VALUE));
    assertEquals(-9223372036854775808l, Long.lowestOneBit(Long.MIN_VALUE));
  }

  public static void testNumberOfLeadingZeros() {
    assertEquals(64, Long.numberOfLeadingZeros(0l));
    assertEquals(1, Long.numberOfLeadingZeros(Long.MAX_VALUE));
    assertEquals(0, Long.numberOfLeadingZeros(Long.MIN_VALUE));
  }

  public static void testNumberOfTrailingZeros() {
    assertEquals(64, Long.numberOfTrailingZeros(0l));
    assertEquals(0, Long.numberOfTrailingZeros(Long.MAX_VALUE));
    assertEquals(63, Long.numberOfTrailingZeros(Long.MIN_VALUE));
  }

  public static void testParseLong() {
    assertEquals(0l, Long.parseLong("0"));
    assertEquals(Long.MAX_VALUE, Long.parseLong(new Long(Long.MAX_VALUE).toString()));
    assertEquals(Long.MIN_VALUE, Long.parseLong(new Long(Long.MIN_VALUE).toString()));
    assertEquals(10l, Long.parseLong(("A"), 16));
    assertEquals(7l, Long.parseLong(("7"), 8));
  }

  public static void testReverse() {
    assertEquals(0l, Long.reverse(0l));
    assertEquals(-2l, Long.reverse(Long.MAX_VALUE));
    assertEquals(1l, Long.reverse(Long.MIN_VALUE));
  }

  public static void testReverseBytes() {
    assertEquals(0l, Long.reverseBytes(0l));
    assertEquals(-129l, Long.reverseBytes(Long.MAX_VALUE));
    assertEquals(128l, Long.reverseBytes(Long.MIN_VALUE));
  }

  public static void testRotateLeft() {
    assertEquals(0l, Long.rotateLeft(0l, 1));
    assertEquals(-2l, Long.rotateLeft(Long.MAX_VALUE, 1));
    assertEquals(-4611686018427387905l, Long.rotateLeft(Long.MAX_VALUE, -1));
    assertEquals(1l, Long.rotateLeft(Long.MIN_VALUE, 1));
    assertEquals(4611686018427387904l, Long.rotateLeft(Long.MIN_VALUE, -1));
  }

  public static void testRotateRight() {
    assertEquals(0l, Long.rotateRight(0l, 1));
    assertEquals(-4611686018427387905l, Long.rotateRight(Long.MAX_VALUE, 1));
    assertEquals(-2l, Long.rotateRight(Long.MAX_VALUE, -1));
    assertEquals(4611686018427387904l, Long.rotateRight(Long.MIN_VALUE, 1));
    assertEquals(1l, Long.rotateRight(Long.MIN_VALUE, -1));
  }

  public static void testShortValue() {
    short expected = 0;
    assertEquals(expected, new Long(0).shortValue());
    expected = -1;
    assertEquals(expected, new Long(Long.MAX_VALUE).shortValue());
    expected = 0;
    assertEquals(expected, new Long(Long.MIN_VALUE).shortValue());
  }

  public static void testSignum() {
    assertEquals(0, Long.signum(0l));
    assertEquals(1, Long.signum(Long.MAX_VALUE));
    assertEquals(-1, Long.signum(Long.MIN_VALUE));
  }

  public static void testToBinaryString() {
    assertEquals("0", Long.toBinaryString(0l));
    assertEquals("111111111111111111111111111111111111111111111111111111111111111", Long.toBinaryString(Long.MAX_VALUE));
    assertEquals("1000000000000000000000000000000000000000000000000000000000000000", Long.toBinaryString(Long.MIN_VALUE));
  }

  public static void testToHexString() {
    assertEquals("0", Long.toHexString(0l));
    assertEquals("7fffffffffffffff", Long.toHexString(Long.MAX_VALUE));
    assertEquals("8000000000000000", Long.toHexString(Long.MIN_VALUE));
  }

  public static void testToOctalString() {
    assertEquals("0", Long.toOctalString(0l));
    assertEquals("777777777777777777777", Long.toOctalString(Long.MAX_VALUE));
    assertEquals("1000000000000000000000", Long.toOctalString(Long.MIN_VALUE));
  }

  public static void testToString() {
    assertEquals("0", Long.toString(0l));
    assertEquals("9223372036854775807", Long.toString(Long.MAX_VALUE));
    assertEquals("-9223372036854775808", Long.toString(Long.MIN_VALUE));
  }

  public static void testValueOf() {
    assertEquals(new Long(0), Long.valueOf(0l));
    assertEquals(new Long(Long.MAX_VALUE), Long.valueOf(Long.MAX_VALUE));
    assertEquals(new Long(Long.MIN_VALUE), Long.valueOf(Long.MIN_VALUE));
    assertEquals(new Long(Long.MAX_VALUE), Long.valueOf(new Long(Long.MAX_VALUE).toString()));
    assertEquals(new Long(Long.MIN_VALUE), Long.valueOf(new Long(Long.MIN_VALUE).toString()));
    assertEquals(new Long(10), Long.valueOf("A", 16));
    assertEquals(new Long(7), Long.valueOf("7", 8));
  }

  public static void main(String[] args) throws Exception {
    testNew();
    testBitCount();
    testByteValue();
    testCompareTo();
    testDecode();
    testDoubleValue();
    testEquals();
    testFloatValue();
    testGetLong();
    testHashCode();
    testHighestOneBit();
    testIntValue();
    testLongValue();
    testLowestOneBit();
    testNumberOfLeadingZeros();
    testNumberOfTrailingZeros();
    testParseLong();
    testReverse();
    testReverseBytes();
    testRotateLeft();
    testRotateRight();
    testShortValue();
    testSignum();
    testToBinaryString();
    testToHexString();
    testToOctalString();
    testToString();
    testValueOf();
  }
}