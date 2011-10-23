package malva.java.util;

import java.util.HashMap;

import malva.TestCase;

public class HashMapTest extends TestCase {
  private static void testPutNullKey() {
    HashMap<Object, Object> map = new HashMap<Object, Object>();
    Object value = new Object();
    map.put(null, value);
    assertEquals(value, map.get(null));
  }

  public static void main(String[] args) {
    testPutNullKey();
  }
}
