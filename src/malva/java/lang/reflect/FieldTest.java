package malva.java.lang.reflect;

import java.lang.reflect.Field;

import malva.TestCase;

public class FieldTest extends TestCase {
  public static class BaseType {
    public Object baseField;
  }

  public static class Type extends BaseType {
    public Object field;
  }

  public static void testSet() throws Exception {
    Type t = new Type();
    Field field = t.getClass().getField("field");
    Object o1 = new Object();
    field.set(t, o1);
    assertEquals(o1, t.field);

    Field baseField = t.getClass().getField("baseField");
    Object o2 = new Object();
    baseField.set(t, o2);
    assertEquals(o2, t.baseField);
  }

  public static void main(String[] args) throws Exception {
    testSet();
  }
}
