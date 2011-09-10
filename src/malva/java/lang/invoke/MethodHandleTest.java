package malva.java.lang.invoke;

import java.lang.invoke.MethodType;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

import malva.TestCase;

public class MethodHandleTest extends TestCase {
  static final MethodHandles.Lookup lookup = MethodHandles.lookup();

  private static void testAsCollector() throws Throwable {
    // TODO
  }

  private static void testAsFixedArity() throws Throwable {
    // TODO
  }

  private static void testAsSpreader() throws Throwable {
    // TODO
  }

  private static void testAsType() throws Throwable {
    // TODO
  }

  private static void testAsVarargsCollector() throws Throwable {
    // TODO
  }

  private static void testBindTo() throws Throwable {
    // TODO
  }

  private static void testInvoke() throws Throwable {
    MethodType mt = MethodType.methodType(String.class);
    MethodHandle mh = lookup.findVirtual(String.class, "toString", mt);

    assertEquals("hello, world", (String) mh.invoke("hello, world"));
  }

  private static void testInvokeExact() throws Throwable {
    // TODO
  }

  private static void testInvokeWithArguments() throws Throwable {
    // TODO
  }

  private static void testIsVarargsCollector() throws Throwable {
    // TODO
  }

  private static void testToString() throws Throwable {
    MethodType mt = MethodType.methodType(String.class);
    MethodHandle mh = lookup.findVirtual(String.class, "toString", mt);

    //assertEquals("MethodHandle(String)String", mh.toString());
  }

  private static void testType() throws Throwable {
    // TODO
  }

  public static void main(String[] args) throws Throwable {
    testAsCollector();
    testAsFixedArity();
    testAsSpreader();
    testAsType();
    testAsVarargsCollector();
    testBindTo();
    testInvoke();
    testInvokeExact();
    testInvokeWithArguments();
    testIsVarargsCollector();
    testToString();
    testType();
  }
}
