package malva.java.net;

import java.net.InetAddress;
import malva.TestCase;

public class InetAddressTest extends TestCase {
  public static void testIsLoopback() throws Exception {
    assertTrue (InetAddress.getByName("127.0.0.1").isLoopbackAddress());
    assertFalse(InetAddress.getByName("192.168.0.1").isLoopbackAddress());
  }

  public static void main(String[] args) throws Exception {
    testIsLoopback();
  }
}
