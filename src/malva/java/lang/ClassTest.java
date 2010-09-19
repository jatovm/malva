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
    assertFalse(Object.class.desiredAssertionStatus());
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
  // isArray
  // isAssignableFrom
  // isEnum
  // isInstance
  // isInterface
  // isLocalClass
  // isMemberClass
  // isPrimitive
  // isSynthetic
  // newInstance
  // toString

  public static void main(String[] args) throws Exception {
    testAsSubclass();
    testCast();
    testDesiredAssertionStatus();
    testForName();
  }
}
