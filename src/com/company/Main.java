package com.company;
import java.util.regex.Pattern;
public class Main {

    private static Main IpAddressValidation;

    public static void main(String[] args) {
        System.out.println(IpAddressValidation.isValidIpManually("1.0.0.1"));
    }

    public static boolean isValidIp (String ipAddress) {

        if (ipAddress == null || ipAddress.isEmpty()) {
            return false;
        }

        // 0 to 255
        String digitRegEx = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";

        String ipRegEx = digitRegEx + "\\." +
                digitRegEx + "\\." +
                digitRegEx + "\\." +
                digitRegEx;

        Pattern pattern = Pattern.compile(ipRegEx);

        return pattern.matcher(ipAddress).matches();
    }

    public static boolean isValidIpManually (String ipAddress) {

        if (ipAddress == null || ipAddress.isEmpty()) {
            return false;
        }

        String[] strArray = ipAddress.split("\\.");

        if (strArray.length != 4) {
            return false;
        }

        for (String str : strArray) {
            try {
                int num = Integer.parseInt(str);

                if (num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    public static void setIpAddressValidation(Main ipAddressValidation) {
        IpAddressValidation = ipAddressValidation;
    }
}

