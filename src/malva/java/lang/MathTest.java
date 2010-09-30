package malva.java.lang;

import malva.TestCase;

public class MathTest extends TestCase {
  public static void testAbs() {
    assertEquals(0, Math.abs(-0));
    assertEquals(Integer.MIN_VALUE, Math.abs(Integer.MIN_VALUE));
    assertEquals(0, Math.abs(-0));
    assertEquals(Long.MIN_VALUE, Math.abs(Long.MIN_VALUE));
    assertEquals(0.0d, Math.abs(-0.0d));
    assertEquals(Double.POSITIVE_INFINITY, Math.abs(Double.POSITIVE_INFINITY));
    assertEquals(Double.POSITIVE_INFINITY, Math.abs(Double.NEGATIVE_INFINITY));
    assertEquals(Double.NaN, Math.abs(Double.NaN));
    assertEquals(0.0f, Math.abs(-0.0f));
    assertEquals(Float.POSITIVE_INFINITY, Math.abs(Float.POSITIVE_INFINITY));
    assertEquals(Float.POSITIVE_INFINITY, Math.abs(Float.NEGATIVE_INFINITY));
    assertEquals(Float.NaN, Math.abs(Float.NaN));
  }

  public static void testAcos() {
    assertEquals(0.0d, Math.acos(1.0d));
    assertEquals(Math.PI, Math.acos(-1.0d));
    assertEquals(Double.NaN, Math.acos(1.0d + Math.ulp(1.0d)));
    assertEquals(Double.NaN, Math.acos(Double.NaN));
  }

  public static void testAsin() {
    assertEquals(0.0d, Math.asin(0.0d));
    assertEquals(-0.0d, Math.asin(-0.0d));
    assertEquals(-Math.PI/2, Math.asin(-1.0d));
    assertEquals(Double.NaN, Math.asin(1.01d));
    assertEquals(Double.NaN, Math.asin(Double.NaN));
  }

  public static void testAtan() {
    assertEquals(0.0d, Math.atan(0.0d));
    assertEquals(-0.0d, Math.atan(-0.0d));
    assertEquals(Double.NaN, Math.atan(Double.NaN));
  }

  public static void testAtan2() {
    assertEquals(Double.NaN, Math.atan2(Double.NaN, 0));
    assertEquals(Double.NaN, Math.atan2(0, Double.NaN));
    assertEquals(Double.NaN, Math.atan2(Double.NaN, Double.NaN));
    assertEquals(0.0d, Math.atan2(0.0d, 0.0d));
    assertEquals(0.0d, Math.atan2(0.0d, Double.POSITIVE_INFINITY));
    assertEquals(-0.0d, Math.atan2(-0.0d, 0.0d));
    assertEquals(-0.0d, Math.atan2(-0.0d, Double.POSITIVE_INFINITY));
    assertEquals(Math.PI, Math.atan2(0.0d, -0.0d));
    assertEquals(Math.PI, Math.atan2(0.0d, Double.NEGATIVE_INFINITY));
    assertEquals(-Math.PI, Math.atan2(-0.0d, -0.0d));
    assertEquals(-Math.PI, Math.atan2(-0.0d, Double.NEGATIVE_INFINITY));
    assertEquals(Math.PI/2, Math.atan2(Double.POSITIVE_INFINITY, 0.0d));
    assertEquals(Math.PI/2, Math.atan2(Double.POSITIVE_INFINITY, -0.0d));
    assertEquals(Math.PI/2, Math.atan2(Double.POSITIVE_INFINITY, 1));
    assertEquals(-Math.PI/2, Math.atan2(Double.NEGATIVE_INFINITY, 0.0d));
    assertEquals(-Math.PI/2, Math.atan2(Double.NEGATIVE_INFINITY, -0.0d));
    assertEquals(-Math.PI/2, Math.atan2(Double.NEGATIVE_INFINITY, 1));
    assertEquals(3*Math.PI/4, Math.atan2(Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY));
    assertEquals(-Math.PI/4, Math.atan2(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY));
    assertEquals(-3*Math.PI/4, Math.atan2(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY));
  }

