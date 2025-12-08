package org.ea.day7;

import org.ea.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day7b {
    private static final Set<Tachyon> tachyonSet = new HashSet<>();

    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 7, false);
        int height = lines.size();
        int width = lines.get(0).length();
        int[] map = new int[width * height];

        Arrays.fill(map, 0);

        int idx = 0;
        int sx = 0;
        for (String line : lines) {
            for (String s : line.split("")) {
                if (s.equals("S")) {
                    map[idx] = 1;
                    sx = idx;
                }
                if (s.equals("^")) {
                    map[idx] = 2;
                }
                idx++;
            }
        }

        BigInteger permute = splitter(map, 0, sx, width, height);

        System.out.println(permute);
    }

    private static BigInteger splitter(int[] map, int y, int x, int width, int height) {
        Tachyon nt = new Tachyon(x, y);
        if (tachyonSet.contains(nt)) {
            for (Tachyon t : tachyonSet) {
                if (t.equals(nt)) {
                    return t.getRes();
                }
            }
        }

        BigInteger val = BigInteger.ZERO;
        if (y == height - 1) {
            return BigInteger.ONE;
        }
        if (map[(y + 1) * width + x] == 2) {
            val = val.add(splitter(map, y + 1, x - 1, width, height));
            val = val.add(splitter(map, y + 1, x + 1, width, height));
        } else if (map[(y + 1) * width + x] == 0) {
            val = val.add(splitter(map, y + 1, x, width, height));
        }
        nt.setRes(val);
        tachyonSet.add(nt);
        return val;
    }
}

