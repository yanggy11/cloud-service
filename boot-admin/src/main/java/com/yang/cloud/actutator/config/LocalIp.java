package com.yang.cloud.actutator.config;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author derrick.yang
 * @Date 11/19/18 9:44 AM
 */
public class LocalIp {
    public static InetAddress getIpAddress() throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface current = interfaces.nextElement();
            if (!current.isUp() || current.isLoopback() || current.isVirtual())
                continue;
            Enumeration<InetAddress> addresses = current.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress addr = addresses.nextElement();
                if (addr.isLoopbackAddress())
                    continue;
                if (addr.isSiteLocalAddress()) {//去掉还回和虚拟地址
                    return addr;
                }
            }
        }

        throw new SocketException("Can't get our ip address, interfaces are: " + interfaces);
    }

    public static void main(String[] args) {
        String str = "11111111111\n" +
                "\n" +
                "1111\n" +
                "\n" +
                "\n" +
                "111";

        String[] contents = str.split("\n");

        System.out.println(contents);
    }
}