  public static void testCbrt() {
    assertEquals(2.0, Math.cbrt(8.0));
    assertEquals(Math.cbrt(-8.0), -Math.cbrt(8.0));
    assertEquals(Double.NaN, Math.cbrt(Double.NaN));
    assertEquals(Double.POSITIVE_INFINITY, Math.cbrt(Double.POSITIVE_INFINITY));
    assertEquals(Double.NEGATIVE_INFINITY, Math.cbrt(Double.NEGATIVE_INFINITY));
    assertEquals(0.0, Math.cbrt(0.0));
    assertEquals(-0.0, Math.cbrt(-0.0));
  }

  public static void testCeil() {
    assertEquals(1.0d, Math.ceil(0.1d));
    assertEquals(0.0d, Math.ceil(0.0d));
    assertEquals(Double.POSITIVE_INFINITY, Math.ceil(Double.POSITIVE_INFINITY));
    assertEquals(Double.NEGATIVE_INFINITY, Math.ceil(Double.NEGATIVE_INFINITY));
    assertEquals(0.0, Math.ceil(0.0));
    assertEquals(-0.0, Math.ceil(-0.0));
    assertEquals(-0.0, Math.ceil(-1.0 + Math.ulp(-1.0)));
    assertEquals(-1.0, Math.ceil(-1.0));
  }

  public static void testCopySign() {
    assertEquals(0.0, Math.copySign(0.0d, 0.0d));
    assertEquals(-0.0, Math.copySign(0.0d, -0.0d));
    assertEquals(0.0f, Math.copySign(0.0f, 0.0f));
    assertEquals(-0.0f, Math.copySign(0.0f, -0.0f));
  }

  public static void testCos() {
    assertEquals(1.0, Math.cos(0.0d));
    assertEquals(Double.NaN, Math.cos(Double.NaN));
    assertEquals(Double.NaN, Math.cos(Double.POSITIVE_INFINITY));
    assertEquals(Double.NaN, Math.cos(Double.NEGATIVE_INFINITY));
  }

  public static void testCosh() {
    //assertEquals(((Math.E + 1/Math.E)/2), Math.cosh(1));
    assertEquals(1.0, Math.cosh(0.0d));
    assertEquals(Double.NaN, Math.cosh(Double.NaN));
    assertEquals(Double.POSITIVE_INFINITY, Math.cosh(Double.POSITIVE_INFINITY));
    assertEquals(Double.POSITIVE_INFINITY, Math.cosh(Double.NEGATIVE_INFINITY));
  }

  public static void testExp() {
    assertTrue(Math.abs(Math.E-Math.exp(1)) <= Math.ulp(Math.E));
    assertEquals(Double.NaN, Math.exp(Double.NaN));
    assertEquals(Double.POSITIVE_INFINITY, Math.exp(Double.POSITIVE_INFINITY));
    assertEquals(0.0, Math.exp(Double.NEGATIVE_INFINITY));
  }

  public static void testExpm1() {
    assertEquals(Double.NaN, Math.expm1(Double.NaN));
    assertEquals(Double.POSITIVE_INFINITY, Math.expm1(Double.POSITIVE_INFINITY));
    assertEquals(-1.0, Math.expm1(Double.NEGATIVE_INFINITY));
    assertEquals(0.0, Math.expm1(0.0));
    assertEquals(-0.0, Math.expm1(-0.0));
  }

  public static void testFloor() {
    assertEquals(1.0, Math.floor(1.1));
    assertEquals(-2.0, Math.floor(-1.1));
    assertEquals(Double.NaN, Math.floor(Double.NaN));
    assertEquals(0.0, Math.floor(0.0));
    assertEquals(-0.0, Math.floor(-0.0));
  }

  public static void testGetExponent() {
    assertEquals(1, Math.getExponent(2));
    assertEquals(2, Math.getExponent(4));
    assertEquals(Double.MAX_EXPONENT + 1, Math.getExponent(Double.NaN));
    assertEquals(Double.MAX_EXPONENT + 1, Math.getExponent(Double.POSITIVE_INFINITY));
    assertEquals(Double.MAX_EXPONENT + 1, Math.getExponent(Double.NEGATIVE_INFINITY));
    assertEquals(Double.MIN_EXPONENT - 1, Math.getExponent(0.0));

    assertEquals(1, Math.getExponent(2f));
    assertEquals(2, Math.getExponent(4f));
    assertEquals(Float.MAX_EXPONENT + 1, Math.getExponent(Float.NaN));
    assertEquals(Float.MAX_EXPONENT + 1, Math.getExponent(Float.POSITIVE_INFINITY));
    assertEquals(Float.MAX_EXPONENT + 1, Math.getExponent(Float.NEGATIVE_INFINITY));
    assertEquals(Float.MIN_EXPONENT - 1, Math.getExponent(0.0f));

  }

