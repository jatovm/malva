package malva.java.lang;

import malva.TestCase;

public class ObjectTest extends TestCase {
  public static void testClone() {
    assertThrows(new Block() {
      @Override public void run() throws CloneNotSupportedException {
        this.clone();
      }
    }, CloneNotSupportedException.class);
    
    // Actually we are testing that arrays are clonable 
    assertTrue(new String[] {"a", "b"}.clone() != null);
  }
  
  public static void testEquals() {    
  }

  public static void testFinalize() {
  }
  
  public static void testGetClass() {
    ObjectTest objectTest = new ObjectTest(); 
    assertTrue(objectTest.getClass() == ObjectTest.class);
  }
  
  public static void testHashCode() {
  }
  
  public static void testNotify() {
    assertThrows(new Block() {
      @Override public void run() {
        Object o = new Object();
        o.notify();
      }
    }, IllegalMonitorStateException.class);    
  }
  
  public static void testNotifyAll() {
    assertThrows(new Block() {
      @Override public void run() {
        Object o = new Object();
        o.notifyAll();
      }
    }, IllegalMonitorStateException.class);    
  }
  
  public static void testToString() {
    Object o = new Object();
    assertEquals(o.getClass().getName() + "@" + Integer.toHexString(o.hashCode()), o.toString());
  }

  public static void testWait() {
  }
  
  public static void main(String[] args) {
    testClone();
    testEquals();
    testFinalize();
    testGetClass();
    testHashCode();
    testNotify();
    testNotifyAll();
    testToString();
    testWait();
  }
}
