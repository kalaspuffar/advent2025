package org.ea.day7;

import org.ea.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day7a {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 7, false);
        int height = lines.size();
        int width = lines.get(0).length();
        int[] map = new int[width * height];

        Arrays.fill(map, 0);

        int idx = 0;
        for (String line : lines) {
            for (String s : line.split("")) {
                if (s.equals("S")) {
                    map[idx] = 1;
                }
                if (s.equals("^")) {
                    map[idx] = 2;
                }
                idx++;
            }
        }

        int split = 0;
        for (int y = 1; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (map[(y - 1) * width + x] == 1) {
                    if (map[y * width + x] == 2) {
                        split++;
                        if (map[y * width + x - 1] == 0) {
                            map[y * width + x - 1] = 1;
                        }
                        if (map[y * width + x + 1] == 0) {
                            map[y * width + x + 1] = 1;
                        }
                    } else {
                        map[y * width + x] = 1;
                    }
                }
            }
        }
        System.out.println(split);
    }
}