  public static void testHypot() {
    assertEquals(0.0, Math.hypot(0, 0));
    assertEquals(Math.sqrt(2*2 + 3*3), Math.hypot(2, 3));
    assertEquals(Double.POSITIVE_INFINITY, Math.hypot(Double.POSITIVE_INFINITY, 1));
    assertEquals(Double.POSITIVE_INFINITY, Math.hypot(1, Double.POSITIVE_INFINITY));
    assertEquals(Double.POSITIVE_INFINITY, Math.hypot(Double.NEGATIVE_INFINITY, 1));
    assertEquals(Double.POSITIVE_INFINITY, Math.hypot(1, Double.NEGATIVE_INFINITY));
    assertEquals(Double.NaN, Math.hypot(Double.NaN, 1));
    assertEquals(Double.NaN, Math.hypot(1, Double.NaN));
  }

  public static void testIEEEremainder() {
    assertEquals(1.0, Math.IEEEremainder(1.0, 2.0));
    assertEquals(-1.0, Math.IEEEremainder(-1.0, 2.0));
    assertEquals(0.0, Math.IEEEremainder(0.0, 1.0));
    assertEquals(-0.0, Math.IEEEremainder(-0.0, 1.0));
    assertEquals(Double.NaN, Math.IEEEremainder(Double.NaN, 1.0));
    assertEquals(Double.NaN, Math.IEEEremainder(1.0, Double.NaN));
    assertEquals(Double.NaN, Math.IEEEremainder(Double.POSITIVE_INFINITY, 1.0));
    assertEquals(Double.NaN, Math.IEEEremainder(1.0, 0.0));
    assertEquals(Double.NaN, Math.IEEEremainder(1.0, -0.0));
    assertEquals(1.0, Math.IEEEremainder(1.0, Double.POSITIVE_INFINITY));
    assertEquals(1.0, Math.IEEEremainder(1.0, Double.NEGATIVE_INFINITY));
  }

  public static void testLog() {
    assertEquals(1.0, Math.log(Math.E));
    assertEquals(0.0, Math.log(1.0));
    assertEquals(Double.NaN, Math.log(Double.NaN));
    assertEquals(Double.NaN, Math.log(0.0 - Math.ulp(0.0)));
    assertEquals(Double.POSITIVE_INFINITY, Math.log(Double.POSITIVE_INFINITY));
    assertEquals(Double.NEGATIVE_INFINITY, Math.log(0.0));
    assertEquals(Double.NEGATIVE_INFINITY, Math.log(-0.0));
  }

  public static void testLog10() {
    assertEquals(1.0, Math.log10(10.0));
    assertEquals(0.0, Math.log10(1.0));
    assertEquals(Double.NaN, Math.log10(Double.NaN));
    assertEquals(Double.NaN, Math.log10(0.0 - Math.ulp(0.0)));
    assertEquals(Double.POSITIVE_INFINITY, Math.log10(Double.POSITIVE_INFINITY));
    assertEquals(Double.NEGATIVE_INFINITY, Math.log10(0.0));
    assertEquals(Double.NEGATIVE_INFINITY, Math.log10(-0.0));
  }

  public static void testLog1p() {
    assertEquals(1.0, Math.log1p(Math.E - 1.0));
    assertEquals(0.0, Math.log1p(0.0));
    assertEquals(Double.NaN, Math.log1p(Double.NaN));
    assertEquals(Double.NaN, Math.log10(-1.0 - Math.ulp(0.0)));
    assertEquals(Double.POSITIVE_INFINITY, Math.log1p(Double.POSITIVE_INFINITY));
    assertEquals(Double.NEGATIVE_INFINITY, Math.log1p(-1.0));
    assertEquals(0.0, Math.log1p(0.0));
    assertEquals(-0.0, Math.log1p(-0.0));
  }

