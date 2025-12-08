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

public class Day6a {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 6, false);

        Map<Integer, List<String>> mathMap = new HashMap();

        Pattern numberPattern = Pattern.compile("\\d+");
        Pattern signPattern = Pattern.compile("[*+]");

        for (String line : lines) {
            if (line.isBlank()) continue;

            Matcher m = null;
            if (line.contains("*")) {
                m = signPattern.matcher(line);
            } else {
                m = numberPattern.matcher(line);
            }
            int it = 0;
            while (m.find()) {
                if (!mathMap.containsKey(it)) {
                    mathMap.put(it, new ArrayList<>());
                }
                mathMap.get(it).add(m.group(0));
                it++;
            }
        }

        BigInteger sum = BigInteger.ZERO;
        for (List<String> ent : mathMap.values()) {
            BigInteger val = new BigInteger(ent.get(0));
            for (int i = 1; i < ent.size() - 1; i++) {
                if (ent.get(ent.size() - 1).equals("+")) {
                    val = val.add(new BigInteger(ent.get(i)));
                } else if (ent.get(ent.size() - 1).equals("*")) {
                    val = val.multiply(new BigInteger(ent.get(i)));
                }
            }

            sum = sum.add(val);
        }

        System.out.println(sum);
    }
}

//
