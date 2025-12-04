package org.ea.day1;

import org.ea.Util;

import java.io.IOException;
import java.util.List;

public class Day1b {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 1, false);
        int dial = 50;
        int counter = 0;
        for (String s : lines) {
            if (s.isBlank()) continue;
            String direction = s.substring(0, 1);
            int number = Integer.parseInt(s.substring(1));

            boolean left = direction.equals("L") ? true : false;

            while (number > 0) {
                if (left) {
                    dial--;
                } else {
                    dial++;
                }

                if (Math.abs(dial) == 100) {
                    dial = 0;
                }
                if (dial == 0) {
                    counter++;
                }
                number--;
            }
        }

        System.out.println(counter);
    }
}