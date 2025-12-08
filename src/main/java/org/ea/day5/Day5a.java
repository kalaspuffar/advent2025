package org.ea.day5;

import org.ea.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5a {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 5, false);

        List<FreshRange> ranges = new ArrayList<>();

        int fresh = 0;
        outer:
        for (String line : lines) {
            if (line.isBlank()) continue;
            if (line.contains("-")) {
                ranges.add(new FreshRange(line));
            } else {
                for (FreshRange fr : ranges) {
                    if (fr.inRange(line)) {
                        fresh++;
                        continue outer;
                    }
                }
            }
        }

        System.out.println(fresh);
    }
}