package malva.java.lang;

import java.io.StringWriter;
import malva.TestCase;

public class ThrowableTest extends TestCase {
  public static void testConstruction() {
    assertEquals(Throwable.class, new Throwable().getClass());
    assertEquals("Message", new Throwable("Message").getMessage());
    assertEquals((String) null, new Throwable((String) null).getMessage());
    assertEquals("Cause", new Throwable("Message", new Throwable("Cause")).getCause().getMessage());
    assertEquals("Cause", new Throwable(new Throwable("Cause")).getCause().getMessage());
    assertEquals((Throwable) null, new Throwable((Throwable) null).getCause());
    assertEquals("null", "" + new Throwable((Throwable) null).getMessage());
    // TODO: debug why String objects are not the same
    assertFalse("null".equals(new Throwable((Throwable) null).getMessage()));
  }

  public static void testFillInStackTrace() {
    Throwable throwable = new Throwable();
    assertEquals(throwable, throwable.fillInStackTrace());
    assertEquals("malva.java.lang.ThrowableTest.testFillInStackTrace", throwable.getStackTrace()[0].toString().substring(0, 50));
  }

  public static void testGetCause() {
    Throwable throwable = new Throwable("Cause");
    assertEquals(throwable, new Throwable("Message", throwable).getCause());
    assertEquals(throwable, new Throwable("Message").initCause(throwable).getCause());
    assertEquals((Throwable) null, new Throwable().getCause());
  }

  public static void testGetLocalizedMessage() {
    Throwable throwable = new Throwable("åäö");
    assertEquals(throwable.getMessage(), throwable.getLocalizedMessage());
  }

  public static void testGetMessage() {
    assertEquals("Message", new Throwable("Message").getMessage());
    assertEquals((String) null, new Throwable((String) null).getMessage());
  }

  public static void testGetStackTrace() {
    Throwable throwable = new Throwable();
    assertEquals(throwable, throwable.fillInStackTrace());
    //In the extreme case, a virtual machine that has no stack trace information concerning this
    // throwable is permitted to return a zero-length array from this method
    if (throwable.getStackTrace().length > 0)
      assertEquals("malva.java.lang.ThrowableTest.testGetStackTrace", throwable.getStackTrace()[0].toString().substring(0, 47));
  }

  public static void testInitCause() {
    final Throwable throwable = new Throwable("Cause");
    assertEquals(throwable, new Throwable("Message").initCause(throwable).getCause());
    assertThrows(new Block() {
      @Override public void run() {
        throwable.initCause(throwable);
      }
    }, IllegalArgumentException.class);

    assertThrows(new Block() {
      @Override public void run() {
        Throwable throwableWithACause = new Throwable(throwable);
        throwableWithACause.initCause(throwable);
      }
    }, IllegalStateException.class);
  }

  public static void testPrintStackTrace() {
    StringWriter stringWriter = new StringWriter();
    new Throwable("Message").printStackTrace(new java.io.PrintWriter(stringWriter));
    assertEquals("java.lang.Throwable: Message".substring(0, 28), stringWriter.getBuffer().substring(0, 28));
    // TODO: find out why the String objects are not the same
    assertFalse("java.lang.Throwable: Message".equals(stringWriter.getBuffer()));
  }

  public static void testSetStackTrace() {
    StackTraceElement stackTraceElement = new StackTraceElement("TestClass", "TestMethod", "TestFile.java", 42);
    StackTraceElement[] stackTraceElements = new StackTraceElement[1];
    stackTraceElements[0] = stackTraceElement;
    final Throwable throwable = new Throwable();
    throwable.setStackTrace(stackTraceElements);
    assertEquals(stackTraceElements[0].toString(), throwable.getStackTrace()[0].toString());
    assertTrue(stackTraceElements != throwable.getStackTrace());
  }

  public static void testToString() {
    assertEquals("java.lang.Throwable" + ": " + "Message", new Throwable("Message").toString());
  }

  public static void main(String[] args) {
    testConstruction();
    testFillInStackTrace();
    testGetCause();
    testGetLocalizedMessage();
    testGetMessage();
    testGetStackTrace();
    testInitCause();
    testPrintStackTrace();
    testSetStackTrace();
    testToString();
  }
}