  public static void testMax() {
    assertEquals(0.0, Math.max(0.0, -0.0));
    assertEquals(-0.0, Math.max(-1.0, -0.0));
    assertEquals(Double.NaN, Math.max(Double.NaN, 0.0));
    assertEquals(Double.NaN, Math.max(0.0, Double.NaN));

    assertEquals(0, Math.max(0, -0));
    assertEquals(-0, Math.max(-1, -0));

    assertEquals(0.0f, Math.max(0.0f, -0.0f));
    assertEquals(-0.0f, Math.max(-1.0f, -0.0f));
    assertEquals(Float.NaN, Math.max(Float.NaN, 0.0f));
    assertEquals(Float.NaN, Math.max(0.0f, Float.NaN));
  }

  public static void testMin() {
    assertEquals(-0.0, Math.min(0.0, -0.0));
    assertEquals(-1.0, Math.min(-1.0, -0.0));
    assertEquals(Double.NaN, Math.min(Double.NaN, 0.0));
    assertEquals(Double.NaN, Math.min(0.0, Double.NaN));

    assertEquals(-0, Math.min(0, -0));
    assertEquals(-1, Math.min(-1, -0));

    assertEquals(-0.0f, Math.min(0.0f, -0.0f));
    assertEquals(-1.0f, Math.min(-1.0f, -0.0f));
    assertEquals(Float.NaN, Math.min(Float.NaN, 0.0f));
    assertEquals(Float.NaN, Math.min(0.0f, Float.NaN));
  }

  public static void testNextAfter() {
    assertEquals(1.0, Math.nextAfter(1.0-Math.ulp(0.0), 1.0));
    assertEquals(Math.ulp(0.0), Math.nextAfter(0.0, 1.0));
    assertEquals(Double.NaN, Math.nextAfter(Double.NaN, 0.0));
    assertEquals(Double.NaN, Math.nextAfter(0.0, Double.NaN));
    assertEquals(0.0, Math.nextAfter(0.0, 0.0));
    assertEquals(-0.0, Math.nextAfter(0.0, -0.0));
    assertEquals(0.0, Math.nextAfter(Double.MIN_VALUE, -0.0));
    assertEquals(-0.0, Math.nextAfter(-Double.MIN_VALUE, -0.0));
    assertEquals(Double.MAX_VALUE, Math.nextAfter(Double.POSITIVE_INFINITY, 0.0));
    assertEquals(-Double.MAX_VALUE, Math.nextAfter(Double.NEGATIVE_INFINITY, 0.0));
    assertEquals(Double.POSITIVE_INFINITY, Math.nextAfter(Double.MAX_VALUE, Double.POSITIVE_INFINITY));
    assertEquals(Double.NEGATIVE_INFINITY, Math.nextAfter(-Double.MAX_VALUE, Double.NEGATIVE_INFINITY));

    assertEquals(1.0f, Math.nextAfter(1.0f-Math.ulp(0.0f), 1.0));
    assertEquals(Math.ulp(0.0f), Math.nextAfter(0.0f, 1.0));
    assertEquals(Float.NaN, Math.nextAfter(Float.NaN, 0.0));
    assertEquals(Float.NaN, Math.nextAfter(0.0f, Double.NaN));
    assertEquals(0.0f, Math.nextAfter(0.0f, 0.0));
    assertEquals(-0.0f, Math.nextAfter(0.0f, -0.0));
    assertEquals(0.0f, Math.nextAfter(Float.MIN_VALUE, -0.0));
    assertEquals(-0.0f, Math.nextAfter(-Float.MIN_VALUE, -0.0));
    assertEquals(Float.MAX_VALUE, Math.nextAfter(Float.POSITIVE_INFINITY, 0.0));
    assertEquals(-Float.MAX_VALUE, Math.nextAfter(Float.NEGATIVE_INFINITY, 0.0));
    assertEquals(Float.POSITIVE_INFINITY, Math.nextAfter(Float.MAX_VALUE, Double.POSITIVE_INFINITY));
    assertEquals(Float.NEGATIVE_INFINITY, Math.nextAfter(-Float.MAX_VALUE, Double.NEGATIVE_INFINITY));
  }

