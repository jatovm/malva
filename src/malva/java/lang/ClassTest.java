package malva.java.lang;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
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

  public static void testGetAnnotations() {
    assertEquals(0, Object.class.getAnnotations().length);
    assertEquals(1, AnnotatedClass.class.getAnnotations().length);
  }

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

  public static void testGetName() {
    assertEquals("int", int.class.getName());
    assertEquals("[I", int[].class.getName());
    assertEquals("[[I", int[][].class.getName());
    assertEquals("java.lang.Object", Object.class.getName());
    assertEquals("[Ljava.lang.Object;", Object[].class.getName());
    assertEquals("malva.java.lang.ClassTest$InnerClass", InnerClass.class.getName());
  }

  // getPackage
  // getProtectionDomain
  // getResource
  // getResourceAsStream
  // getSigners

  public static void testGetSimpleName() {
    assertEquals("int", int.class.getSimpleName());
    assertEquals("int[]", int[].class.getSimpleName());
    assertEquals("int[][]", int[][].class.getSimpleName());
    assertEquals("Object[]", Object[].class.getSimpleName());
    assertEquals("Object", Object.class.getSimpleName());
    assertEquals("InnerClass", InnerClass.class.getSimpleName());
  }
  public static class InnerClass { };

  public static void testGetSuperclass() {
    assertNull(Object.class.getSuperclass());
    assertEquals(Throwable.class, Exception.class.getSuperclass());
  }

  public static void testGetTypeParameters() {
    assertEquals(0, Object.class.getTypeParameters().length);
    assertEquals(Arrays.asList("T", "V"), transform(Arrays.asList(GenericClass.class.getTypeParameters()),
      new Transformer<TypeVariable<Class<GenericClass>>, String>() {
        @Override public String transform(TypeVariable<Class<GenericClass>> value) {
          return value.getName();
        }
      }));
  }
  public static class GenericClass<T, V> { };

  public static void testIsAnnotation() {
    assertFalse(Object.class.isAnnotation());
    assertTrue(Deprecated.class.isAnnotation()); 
  }
  @Retention(RetentionPolicy.RUNTIME) public @interface Deprecated { }

  public static void testIsAnnotationPresent() {
    assertFalse(Object.class.isAnnotationPresent(Deprecated.class));
    assertFalse(AnnotatedClass.class.isAnnotationPresent(Generated.class));
    assertTrue(AnnotatedClass.class.isAnnotationPresent(Deprecated.class));
  }
  @Generated @Deprecated public static class AnnotatedClass { }
  public @interface Generated { }

  public static void testIsAnonymousClass() {
    assertFalse(Object.class.isAnonymousClass());
    assertTrue(new Object() {}.getClass().isAnonymousClass());
  }

  public static void testIsArray() {
    assertFalse(Object.class.isArray());
    assertFalse(int.class.isArray());
    assertTrue(Object[].class.isArray());
    assertTrue(int[].class.isArray());
  }

  public static void testIsAssignableFrom() {
    assertTrue (Throwable.class.isAssignableFrom(Throwable.class));
    assertTrue (Throwable.class.isAssignableFrom(Exception.class));
    assertFalse(Throwable.class.isAssignableFrom(Object.class   ));
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        Throwable.class.isAssignableFrom(null);
      }
    }, NullPointerException.class);
  }

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

  public static void testIsLocalClass() {
    assertFalse(Object.class.isLocalClass());
    class LocalClass {
    }
    assertTrue(LocalClass.class.isLocalClass());
  }

  public static void testIsMemberClass() {
    assertFalse(Object.class.isMemberClass());
    assertTrue(MemberClass.class.isMemberClass());
  }
  protected class MemberClass {
  }

  public static void testIsPrimitive() {
    assertFalse(Object.class.isPrimitive());
    assertFalse(Object[].class.isPrimitive());
    assertFalse(int[].class.isPrimitive());
    assertTrue(int.class.isPrimitive());
  }

  public static void testIsSynthetic() {
    assertFalse(Object.class.isSynthetic());
    // FIXME: Synthetic classes?
  }

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

  public static void testToString() {
    assertEquals("class java.lang.Object", Object.class.toString());
  }

  public static void main(String[] args) throws Exception {
    testAsSubclass();
    testCast();
    testDesiredAssertionStatus();
    testForName();
    testGetAnnotations();
    testGetName();
    testGetSimpleName();
    testGetSuperclass();
    testGetTypeParameters();
    testIsAnnotation();
    testIsAnnotationPresent();
    testIsAnonymousClass();
    testIsArray();
    testIsAssignableFrom();
    testIsEnum();
    testIsInstance();
    testIsInterface();
    testIsLocalClass();
    testIsMemberClass();
    testIsPrimitive();
    testIsSynthetic();
    testNewInstance();
    testToString();
  }
}
