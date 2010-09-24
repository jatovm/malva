package malva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TestCase {
  protected static <T, V> List<V> transform(T[] values, Transformer<T, V> transformer) {
    return transform(Arrays.asList(values), transformer);
  }

  protected static <T, V> List<V> transform(List<T> values, Transformer<T, V> transformer) {
    List<V> result = new ArrayList<V>();
    for (T value : values) {
      result.add(transformer.transform(value));
    }
    return result;
  }
  protected interface Transformer<T, V> {
    V transform(T value);
  }

  protected interface Block {
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

  protected static <T extends Comparable<? super T>> void assertEqualsUnordered(Collection<T> expected, Collection<T> actual) {
    List<T> e = new ArrayList<T>(expected);
    Collections.sort(e);
    List<T> a = new ArrayList<T>(actual);
    Collections.sort(a);
    assertEquals(e, a);
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
