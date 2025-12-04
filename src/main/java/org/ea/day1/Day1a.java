package org.ea.day1;

import org.ea.Util;

import java.io.IOException;
import java.util.List;

public class Day1a {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 1, false);
        int dial = 50;
        int counter = 0;
        for (String s : lines) {
            if (s.isBlank()) continue;
            String direction = s.substring(0, 1);
            int number = Integer.parseInt(s.substring(1));

            switch (direction) {
                case "L":
                    dial -= number;
                    break;
                case "R":
                    dial += number;
                    break;
            }

            if (dial < 0) {
                dial += 1000000;
            }
            dial = dial % 100;

            if (dial == 0) {
                counter++;
            }
        }

        System.out.println(counter);
    }
}