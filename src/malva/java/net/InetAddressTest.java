package malva.java.net;

import java.net.InetAddress;
import malva.TestCase;

public class InetAddressTest extends TestCase {

  public static void testEquals() throws Exception {
    assertTrue(InetAddress.getLocalHost().equals(InetAddress.getLocalHost()));
    assertFalse(InetAddress.getLocalHost().equals(null));
  }

  public static void testGetAddress() throws Exception {
    assertNotNull(InetAddress.getLocalHost().getAddress());
  }

  public static void testGetAllByName() throws Exception {
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        InetAddress.getAllByName("non_existent");
      }
    }, java.net.UnknownHostException.class);

    assertTrue(InetAddress.getAllByName(null)[0].isLoopbackAddress());
  }

  public static void testGetByAddress() throws Exception {
    assertTrue(InetAddress.getByAddress(InetAddress.getLocalHost().getAddress()).equals(InetAddress.getLocalHost()));
    InetAddress.getByAddress("anyhost", new byte[] {0, 0, 0, 0});

    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        InetAddress.getByAddress(new byte[] {0, 0, 0});
      }
    }, java.net.UnknownHostException.class);
  }

  public static void testGetByName() throws Exception {
    assertThrows(new Block() {
      @Override public void run() throws Throwable {
        InetAddress.getByName("unknown");
      }
    }, java.net.UnknownHostException.class);

    assertTrue(InetAddress.getByName(null).isLoopbackAddress());
  }

  public static void testGetCanonicalHostName() throws Exception {
    // Just check that call does not fail
    InetAddress.getLocalHost().getCanonicalHostName();
  }

  public static void testGetHostAddress() throws Exception {
    assertEquals("0.0.0.0", InetAddress.getByAddress(new byte[]{0, 0, 0, 0}).getHostAddress());
  }

  public static void testGetHostName() throws Exception {
    assertEquals("testhost", InetAddress.getByAddress("testhost", new byte[] {0, 0, 0, 0}).getHostName());
  }

  public static void testGetLocalHost() throws Exception {
    // Just test that the call does not fail
    InetAddress.getLocalHost();
  }

  public static void testHashCode() {
  }

  public static void testIsAnyLocalAddress() throws Exception {
    assertFalse(InetAddress.getLocalHost().isAnyLocalAddress());
  }

  public static void testIsLinkLocalAddress() throws Exception {
    assertFalse(InetAddress.getLocalHost().isLinkLocalAddress());
  }

  public static void testIsLoopback() throws Exception {
    assertTrue (InetAddress.getByName("127.0.0.1").isLoopbackAddress());
    assertFalse(InetAddress.getByName("192.168.0.1").isLoopbackAddress());
  }

  public static void testIsLoopbackAddress() throws Exception {
    assertFalse(InetAddress.getLocalHost().isLoopbackAddress());
  }

  public static void testIsMCGlobal() throws Exception {
    assertFalse(InetAddress.getLocalHost().isMCGlobal());
  }

  public static void testIsMCLinkLocal() throws Exception {
    assertFalse(InetAddress.getLocalHost().isMCLinkLocal());
  }

  public static void testIsMCNodeLocal() throws Exception {
    assertFalse(InetAddress.getLocalHost().isMCNodeLocal());
  }


  public static void testIsMCOrgLocal() throws Exception {
    assertFalse(InetAddress.getLocalHost().isMCOrgLocal());
  }

  public static void testIsMCSiteLocal() throws Exception {
    assertFalse(InetAddress.getLocalHost().isMCSiteLocal());
  }

  public static void testIsMulticastAddress() throws Exception {
    assertFalse(InetAddress.getLocalHost().isMulticastAddress());
  }

  public static void testIsReachable() throws Exception {
    assertTrue(InetAddress.getLocalHost().isReachable(100));
  }

  public static void testIsSiteLocalAddress() throws Exception {
    assertTrue(InetAddress.getLocalHost().isSiteLocalAddress());
  }

  public void testToString() {
  }

  public static void main(String[] args) throws Exception {
    testEquals();
    testGetAddress();
    testGetAllByName();
    testGetByAddress();
    testGetByName();
    testGetCanonicalHostName();
    testGetHostAddress();
    testGetHostName();
    testGetLocalHost();
    //testHashCode();
    testIsAnyLocalAddress();
    testIsLinkLocalAddress();
    testIsLoopback();
    testIsLoopbackAddress();
    testIsMCGlobal();
    testIsMCLinkLocal();
    testIsMCNodeLocal();
    testIsMCOrgLocal();
    testIsMCSiteLocal();
    testIsMulticastAddress();
    testIsReachable();
    testIsSiteLocalAddress();
    //testToString();
  }
}
