package malva.java.lang;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.channels.Channel;
import java.util.Properties;

import malva.TestCase;

public class SystemTest extends TestCase {
  public static void testArraycopy() {
    String[] source = new String[] {"1", "2"};
    String[] dest = new String[2];
    System.arraycopy(source, 0, dest, 0, 2);
    assertEquals(source[1], dest[1]);
    System.arraycopy(source, 0, source, 1, 1);
    assertEquals("1", source[1]);
    System.arraycopy(new String[0], 0, new String[0], 0, 0);

    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy(new String[0], 0, null, 0, 0);
      }
    }, NullPointerException.class);
    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy(null, 0, new String[0], 0, 0);
      }
    }, NullPointerException.class);

    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy("", 0, new String[0], 0, 0);
      }
    }, ArrayStoreException.class);

    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy(new String[0], 0, "", 0, 0);
      }
    }, ArrayStoreException.class);

    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy(new float[0], 0, new int[0], 0, 0);
      }
    }, ArrayStoreException.class);

    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy(new float[0], 0, new Float[0], 0, 0);
      }
    }, ArrayStoreException.class);

    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy(new Float[0], 0, new float[0], 0, 0);
      }
    }, ArrayStoreException.class);

    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy(new float[0], -1, new float[0], 0, 0);
      }
    }, ArrayIndexOutOfBoundsException.class);

    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy(new float[0], 0, new float[0], -1, 0);
      }
    }, ArrayIndexOutOfBoundsException.class);

    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy(new float[0], 0, new float[0], 0, -1);
      }
    }, ArrayIndexOutOfBoundsException.class);

    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy(new float[0], 0, new float[0], 0, 1);
      }
    }, ArrayIndexOutOfBoundsException.class);

    final Object[] mixSrc = new Object[] {new Integer(0), new Integer(1), ""};
    final Integer[] mixDest = new Integer[3];
    assertThrows(new Block() {
      @Override public void run() {
        System.arraycopy(mixSrc, 0, mixDest, 0, 3);
      }
    }, ArrayStoreException.class);

    assertEquals(mixDest[1], new Integer(1));
  }

  public static void testClearProperty() {
    assertEquals(null, System.clearProperty("DOES_NOT_EXIST_42"));

    assertThrows(new Block() {
      @Override public void run() {
        System.clearProperty(null);
      }
    }, NullPointerException.class );

    assertThrows(new Block() {
      @Override public void run() {
        System.clearProperty("");
      }
    }, IllegalArgumentException.class );
  }

  public static void testConsole() {
  }

  public static void testCurrentTimeMillis() {
    assertTrue((System.currentTimeMillis() - System.currentTimeMillis()) <= 0);
  }

  public static void testExit() {
  }

  public static void testGc() {
  }

  public static void testGetenv() {
    java.util.Map<String, String> env = System.getenv();
    for(String value: env.keySet()) {
      assertNotNull(value);
      assertNotNull(env.get(value));
    }

    assertThrows(new Block() {
      @Override public void run() {
        System.getenv(null);
      }
    }, NullPointerException.class);
  }

  public static void testGetProperties() {
    Properties props = System.getProperties();
    assertNotNull(props.getProperty("java.version"));
    assertNotNull(props.getProperty("java.vendor"));
    assertNotNull(props.getProperty("java.vendor.url"));
    assertNotNull(props.getProperty("java.home"));
    assertNotNull(props.getProperty("java.vm.specification.version"));
    assertNotNull(props.getProperty("java.vm.specification.vendor"));
    assertNotNull(props.getProperty("java.vm.specification.name"));
    assertNotNull(props.getProperty("java.vm.version"));
    assertNotNull(props.getProperty("java.vm.vendor"));
    assertNotNull(props.getProperty("java.vm.name"));
    assertNotNull(props.getProperty("java.specification.version"));
    assertNotNull(props.getProperty("java.specification.vendor"));
    assertNotNull(props.getProperty("java.specification.name"));
    assertNotNull(props.getProperty("java.class.version"));
    assertNotNull(props.getProperty("java.class.path"));
    assertNotNull(props.getProperty("java.library.path"));
    assertNotNull(props.getProperty("java.io.tmpdir"));
    assertNull(props.getProperty("java.compiler"));
    assertNotNull(props.getProperty("java.ext.dirs"));
    assertNotNull(props.getProperty("os.name"));
    assertNotNull(props.getProperty("os.arch"));
    assertNotNull(props.getProperty("file.separator"));
    assertNotNull(props.getProperty("path.separator"));
    assertNotNull(props.getProperty("line.separator"));
    assertNotNull(props.getProperty("user.name"));
    assertNotNull(props.getProperty("user.home"));
    assertNotNull(props.getProperty("user.dir"));
  }

  public static void testGetProperty() {
    assertEquals("testValue", System.getProperty("DOES_NOT_EXIST_TEST", "testValue"));
  }

  public static void testGetSecurityManager() {
  }

  public static void testIdentityHashCode() {
    assertEquals(0, System.identityHashCode(null));
  }

  public static void testInheritedChannel() {
    try {
      if (System.inheritedChannel() != null) {
        assertTrue(Channel.class.isInstance(System.inheritedChannel().getClass()));
      }
    } catch (IOException e) {
      fail("testInheritedChannel failed: " + e.getMessage());
    }
  }

  public static void testLoad() {
    assertThrows(new Block() {
      @Override public void run() {
        System.load(null);
      }
    }, NullPointerException.class);
  }

  public static void testLoadLibrary() {
    assertThrows(new Block() {
      @Override public void run() {
        System.loadLibrary(null);
      }
    }, NullPointerException.class);
  }

  public static void testMapLibraryName() {
    assertThrows(new Block() {
      @Override public void run() {
        System.mapLibraryName(null);
      }
    }, NullPointerException.class);
  }

  public static void testNanoTime() {
    assertTrue((System.nanoTime() - System.nanoTime()) <= 0);
  }

  public static void testRunFinalization() {
  }

  public static void testSetErr() {
    PrintStream originalErr = System.err;
    try {
      PrintStream newErr = new PrintStream(new ByteArrayOutputStream());
      System.setErr(newErr);
      assertEquals(newErr, System.err);
    } finally {
      System.setErr(originalErr);
    }
  }

  public static void testSetIn() {
    InputStream originalIn = System.in;
    try {
      InputStream newIn = new ByteArrayInputStream(new byte[0]);
      System.setIn(newIn);
      assertEquals(newIn, System.in);
    } finally {
      System.setIn(originalIn);
    }
  }

  public static void testSetOut() {
    PrintStream originalOut = System.out;
    try {
      PrintStream newOut = new PrintStream(new ByteArrayOutputStream());
      System.setOut(newOut);
      assertEquals(newOut, System.out);
    } finally {
      System.setOut(originalOut);
    }
  }

  public static void testSetProperties() {
    Properties originalProperties = System.getProperties();

    try {
      // FIXME: FAILS
      // System.setProperties(null);
      // assertTrue(System.getProperties().isEmpty());
      Properties newProperties = new Properties();
      newProperties.setProperty("key", "value");
      System.setProperties(newProperties);
      assertEquals("value", System.getProperty("key"));
      assertEquals(1, System.getProperties().size());
    } finally {
      System.setProperties(originalProperties);
    }
  }

  public static void testSetSecurityManager() {
  }

  public static void main(String[] args) {
    testArraycopy();
    testClearProperty();
    testConsole();
    testCurrentTimeMillis();
    testExit();
    testGc();
    testGetProperties();
    testGetProperty();
    testGetSecurityManager();
    testGetenv();
    testIdentityHashCode();
    testInheritedChannel();
    testLoad();
    testLoadLibrary();
    testMapLibraryName();
    testNanoTime();
    testRunFinalization();
    testSetErr();
    testSetIn();
    testSetOut();
    testSetProperties();
    testSetSecurityManager();
  }
}
