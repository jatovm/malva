package malva.java.net;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import malva.TestCase;

public class NetworkInterfaceTest extends TestCase {
  public static void testGetName() throws Exception {
    for (NetworkInterface iface : getNetworkInterfaces()) {
      assertNotNull(iface.getName());
    }
  }

  public static void testGetInetAddresses() throws Exception {
    for (NetworkInterface iface : getNetworkInterfaces()) {
      for (InetAddress addr : getInetAddresses(iface)) {
        assertNotNull(addr);
      }
    }
  }

  public static void testGetInterfaceAddresses() throws Exception {
    for (NetworkInterface iface : getNetworkInterfaces()) {
      for (InterfaceAddress addr : iface.getInterfaceAddresses()) {
        assertNotNull(addr);
      }
    }
  }

  public static void testGetSubInterfacesAndGetParent() throws Exception {
    for (NetworkInterface iface : getNetworkInterfaces()) {
      for (NetworkInterface subIface : Collections.list(iface.getSubInterfaces())) {
        assertNotNull(subIface);
        assertEquals(subIface.getParent(), iface);
      }
    }
  }

  public static void testGetByName() throws Exception {
    for (NetworkInterface iface : getNetworkInterfaces()) {
      assertEquals(iface, NetworkInterface.getByName(iface.getName()));
    }
  }

  public static void testGetByInetAddress() throws Exception {
    Map<InetAddress, Set<NetworkInterface>> map = mapInetAddressesToNetworkInterfaces(getNetworkInterfaces());

    // Multiple network interfaces can be bound to the same address. Which one in the set is returned by
    // getByInetAddress() is not defined.
    for (InetAddress addr : map.keySet()) {
      assertTrue(map.get(addr).contains(NetworkInterface.getByInetAddress(addr)));
    }
  }


  public static void testGetMTU() throws Exception {
    for (NetworkInterface iface : getNetworkInterfaces()) {
      assertTrue(iface.getMTU() > 0);
    }
  }

  public static void testIsLoopback() throws Exception {
    for (NetworkInterface iface : getNetworkInterfaces()) {
      if (iface.isLoopback()) {
        for (InetAddress addr : getInetAddresses(iface)) {
          assertTrue(addr.isLoopbackAddress());
        }
      }
    }
  }

  public static void testToString() throws Exception {
    for (NetworkInterface iface : getNetworkInterfaces()) {
      assertNotNull(iface.toString());
    }
  }

  private static List<NetworkInterface> getNetworkInterfaces() throws Exception {
    return Collections.list(NetworkInterface.getNetworkInterfaces());
  }

  private static List<InetAddress> getInetAddresses(NetworkInterface iface) {
    return Collections.list(iface.getInetAddresses());
  }

  private static Map<InetAddress, Set<NetworkInterface>> mapInetAddressesToNetworkInterfaces(List<NetworkInterface> ifaces) {
    Map<InetAddress, Set<NetworkInterface>> map = new HashMap<InetAddress, Set<NetworkInterface>>();

    for (NetworkInterface iface : ifaces) {
      for (InetAddress addr : getInetAddresses(iface)) {
        Set<NetworkInterface> set = map.get(addr);
        if (set == null) {
          set = new HashSet<NetworkInterface>();
          map.put(addr, set);
        }
        set.add(iface);
      }
    }

    return map;
  }

  public static void main(String[] args) throws Exception {
    testGetName();
    testGetInetAddresses();
    testGetInterfaceAddresses();
    testGetSubInterfacesAndGetParent();
    testGetByName();
    testGetByInetAddress();
    testGetMTU();
    // FIXME: BROKEN
    // testIsLoopback();
    testToString();
  }
}
