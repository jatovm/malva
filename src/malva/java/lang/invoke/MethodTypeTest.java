package malva.java.lang.invoke;

import java.lang.invoke.MethodType;

import java.util.Arrays;

import malva.TestCase;

public class MethodTypeTest extends TestCase {

  private static void testAppendParameterTypes() throws Throwable {
    // TODO
  }

  private static void testChangeParameterType() throws Throwable {
    // TODO
  }

  private static void testChangeReturnType() throws Throwable {
    // TODO
  }

  private static void testDropParameterType() throws Throwable {
    // TODO
  }

  private static void testEquals() throws Throwable {
    MethodType mh1 = MethodType.methodType(String.class, Arrays.<Class<?>>asList(Integer.class, Byte.class));
    MethodType mh2 = MethodType.methodType(String.class, Arrays.<Class<?>>asList(Integer.class, Byte.class));
    MethodType mh3 = MethodType.methodType(String.class, Arrays.<Class<?>>asList(Integer.class, Integer.class));

    assertFalse(mh1.equals(null));
    assertFalse(mh1.equals(new Object()));

    assertTrue(mh1.equals(mh2));
    assertTrue(mh2.equals(mh1));

    assertFalse(mh1.equals(mh3));
    assertFalse(mh3.equals(mh1));
  }

  private static void testErase() throws Throwable {
    // TODO
  }

  private static void testFromMethodDescriptorString() throws Throwable {
    // TODO
  }

  private static void testGeneric() throws Throwable {
    // TODO
  }

  private static void testGenericMethodType() throws Throwable {
    // TODO
  }

  private static void testHasPrimitives() throws Throwable {
    // TODO
  }

  private static void testHasWrappers() throws Throwable {
    // TODO
  }

  private static void testHashCode() throws Throwable {
    // TODO
  }

  private static void testInsertParameterTypes() throws Throwable {
    // TODO
  }

  private static void testMethodType() throws Throwable {
    // TODO
  }

  private static void testParameterArray() throws Throwable {
    // TODO
  }

  private static void testParameterCount() throws Throwable {
    // TODO
  }

  private static void testParameterList() throws Throwable {
    // TODO
  }

  private static void testParameterType() throws Throwable {
    // TODO
  }

  private static void testReturnType() throws Throwable {
    // TODO
  }

  private static void testToMethodDescriptorString() throws Throwable {
    MethodType mh1 = MethodType.methodType(String.class, Arrays.<Class<?>>asList(Integer.class, Byte.class));
    assertEquals("(Ljava/lang/Integer;Ljava/lang/Byte;)Ljava/lang/String;", mh1.toMethodDescriptorString());

    MethodType mh2 = MethodType.methodType(void.class, Arrays.<Class<?>>asList(int.class, int.class));
    assertEquals("(II)V", mh2.toMethodDescriptorString());
  }

  private static void testToString() throws Throwable {
    MethodType mh = MethodType.methodType(String.class, Arrays.<Class<?>>asList(Integer.class, Byte.class));

    assertEquals("(Integer,Byte)String", mh.toString());
  }

  private static void testUnwrap() throws Throwable {
    // TODO
  }

  private static void testWrap() throws Throwable {
    // TODO
  }

  public static void main(String[] args) throws Throwable {
    testAppendParameterTypes();
    testChangeParameterType();
    testChangeReturnType();
    testDropParameterType();
    testEquals();
    testErase();
    testFromMethodDescriptorString();
    testGeneric();
    testGenericMethodType();
    testHasPrimitives();
    testHasWrappers();
    testHashCode();
    testInsertParameterTypes();
    testMethodType();
    testParameterArray();
    testParameterCount();
    testParameterList();
    testParameterType();
    testReturnType();
    testToMethodDescriptorString();
    testToString();
    testUnwrap();
    testWrap();
  }
}