  public static void testNextUp() {
    assertEquals(Math.ulp(0.0), Math.nextUp(0.0));
    assertEquals(Double.NaN, Math.nextUp(Double.NaN));
    assertEquals(Double.POSITIVE_INFINITY, Math.nextUp(Double.POSITIVE_INFINITY));
    assertEquals(Double.MIN_VALUE, Math.nextUp(0.0));

    assertEquals(Math.ulp(0.0f), Math.nextUp(0.0f));
    assertEquals(Float.NaN, Math.nextUp(Float.NaN));
    assertEquals(Float.POSITIVE_INFINITY, Math.nextUp(Float.POSITIVE_INFINITY));
    assertEquals(Float.MIN_VALUE, Math.nextUp(0.0f));
  }

  public static void testPow() {

    assertEquals(Math.ulp(0.0)*Math.ulp(0.0), Math.pow(Math.ulp(0.0), 2));
    assertEquals(1.0, Math.pow(0.0, 0.0));
    assertEquals(1.0, Math.pow(0.0, -0.0));
    assertEquals(0.0, Math.pow(0.0, 1.0));
    assertEquals(Double.NaN, Math.pow(0.0, Double.NaN));
    assertEquals(Double.NaN, Math.pow(Double.NaN, Math.ulp(0.0)));
    assertEquals(Double.POSITIVE_INFINITY, Math.pow(1.1, Double.POSITIVE_INFINITY));

    assertEquals(Double.POSITIVE_INFINITY, Math.pow(Math.abs(1.0d+Math.ulp(1.0d)), Double.POSITIVE_INFINITY));
    assertEquals(Double.POSITIVE_INFINITY, Math.pow(Math.abs(1.0-Math.ulp(1.0)), Double.NEGATIVE_INFINITY));

    assertEquals(0.0d, Math.pow(Math.abs(1.0d+Math.ulp(1.0d)), Double.NEGATIVE_INFINITY));
    assertEquals(0.0d, Math.pow(Math.abs(1.0d-Math.ulp(1.0d)), Double.POSITIVE_INFINITY));

    assertEquals(Double.NaN, Math.pow(Math.abs(1.0), Double.POSITIVE_INFINITY));
    assertEquals(Double.NaN, Math.pow(Math.abs(1.0), Double.NEGATIVE_INFINITY));
    assertEquals(0.0, Math.pow(0.0, Math.ulp(0.0)));
    assertEquals(0.0, Math.pow(Double.POSITIVE_INFINITY, -Math.ulp(0.0)));
    assertEquals(Double.POSITIVE_INFINITY, Math.pow(0.0, -Math.ulp(0.0)));
    assertEquals(Double.POSITIVE_INFINITY, Math.pow(Double.POSITIVE_INFINITY, Math.ulp(0.0)));
    assertEquals(0.0, Math.pow(-0.0, Math.ulp(0.0)));
    assertEquals(0.0, Math.pow(Double.NEGATIVE_INFINITY, -Math.ulp(0.0)));
    assertEquals(-0.0, Math.pow(-0.0, 3));
    assertEquals(-0.0, Math.pow(Double.NEGATIVE_INFINITY, -3));
    assertEquals(Double.POSITIVE_INFINITY, Math.pow(-0.0, -Math.ulp(0.0)));
    assertEquals(Double.POSITIVE_INFINITY, Math.pow(Double.NEGATIVE_INFINITY, Math.ulp(0.0)));
    assertEquals(Double.NEGATIVE_INFINITY, Math.pow(-0.0, -3));
    assertEquals(Double.NEGATIVE_INFINITY, Math.pow(Double.NEGATIVE_INFINITY, 3));

    assertEquals(Math.pow(Math.abs(Math.ulp(0.0)), 2), Math.pow(-Math.ulp(0.0), 2));
    assertEquals(-Math.pow(Math.abs(Math.ulp(0.0)), 3), Math.pow(-Math.ulp(0.0), 3));
    assertEquals(Double.NaN, Math.pow(-Math.ulp(0.0), Math.ulp(0.0)));
  }

  public static void testRandom() {
    assertTrue(Math.random() >= 0.0);
    assertTrue(Math.random() < 1.0);
  }

