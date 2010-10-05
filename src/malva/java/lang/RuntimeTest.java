package malva.java.lang;

import java.io.IOException;
import malva.TestCase;

public class RuntimeTest extends TestCase {
  public static void testAddShutdownHook() {
    final Runtime rt = Runtime.getRuntime();
    assertThrows(new Block() {
      @Override public void run() {
        Thread shutdownHook = new Thread();
        rt.addShutdownHook(shutdownHook);
        rt.addShutdownHook(shutdownHook);
      }
    }, IllegalArgumentException.class);

    assertThrows(new Block() {
      @Override public void run() {
        Thread shutdownHook = new Thread();
        shutdownHook.start();
        rt.addShutdownHook(shutdownHook);
      }
    }, IllegalArgumentException.class);
  }

  public static void testAvailableProcessors() {
    assertTrue(Runtime.getRuntime().availableProcessors() > 0);
  }

  public static void testExec() throws IOException {
    assertTrue(Process.class.isAssignableFrom(Runtime.getRuntime().exec("java").getClass()));

    assertThrows(new Block() {
      @Override public void run() throws IOException {
        Runtime.getRuntime().exec((String) null);
      }
    }, NullPointerException.class);

    assertThrows(new Block() {
      @Override public void run() throws IOException {
        Runtime.getRuntime().exec("cd", new String[] {"", null});
      }
    }, NullPointerException.class);

    assertThrows(new Block() {
      @Override public void run() throws IOException {
        Runtime.getRuntime().exec(new String[] {"cd", null, ""});
      }
    }, NullPointerException.class);
  }

  public static void testExit() {
  }

  public static void testFreeMemory() {
    assertTrue(Runtime.getRuntime().freeMemory() > 0);
  }

  public static void testGc() {
    long originalMemory = Runtime.getRuntime().freeMemory();
    Runtime.getRuntime().gc();
    assertTrue(Runtime.getRuntime().freeMemory() >= originalMemory);
  }

  public static void testLoad() {
    assertThrows(new Block() {
      @Override public void run() {
        Runtime.getRuntime().load(null);
      }
    }, NullPointerException.class);
  }

  public static void testLoadLibrary() {
    assertThrows(new Block() {
      @Override public void run() {
        Runtime.getRuntime().loadLibrary(null);
      }
    }, NullPointerException.class);
  }

  public static void testMaxMemory() {
    assertTrue(Runtime.getRuntime().maxMemory() >= Runtime.getRuntime().freeMemory());
  }

  public static void testRemoveShutdownHook() {
    final Runtime rt = Runtime.getRuntime();
    Thread shutdownHook = new Thread();
    rt.addShutdownHook(shutdownHook);
    assertTrue(rt.removeShutdownHook(shutdownHook));
    assertFalse(rt.removeShutdownHook(shutdownHook));
  }

  public static void testRunFinalization() {
  }

  public static void testTotalMemory() {
    assertTrue(Runtime.getRuntime().totalMemory() >= Runtime.getRuntime().freeMemory());
  }

  public static void testTraceInstructions() {
    Runtime.getRuntime().traceInstructions(false);
  }

  public static void testTraceMethodCalls() {
    Runtime.getRuntime().traceMethodCalls(false);
  }

  public static void main(String[] args) throws IOException {
    testAddShutdownHook();
    testAvailableProcessors();
    testExec();
    testExit();
    testFreeMemory();
    testGc();
    testLoad();
    testLoadLibrary();
    testMaxMemory();
    testRemoveShutdownHook();
    testRunFinalization();
    testTotalMemory();
    testTraceInstructions();
    testTraceMethodCalls();
  }
}
