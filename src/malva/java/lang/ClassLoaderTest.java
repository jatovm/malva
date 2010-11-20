package malva.java.lang;

import java.net.URL;
import java.util.Enumeration;

import malva.TestCase;

public class ClassLoaderTest extends TestCase {

  public static void testClearAssertionStatus() {
    // Just check that the call does not cause an exception
    ClassLoader.getSystemClassLoader().clearAssertionStatus();
  }

  public static void testGetParent() {
    // Just check that the call does not cause an exception
    ClassLoader.getSystemClassLoader().getParent();
  }

  public static void testGetResource() {
    assertNull(ClassLoader.getSystemClassLoader().getResource("doesNotExist"));
    assertNotNull(ClassLoader.getSystemClassLoader().getResource("./malva/java/lang/ClassLoaderTest.class"));
  }

  public static void testGetResourceAsStream() {
    assertNull(ClassLoader.getSystemClassLoader().getResourceAsStream("doesNotExist"));
    assertNotNull(ClassLoader.getSystemClassLoader().getResourceAsStream("./malva/java/lang/ClassLoaderTest.class"));
  }

  public static void testGetResources() {
    try {
      Enumeration<URL> enumeration = ClassLoader.getSystemClassLoader().getResources("doesNotExist");
      assertFalse(enumeration.hasMoreElements());

      enumeration = ClassLoader.getSystemClassLoader().getResources("./malva/java/lang/ClassLoaderTest.class");
      assertTrue(enumeration.hasMoreElements());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void testGetSystemClassLoader() {
    assertNotNull(ClassLoader.getSystemClassLoader());
  }

  public static void testGetSystemResource() {
    assertNull(ClassLoader.getSystemResource("doesNotExists"));
    assertNotNull(ClassLoader.getSystemResource("./malva/java/lang/ClassLoaderTest.class"));
  }

  public static void testGetSystemResourceAsStream() {
    assertNull(ClassLoader.getSystemResourceAsStream("doesNotExists"));
    assertNotNull(ClassLoader.getSystemResourceAsStream("./malva/java/lang/ClassLoaderTest.class"));
  }

  public static void testGetSystemResources() {
    try {
      Enumeration<URL> enumeration = ClassLoader.getSystemResources("doesNotExist");
      assertFalse(enumeration.hasMoreElements());

      enumeration = ClassLoader.getSystemResources("./malva/java/lang/ClassLoaderTest.class");
      assertTrue(enumeration.hasMoreElements());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void testLoadClass() {
    assertThrows(new Block() {
      @Override public void run() throws Exception {
        ClassLoader.getSystemClassLoader().loadClass("doesNotExist");
      }
    }, ClassNotFoundException.class);

    try {
      assertEquals("malva.java.lang.ClassLoaderTest", ClassLoader.getSystemClassLoader().loadClass("malva.java.lang.ClassLoaderTest").getCanonicalName());
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void testSetClassAssertionStatus() {
    // Just check that these do not cause an exception
    ClassLoader.getSystemClassLoader().setClassAssertionStatus("malva.java.lang.ClassLoaderTest", true);
    ClassLoader.getSystemClassLoader().setClassAssertionStatus("malva.java.lang.ClassLoaderTest", false);
  }

  public static void testSetDefaultAssertionStatus() {
    // Just check that these do not cause an exception
    ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
    ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(false);
  }

  public static void testSetPackageAssertionStatus() {
    // Just check that these do not cause an exception
    ClassLoader.getSystemClassLoader().setPackageAssertionStatus("apackage", true);
    ClassLoader.getSystemClassLoader().setPackageAssertionStatus("apackage", false);
    ClassLoader.getSystemClassLoader().setPackageAssertionStatus(null, true);
    ClassLoader.getSystemClassLoader().setPackageAssertionStatus(null, false);
  }

  public static void main(String[] args) {
    testClearAssertionStatus();
    testGetParent();
    testGetResource();
    testGetResourceAsStream();
    testGetResources();
    testGetSystemClassLoader();
    testGetSystemResource();
    testGetSystemResourceAsStream();
    testGetSystemResources();
    testLoadClass();
    testSetClassAssertionStatus();
    testSetDefaultAssertionStatus();
    testSetPackageAssertionStatus();
  }
}