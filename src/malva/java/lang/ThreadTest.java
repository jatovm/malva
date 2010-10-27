package malva.java.lang;

import malva.TestCase;

public class ThreadTest extends TestCase {

  public static void testConstruction() {
    assertTrue(new Thread().getName().startsWith("Thread-"));
    assertTrue(new Thread("test").getName().startsWith("test"));
    ThreadGroup threadGroup = new ThreadGroup("testThreadGroup");
    assertEquals(threadGroup, new Thread(threadGroup, "test").getThreadGroup());
    assertNotNull(new Thread((ThreadGroup)null, "test").getThreadGroup());
  }

  public static void testActiveCount() {
    assertTrue(Thread.activeCount() >= 1);
  }

  public static void testCheckAccess() {
  }

  public static void testClone() {
  }

  public static void testCurrentThread() {
    assertNotNull(Thread.currentThread());
  }

  public static void testDumpStack() {
  }

  public static void testEnumerate() {
    Thread[] threads = new Thread[Thread.activeCount()];
    assertEquals(Thread.activeCount(), Thread.enumerate(threads));
  }

  public static void testGetAllStackTraces() {
    assertTrue(Thread.getAllStackTraces().size() >= 1);
  }

  public static void testGetContectClassLoader() {
    assertNotNull(Thread.currentThread().getContextClassLoader());
  }

  public static void testGetDefaultUncaughtExceptionHandler() {
  }

  public static void testGetId() {
    assertTrue(Thread.currentThread().getId() > 0);
  }

  public static void testGetName() {
    assertNotNull(Thread.currentThread().getName());
  }

  public static void testGetPriority() {
    assertNotNull(Thread.currentThread().getPriority());
  }

  public static void testGetStackTrace() {
    assertTrue(Thread.currentThread().getStackTrace().length > 0);
    assertEquals("java.lang.Thread.getStackTrace", Thread.currentThread().getStackTrace()[0].toString().substring(0, 30));
  }

  public static void testGetState() {
    assertNotNull(Thread.currentThread().getState());
  }

  public static void testGetThreadGroup() {
    assertNotNull(Thread.currentThread().getThreadGroup());
  }

  public static void testGetUncaughtExceptionHandler() {
    assertNotNull(Thread.currentThread().getUncaughtExceptionHandler());
    assertEquals(Thread.currentThread().getThreadGroup(), Thread.currentThread().getUncaughtExceptionHandler());
  }

  public static void testHoldsLock() {
    assertFalse(Thread.holdsLock(new Object()));
    assertThrows(new Block(){
      @Override public void run() {
        Thread.holdsLock(null);
      }
    }, NullPointerException.class);
  }

  public static void testInterrupt() {
  }

  public static void testInterrupted() {
    assertFalse(Thread.interrupted());
    Thread.currentThread().interrupt();
    assertTrue(Thread.interrupted());
    assertFalse(Thread.interrupted());
  }

  public static void testIsAlive() {
    assertTrue(Thread.currentThread().isAlive());
  }

  public static void testIsDaemon() {
    assertFalse(Thread.currentThread().isDaemon());

    Thread thread = new Thread();
    thread.setDaemon(true);
    thread.start();
    assertTrue(thread.isDaemon());
  }

  public static void testIsInterrupted() {
    assertFalse(Thread.currentThread().isInterrupted());
    Thread.currentThread().interrupt();
    assertTrue(Thread.currentThread().isInterrupted());
    assertTrue(Thread.currentThread().isInterrupted());
  }

  public static void testJoin() {
  }

  public static void testRun() {
    final StringBuffer sb = new StringBuffer("false");
    final Runnable runnable = new Runnable() {
      public void run() {
        sb.replace(0, sb.length(), "true");
      }
    };

    Thread thread = new Thread(runnable);
    assertEquals("false", sb.toString());
    thread.start();
    try {
      thread.join();
      assertEquals("true", sb.toString());
    } catch (InterruptedException e) {
    }
  }

  public static void testSetContextClassloader() {
  }