  public static void testRint() {
    assertEquals(0.0, Math.rint(0.5));
    assertEquals(1.0d, Math.rint(0.5d + Math.ulp(0.5d)));

    assertEquals(0.0, Math.rint(0.0));
    assertEquals(-0.0, Math.rint(-0.0));
    assertEquals(Double.NaN, Math.rint(Double.NaN));
    assertEquals(Double.POSITIVE_INFINITY, Math.rint(Double.POSITIVE_INFINITY));
    assertEquals(Double.NEGATIVE_INFINITY, Math.rint(Double.NEGATIVE_INFINITY));
  }

  public static void testRound() {
    assertEquals(0, Math.round(0.0f));
    assertEquals(-0, Math.round(-0.0f));
    assertEquals(0, Math.round(Float.NaN));
    assertEquals(Integer.MAX_VALUE, Math.round(Float.POSITIVE_INFINITY));
    assertEquals(Integer.MIN_VALUE, Math.round(Float.NEGATIVE_INFINITY));

    assertEquals(0l, Math.round(0.0));
    assertEquals(-0l, Math.round(-0.0));
    assertEquals(0l, Math.round(Double.NaN));
    assertEquals(Long.MAX_VALUE, Math.round(Double.POSITIVE_INFINITY));
    assertEquals(Long.MIN_VALUE, Math.round(Double.NEGATIVE_INFINITY));
  }

  public static void testScalb() {
    assertEquals(0.0, Math.scalb(0.0, 0));
    assertEquals(2.0, Math.scalb(1.0, 1));
    assertEquals(Double.NaN, Math.scalb(Double.NaN, 1));
    assertEquals(Double.POSITIVE_INFINITY, Math.scalb(Double.POSITIVE_INFINITY, 1));
    assertEquals(Double.NEGATIVE_INFINITY, Math.scalb(Double.NEGATIVE_INFINITY, 1));
    assertEquals(0.0, Math.scalb(0.0, 1));
    assertEquals(-0.0, Math.scalb(-0.0, 1));

    assertEquals(0.0f, Math.scalb(0.0f, 0));
    assertEquals(2.0f, Math.scalb(1.0f, 1));
    assertEquals(Float.NaN, Math.scalb(Float.NaN, 1));
    assertEquals(Float.POSITIVE_INFINITY, Math.scalb(Float.POSITIVE_INFINITY, 1));
    assertEquals(Float.NEGATIVE_INFINITY, Math.scalb(Float.NEGATIVE_INFINITY, 1));
    assertEquals(0.0f, Math.scalb(0.0f, 1));
    assertEquals(-0.0f, Math.scalb(-0.0f, 1));
  }

  public static void testSignum() {
    assertEquals(0.0, Math.signum(0.0));
    assertEquals(1.0, Math.signum(Math.ulp(0.0)));
    assertEquals(-1.0, Math.signum(-Math.ulp(0.0)));
    assertEquals(Double.NaN, Math.signum(Double.NaN));
    assertEquals(-0.0, Math.signum(-0.0));

    assertEquals(0.0f, Math.signum(0.0f));
    assertEquals(1.0f, Math.signum(Math.ulp(0.0f)));
    assertEquals(-1.0f, Math.signum(-Math.ulp(0.0f)));
    assertEquals(Float.NaN, Math.signum(Float.NaN));
    assertEquals(-0.0f, Math.signum(-0.0f));
  }

  public static void testSin() {
    assertEquals(0.0, Math.sin(0.0));
    assertEquals(Double.NaN, Math.sin(Double.NaN));
    assertEquals(Double.NaN, Math.sin(Double.POSITIVE_INFINITY));
    assertEquals(Double.NaN, Math.sin(Double.NEGATIVE_INFINITY));
    assertEquals(-0.0, Math.sin(-0.0));
  }

  public static void testSinh() {
    assertEquals(0.0, Math.sinh(0.0));
    assertEquals(Double.NaN, Math.sinh(Double.NaN));
    assertEquals(Double.POSITIVE_INFINITY, Math.sinh(Double.POSITIVE_INFINITY));
    assertEquals(Double.NEGATIVE_INFINITY, Math.sinh(Double.NEGATIVE_INFINITY));
    assertEquals(-0.0, Math.sinh(-0.0));
  }

