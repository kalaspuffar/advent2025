package org.ea.day6;

import org.ea.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day6b {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 6, false);

        Map<Integer, List<String>> mathMap = new HashMap();

        for (String line : lines) {
            if (line.isBlank()) continue;

            String[] arr = line.split("");
            for (int it = 0; it < arr.length; it++) {
                if (!mathMap.containsKey(it)) {
                    mathMap.put(it, new ArrayList<>());
                }
                mathMap.get(it).add(arr[it]);
            }
        }

        BigInteger intSum = BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;
        boolean multiplication = false;
        for (List<String> ent : mathMap.values()) {

            if (ent.get(ent.size() - 1).equals("+")) {
                multiplication = false;
                intSum = BigInteger.ZERO;
            } else if (ent.get(ent.size() - 1).equals("*")) {
                multiplication = true;
                intSum = BigInteger.ZERO;
            }

            String strVal = "";
            for (int i = 0; i < ent.size() - 1; i++) {
                strVal += ent.get(i);
            }
            if (strVal.isBlank()) {
                sum = sum.add(intSum);
                continue;
            }

            BigInteger val = new BigInteger(strVal.trim());
            if (multiplication) {
                if (intSum.equals(BigInteger.ZERO)) {
                    intSum = val;
                } else {
                    intSum = intSum.multiply(val);
                }
            } else {
                intSum = intSum.add(val);
            }
        }

        System.out.println(sum);
    }
}

//3263435
//3263827
//3262769
