package org.ea.day2;

import org.ea.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Day2b {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 2, false);

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
        int len = number.length();
        int middle = number.length() / 2;
        outer:
        for (int check = 1; check < middle + 1; check++) {
            if (len % check == 0) {
                String first = number.substring(0, check);
                for (int j = 1; j < len / check; j++) {
                    if (!number.substring(check * j, check * (j + 1)).equals(first)) {
                        continue outer;
                    }
                }
                return true;
            }
        }
        return false;
    }
}