package org.ea.day2;

import org.ea.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Day2a {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(true, 2, false);

        String[] ranges = lines.get(0).split(",");
        BigInteger bi = BigInteger.ZERO;
        for (String s : ranges) {
            String[] val = s.split("-");
            long first = Long.parseLong(val[0]);
            long second = Long.parseLong(val[1]);

            for (long i = first; i < second + 1; i++) {
                if (invalidNumber(i)) {
                    bi = bi.add(BigInteger.valueOf(i));
                }
            }
        }

        System.out.println(bi);
    }

    private static boolean invalidNumber(long i) {
        String number = String.valueOf(i);
        int idx = number.length() / 2;
        if (number.substring(0, idx).equals(number.substring(idx))) {
            return true;
        }
        return false;
    }
}