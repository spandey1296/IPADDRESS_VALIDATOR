package com.company;

import java.util.Arrays;

// Program to validate IPv4 address in Java 8 and above
public class ValidateIPAddress3 {

    public static boolean isValidInet4Address(String ip)
    {
        String[] groups = ip.split("\\.");

        if (groups.length != 4)
            return false;

        try {
            return Arrays.stream(groups)
                    .filter(s -> s.length() > 1 && s.startsWith("0"))
                    .map(Integer::parseInt)
                    .filter(i -> (i >= 0 && i <= 255))
                    .count() == 4;

        } catch(NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args)
    {
        // an IPv4 address
        final String INET4ADDRESS = "172.8.7.28";

        // Validate an IPv4 address
        if (isValidInet4Address(INET4ADDRESS)) {
            System.out.print("The IP address " + INET4ADDRESS + " is valid");
        }
        else {
            System.out.print("The IP address " + INET4ADDRESS + " isn't valid");
        }
    }
}


