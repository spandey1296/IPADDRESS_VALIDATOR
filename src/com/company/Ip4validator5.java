package com.company;
import java.util.regex.Pattern;
public class Ip4validator5 {

    private static final String IPV4_REGEX =
            "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";

    private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);

    public static boolean isValidInet4Address(String ip) {

        if (ip == null) {
            return false;
        }

        if (!IPv4_PATTERN.matcher(ip).matches())
            return false;

        String[] parts = ip.split("\\.");

        // verify that each of the four subgroups of IPv4 address is legal
        try {
            for (String segment: parts) {
                // x.0.x.x is accepted but x.01.x.x is not
                if (Integer.parseInt(segment) > 255 ||
                        (segment.length() > 1 && segment.startsWith("0"))) {
                    return false;
                }
            }
        } catch(NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

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
