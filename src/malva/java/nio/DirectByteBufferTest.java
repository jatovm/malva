package malva.java.nio;

import java.nio.ByteBuffer;
import malva.TestCase;

public class DirectByteBufferTest extends TestCase {
  public static final int CAPACITY = 5;

  public static void testAllocateDirect() {
    assertNotNull(ByteBuffer.allocateDirect(0));
    assertNotNull(ByteBuffer.allocateDirect(1));
    assertThrows(new Block() {
      @Override public void run() {
        ByteBuffer.allocateDirect(-1);
      }
    }, IllegalArgumentException.class);
  }

  // array
  // arrayOffset
  // asCharBuffer
  // asDoubleBuffer
  // asFloatBuffer
  // asIntBuffer
  // asLongBuffer
  // asReadOnlyBuffer
  // asShortBuffer

  public static void testCapacity() {
    ByteBuffer bb = ByteBuffer.allocateDirect(CAPACITY);
    assertEquals(CAPACITY, bb.capacity());
  }

  // asRemaining
  // clear
  // compact
  // compareTo
  // duplicate
  // equals
  // flip
  // get
  // getChar
  // getDouble
  // getFloat
  // getInt
  // getLong
  // getShort
  // hasArray
  // hashCode

  public static void testIsDirect() {
    ByteBuffer bb = ByteBuffer.allocateDirect(CAPACITY);
    assertTrue(bb.isDirect());
  }

  // isReadOnly

  public static void testLimit() {
    final ByteBuffer bb = ByteBuffer.allocateDirect(CAPACITY);
    assertEquals(bb.capacity(), bb.limit());
    assertEquals(bb, bb.limit(1));
    assertEquals(1, bb.limit());
    assertThrows(new Block() {
      @Override public void run() {
        bb.limit(-1);
      }
    }, IllegalArgumentException.class);
    assertThrows(new Block() {
      @Override public void run() {
        bb.limit(bb.capacity() + 1);
      }
    }, IllegalArgumentException.class);
  }

  // mark
  // order

  public static void testPosition() {
    final ByteBuffer bb = ByteBuffer.allocateDirect(CAPACITY);
    assertEquals(0, bb.position());
    assertEquals(bb, bb.position(1));
    assertEquals(1, bb.position());
    assertThrows(new Block() {
      @Override public void run() {
        bb.position(-1);
      }
    }, IllegalArgumentException.class);
    assertThrows(new Block() {
      @Override public void run() {
        bb.limit(1);
        bb.position(bb.limit() + 1);
      }
    }, IllegalArgumentException.class);
  }

  // put
  // putChar
  // putDouble
  // putFloat
  // putInt
  // putLong
  // putShort

  public static void testRemaining() {
    final ByteBuffer bb = ByteBuffer.allocateDirect(CAPACITY);
    assertEquals(CAPACITY, bb.remaining());
    assertEquals(bb, bb.position(bb.limit()));
    assertEquals(0, bb.remaining());
  }

  // reset
  // rewind
  // slice
  // toString
  // wrap

  public static void main(String[] args) throws Exception {
    testAllocateDirect();
    testCapacity();
    testIsDirect();
    testLimit();
    testPosition();
    testRemaining();
  }
}