  public static void testSqrt() {
    assertEquals(2.0, Math.sqrt(4.0));
    assertEquals(Double.NaN, Math.sqrt(Double.NaN));
    assertEquals(Double.NaN, Math.sqrt(-Math.ulp(0.0)));
    assertEquals(Double.POSITIVE_INFINITY, Math.sqrt(Double.POSITIVE_INFINITY));
    assertEquals(0.0, Math.sqrt(0.0));
    assertEquals(-0.0, Math.sqrt(-0.0));
  }

  public static void testTan() {
    assertEquals(0.0, Math.tan(0.0));
    assertEquals(Double.NaN, Math.tan(Double.NaN));
    assertEquals(Double.NaN, Math.tan(Double.POSITIVE_INFINITY));
    assertEquals(Double.NaN, Math.tan(Double.NEGATIVE_INFINITY));
    assertEquals(-0.0, Math.tan(-0.0));
  }

  public static void testTanh() {
    assertEquals(0.0, Math.tanh(0.0));
    assertEquals(Double.NaN, Math.tanh(Double.NaN));
    assertEquals(1.0, Math.tanh(Double.POSITIVE_INFINITY));
    assertEquals(-1.0, Math.tanh(Double.NEGATIVE_INFINITY));
    assertEquals(-0.0, Math.tanh(-0.0));
  }

  public static void testToDegrees() {
    assertEquals(0.0, Math.toDegrees(0.0));
    assertEquals(180.0, Math.toDegrees(Math.PI));
    assertEquals(-180.0, Math.toDegrees(-Math.PI));
  }

  public static void testToRadians() {
    assertEquals(0.0, Math.toRadians(0.0));
    assertEquals(Math.PI, Math.toRadians(180));
    assertEquals(-Math.PI, Math.toRadians(-180));
  }

  public static void testUlp() {
    assertEquals(Double.NaN, Math.ulp(Double.NaN));
    assertEquals(Double.POSITIVE_INFINITY, Math.ulp(Double.POSITIVE_INFINITY));
    assertEquals(Double.POSITIVE_INFINITY, Math.ulp(Double.NEGATIVE_INFINITY));
    assertEquals(Double.MIN_VALUE, Math.ulp(0.0));
    assertEquals(Double.MIN_VALUE, Math.ulp(-0.0));
    assertEquals(Math.pow(2, 971), Math.ulp(Double.MAX_VALUE));
    assertEquals(Math.pow(2, 971), Math.ulp(-Double.MAX_VALUE));

    assertEquals(Float.NaN, Math.ulp(Float.NaN));
    assertEquals(Float.POSITIVE_INFINITY, Math.ulp(Float.POSITIVE_INFINITY));
    assertEquals(Float.POSITIVE_INFINITY, Math.ulp(Float.NEGATIVE_INFINITY));
    assertEquals(Float.MIN_VALUE, Math.ulp(0.0f));
    assertEquals(Float.MIN_VALUE, Math.ulp(-0.0f));

    // TODO: AssertionError: Expected 2.028240960365167E31, but was: 2.028241E31
    //assertEquals(Math.pow(2.0f, 104), Math.ulp(Float.MAX_VALUE));
    //assertEquals(Math.pow(2.0f, 104), Math.ulp(-Float.MAX_VALUE));
    assertEquals(2.028241E31f, Math.ulp(Float.MAX_VALUE));
    assertEquals(2.028241E31f, Math.ulp(-Float.MAX_VALUE));
  }

  public static void main(String[] args) {
    testAbs();
    testAcos();
    testAsin();
    testAtan();
    testAtan2();
    testCbrt();
    testCeil();
    testCopySign();
    testCos();
    testCosh();
    testExp();
    testExpm1();
    testFloor();
    testGetExponent();
    testHypot();
    testIEEEremainder();
    testLog();
    testLog10();
    testLog1p();
    testMax();
    testMin();
    testNextAfter();
    testNextUp();
    testPow();
    testRandom();
    testRint();
    testRound();
    testScalb();
    testSignum();
    testSin();
    testSinh();
    testTan();
    testTanh();
    testToDegrees();
    testToRadians();
    testUlp();
  }
}
