package com.yanggy.cloud.kothlin.utils;

import java.net.InetAddress
import java.net.NetworkInterface
import java.net.SocketException
import java.util.*

/**
 *@author derrick.yang
 *@Date 11/16/18 6:01 PM
 */
class LocalIp {
    companion object {
        fun getHostAdress(): InetAddress {
            var networkInterfaces: Enumeration<NetworkInterface> = NetworkInterface.getNetworkInterfaces()

            while (networkInterfaces.hasMoreElements()) {
                var current: NetworkInterface = networkInterfaces.nextElement()

                if (!current.isUp() || current.isLoopback() || current.isVirtual())
                    continue;
                var addresses: Enumeration<InetAddress> = current.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    var addr: InetAddress = addresses.nextElement();
                    if (addr.isLoopbackAddress())
                        continue
                    if (addr.isSiteLocalAddress()) {//去掉还回和虚拟地址
                        return addr
                    }
                }
            }

            throw  SocketException("Can't get our ip address, interfaces are: " + networkInterfaces);
        }
    }
}