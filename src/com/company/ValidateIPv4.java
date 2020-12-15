package com.company;
import java.net.Inet4Address;
import java.net.UnknownHostException;

// Program to validate IPv4 address in Java
public class ValidateIPv4 {
    public static boolean isValidInet4Address(String ip)
    {
        try {
            return Inet4Address.getByName(ip)
                    .getHostAddress().equals(ip);
        }
        catch (UnknownHostException ex) {
            return false;
        }
    }

    public static void main(String[] args)
    {
        // an IPv4 address
        final String INET4ADDRESS = "99.2.36.5";

        // Validate an IPv4 address
        if (isValidInet4Address(INET4ADDRESS)) {
            System.out.print("The IP address " + INET4ADDRESS + " is valid");
        }
        else {
            System.out.print("The IP address " + INET4ADDRESS + " isn't valid");
        }
    }
}



