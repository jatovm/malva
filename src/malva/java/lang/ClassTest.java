package malva.java.lang;

import malva.TestCase;

public class ClassTest extends TestCase {
  public static void testAsSubclass() {
    assertNotNull(Exception.class.asSubclass(Throwable.class));
    assertThrows(new Block() {
      @Override public void run() {
        Object.class.asSubclass(Throwable.class);
      }
    }, ClassCastException.class);
  }

  public static void testCast() {
    Object e = new Exception();
    assertEquals(e, Throwable.class.cast(e));
    assertThrows(new Block() {
      @Override public void run() {
        Throwable.class.cast(new Object());
      }
    }, ClassCastException.class);
  }

  public static void testDesiredAssertionStatus() {
    // FIXME:

    // GNU Classpath returns true for defaultAssertionStatus by default whereas
    // OpenJDK returns false.

    // assertFalse(Object.class.desiredAssertionStatus());
  }

  public static void testForName() throws Exception {
    assertEquals(Object.class, Class.forName("java.lang.Object"));
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        Class.forName("nosuchclass");
      }
    }, ClassNotFoundException.class);
  }

  // getAnnotations
  // getCanonicalName
  // getClasses
  // getClassLoader
  // getComponentType
  // getConstructor
  // getConstructors
  // getDeclaredAnnotations
  // getDeclaredClasses
  // getDeclaredConstructor
  // getDeclaredConstructors
  // getDeclaredField
  // getDeclaredFields
  // getDeclaredMethod
  // getDeclaredMethods
  // getDeclaringClass
  // getEnclosingClass
  // getEnclosingConstructor
  // getEnclosingMethod
  // getEnumConstants
  // getField
  // getFields
  // getGenericInterfaces
  // getGenericSuperclass
  // getInterfaces
  // getMethod
  // getMethods
  // getModifiers
  // getName
  // getPackage
  // getProtectionDomain
  // getResource
  // getResourceAsStream
  // getSigners
  // getSimpleName
  // getSuperclass
  // getTypeParameters
  // isAnnotation
  // isAnnotationPresent
  // isAnonymousClass

  public static void testIsArray() {
    assertFalse(Object.class.isArray());
    assertFalse(int.class.isArray());
    assertTrue(Object[].class.isArray());
    assertTrue(int[].class.isArray());
  }

  // isAssignableFrom

  public static void testIsEnum() {
    assertTrue(Enumeration.class.isEnum());
    assertFalse(Enum.class.isEnum());
    assertFalse(Object.class.isEnum());
  }
  private static enum Enumeration { };

  public static void testIsInstance() {
    assertTrue (Throwable.class.isInstance(new Throwable()));
    assertTrue (Throwable.class.isInstance(new Exception()));
    assertFalse(Throwable.class.isInstance(new Object()   ));
  }

  public static void testIsInterface() {
    assertFalse(Object.class.isInterface());
    assertTrue(Runnable.class.isInterface());
  }

  // isLocalClass
  // isMemberClass

  public static void testIsPrimitive() {
    assertFalse(Object.class.isPrimitive());
    assertFalse(Object[].class.isPrimitive());
    assertFalse(int[].class.isPrimitive());
    assertTrue(int.class.isPrimitive());
  }

  // isSynthetic

  public static void testNewInstance() throws Exception {
    assertNotNull(Object.class.newInstance());
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        ClassLoader.class.newInstance();
      }
    }, IllegalAccessException.class);
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        Double.class.newInstance();
      }
    }, InstantiationException.class);
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        FailingInitializer.class.newInstance();
      }
    }, ExceptionInInitializerError.class);
    // TODO: SecurityException
  }
  public static class FailingInitializer {
    static {
      try {
        // Throws IllegalMonitorStateException
        new Object().wait();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }

  // toString

  public static void main(String[] args) throws Exception {
    testAsSubclass();
    testCast();
    testDesiredAssertionStatus();
    testForName();
    testIsArray();
    testIsEnum();
    testIsInstance();
    testIsInterface();
    testIsPrimitive();
    testNewInstance();
  }
}
