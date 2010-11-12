package malva.java.lang;

import java.io.IOException;

import malva.TestCase;

public class ProcessTest extends TestCase {

  public static void testDestroy() {
    ProcessBuilder processBuilder = new ProcessBuilder("echo", "test");
    try {
      Process process = processBuilder.start();
      process.destroy();
    } catch (IOException e) {
      fail("Test failed: " + e.getMessage());
      throw new RuntimeException(e);
    }
  }

  public static void testExitValue() {

    try {
      ProcessBuilder processBuilder = new ProcessBuilder("env");
      Process process = processBuilder.start();
      // Read all output after which the process will complete
      while (process.getInputStream().read() != -1);
      process.waitFor();
      assertEquals(0, process.exitValue());
    } catch (Exception e) {
      fail("Test failed: " + e.getMessage());
      throw new RuntimeException(e);
    }

    try {
      ProcessBuilder processBuilder = new ProcessBuilder("sleep", "10");
      final Process process = processBuilder.start();

      assertThrows(new Block() {
        @Override public void run() {
          process.exitValue();
        }
      }, IllegalThreadStateException.class);

      process.destroy();
      process.waitFor();
    } catch (Exception e) {
      fail("Test failed: " + e.getMessage());
      throw new RuntimeException(e);
    }
  }

  public static void testGetErrorStream() {
    ProcessBuilder processBuilder = new ProcessBuilder("echo", "test");
    try {
      Process process = processBuilder.start();
      assertNotNull(process.getErrorStream());
      process.destroy();
    } catch (IOException e) {
      fail("Test failed: "  + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void testGetInputStream() {
    ProcessBuilder processBuilder = new ProcessBuilder("echo", "test");
    try {
      Process process = processBuilder.start();
      assertNotNull(process.getInputStream());
      process.destroy();
    } catch (IOException e) {
      fail("Test failed: "  + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void testGetOutputStream(){
    ProcessBuilder processBuilder = new ProcessBuilder("echo", "test");
    try {
      Process process = processBuilder.start();
      assertNotNull(process.getOutputStream());
      process.destroy();
    } catch (IOException e) {
      fail("Test failed: "  + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void testWaitFor() {
    Thread testerThread = new Thread(new Runnable() {
      @Override public void run() {
        ProcessBuilder processBuilder = new ProcessBuilder("env");
        try {
          final Process process = processBuilder.start();
          // Read all output after which the process will complete
          while (process.getInputStream().read() != -1);
          process.waitFor();
        } catch (Exception e) {
          fail("Test failed: "  + e.getMessage());
          throw new RuntimeException(e);
        }
      }
    });

    testerThread.start();

    try {
      testerThread.join(100);
    } catch (InterruptedException e) {
      fail("Test failed as test did not complete in time: " + e.getMessage());
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    testDestroy();
    testExitValue();
    testGetErrorStream();
    testGetInputStream();
    testGetOutputStream();
    testWaitFor();
  }
}