  public static void testSetDaemon() {
    final java.util.concurrent.Semaphore semaphore = new java.util.concurrent.Semaphore(1, true);
    final Runnable runnable = new Runnable() {
      public void run() {
        try {
          semaphore.acquire();
        } catch(InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    };

    final Thread thread = new Thread(runnable);

    try {
      thread.setDaemon(true);
      semaphore.acquire();
      thread.start();

      assertThrows(new Block() {
        @Override public void run() {
          thread.setDaemon(false);
        }
      },IllegalThreadStateException.class);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    finally {
      semaphore.release();
    }
  }

  public static void testSetDefaultUncaughtExceptionHandler() {
    final java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);

    final Runnable runnable = new Runnable() {
      public void run() {
        throw new RuntimeException("testSetDefaultUncaughtExceptionHandler test handler");
      }
    };

    Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
      public void uncaughtException(Thread t, Throwable e) {
        latch.countDown();
      }
    };

    final Thread thread = new Thread(runnable);
    Thread.UncaughtExceptionHandler originalHandler = Thread.getDefaultUncaughtExceptionHandler();

    try {
      Thread.setDefaultUncaughtExceptionHandler(handler);
      thread.start();
      latch.await(100, java.util.concurrent.TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      fail("Apparently test thread never completes its work");
      throw new RuntimeException(e);
    } finally {
      Thread.setDefaultUncaughtExceptionHandler(originalHandler);
    }
  }

  public static void testSetName() {
    String originalName = Thread.currentThread().getName();
    try {
      Thread.currentThread().setName("testName");
      assertEquals("testName", Thread.currentThread().getName());
    } finally {
      Thread.currentThread().setName(originalName);
    }
  }

  public static void testSetPriority() {
    int originalPriority = Thread.currentThread().getPriority();
    try {
      if (originalPriority + 1 <= Thread.MAX_PRIORITY) {
        Thread.currentThread().setPriority(originalPriority + 1);
        assertEquals(originalPriority + 1, Thread.currentThread().getPriority());
      }

      assertThrows(new Block() {
        @Override public void run() {
          Thread.currentThread().setPriority(Thread.MAX_PRIORITY + 1);
        }
      },IllegalArgumentException.class);

      assertThrows(new Block() {
        @Override public void run() {
          Thread.currentThread().setPriority(Thread.MIN_PRIORITY - 1);
        }
      },IllegalArgumentException.class);

    } finally {
      Thread.currentThread().setPriority(originalPriority);
    }
  }

  public static void testSetUncaughtExceptionHandler() {
    final java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);

    final Runnable runnable = new Runnable() {
      public void run() {
        throw new RuntimeException("testSetUncaughtExceptionHandler test handler");
      }
    };

    Thread.UncaughtExceptionHandler handler = new Thread.UncaughtExceptionHandler() {
      public void uncaughtException(Thread t, Throwable e) {
        latch.countDown();
      }
    };

    final Thread thread = new Thread(runnable);

    try {
      thread.setUncaughtExceptionHandler(handler);
      thread.start();
      latch.await(100, java.util.concurrent.TimeUnit.MILLISECONDS);
    } catch (InterruptedException e) {
      fail("Apparently test thread never completes its work");
      throw new RuntimeException(e);
    }
  }

  public static void testSleep() {
  }

  public static void testStart() {
    assertThrows(new Block() {
        @Override public void run() {
          Thread thread = new Thread();
          thread.start();
          thread.start();
        }
      },IllegalThreadStateException.class);
  }

  public static void testToString() {
    assertNotNull(Thread.currentThread().toString());
    assertFalse("".equals(Thread.currentThread().toString()));
  }

  public static void testYield() {
  }

  public static void main(String[] args) {
     testConstruction();
     testActiveCount();
     testCheckAccess();
     testClone();
     testCurrentThread();
     testDumpStack();
     testEnumerate();
     testGetAllStackTraces();
     testGetContectClassLoader();
     testGetDefaultUncaughtExceptionHandler();
     testGetId();
     testGetName();
     testGetPriority();
     testGetStackTrace();
     testGetState();
     testGetThreadGroup();
     testGetUncaughtExceptionHandler();
     testHoldsLock();
     testInterrupt();
     testInterrupted();
     testIsAlive();
     testIsDaemon();
     testIsInterrupted();
     testJoin();
     testRun();
     testSetContextClassloader();
//   FIXME
//   testSetDaemon();
//   testSetDefaultUncaughtExceptionHandler();
     testSetName();
     testSetPriority();
//   testSetUncaughtExceptionHandler();
     testSleep();
     testStart();
     testToString();
     testYield();
  }
}
