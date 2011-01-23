package malva.java.io;

import malva.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class PrintStreamTest extends TestCase {
  public static void testConstructor() throws UnsupportedEncodingException {
   final OutputStream out = new ByteArrayOutputStream();
    assertThrows(new Block() {
      @Override public void run() throws FileNotFoundException {
        new PrintStream((File) null);
      }
    }, NullPointerException.class);
    assertThrows(new Block() {
      @Override public void run() throws FileNotFoundException, UnsupportedEncodingException {
        new PrintStream((File) null, "utf-8");
      }
    }, NullPointerException.class);
    assertThrows(new Block() {
      @Override public void run() {
        new PrintStream((OutputStream) null);
      }
    }, NullPointerException.class);
    assertNotNull(new PrintStream(out));
    assertThrows(new Block() {
      @Override public void run() {
        new PrintStream((OutputStream) null, true);
      }
    }, NullPointerException.class);
    assertThrows(new Block() {
      @Override public void run() {
        new PrintStream((OutputStream) null, false);
      }
    }, NullPointerException.class);
    assertNotNull(new PrintStream(out, true));
    assertThrows(new Block() {
      @Override public void run() throws UnsupportedEncodingException {
        new PrintStream((OutputStream) null, true, "utf-8");
      }
    }, NullPointerException.class);
    assertThrows(new Block() {
      @Override public void run() throws UnsupportedEncodingException {
        new PrintStream(out, true, null);
      }
    }, NullPointerException.class);
    assertThrows(new Block() {
      @Override public void run() throws UnsupportedEncodingException {
        new PrintStream(out, true, "unknown");
      }
    }, UnsupportedEncodingException.class);
    assertNotNull(new PrintStream(out, true, "utf-8"));
    assertThrows(new Block() {
      @Override public void run() throws FileNotFoundException {
        new PrintStream((String) null);
      }
    }, NullPointerException.class);
    assertThrows(new Block() {
      @Override public void run() throws FileNotFoundException, UnsupportedEncodingException {
        new PrintStream((String) null, (String) "utf-8");
      }
    }, NullPointerException.class);
  }

  public static void main(String[] args) throws Exception {
    testConstructor();
  }
}
