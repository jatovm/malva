package malva;

public class TestCase {
  public interface Block {
    void run() throws Throwable;
  }

  protected static void assertThrows(Block block, Class<? extends Throwable> type) {
    try {
      block.run();
    } catch (Throwable t) {
       assertEquals(type, t.getClass());
       return;
    }
    fail("Expected " + type.toString() + " to be thrown");
  }

  protected static void assertTrue(boolean actual) {
    assertEquals(true, actual);
  }

  protected static void assertFalse(boolean actual) {
    assertEquals(false, actual);
  }

  protected static void assertEquals(Object expected, Object actual) {
    if (expected == actual)
       return;

    if (expected == null || !expected.equals(actual))
      fail("Expected " + expected + ", but was: " + actual);
  }

  protected static void assertNull(Object o) {
    if (o != null)
       fail("Expected null, but was: " + o);
  }

  protected static void assertNotNull(Object o) {
    if (o == null)
       fail("Expected non-null, but was: null");
  }

  protected static void fail(String s) {
    throw new AssertionError(s);
  }
}
