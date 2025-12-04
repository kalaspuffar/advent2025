package org.ea.day3;

import org.ea.Util;

import java.io.IOException;
import java.util.List;

public class Day3a {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 3, false);

        long sum = 0;
        for (String line : lines) {
            int[] numberList = new int[line.length()];
            String[] numbers = line.split("");
            int i = 0;
            int largest = 0;
            int idx = 0;
            int secondLargest = 0;
            int secondIdx = 0;
            for (String s : numbers) {
                numberList[i] = Integer.parseInt(s);
                if (numberList[i] > largest) {
                    secondLargest = largest;
                    secondIdx = idx;
                    largest = numberList[i];
                    idx = i;
                }
                i++;
            }

            if (idx == numberList.length - 1) {
                idx = secondIdx;
                largest = secondLargest;
            }

            int secondDigit = 0;
            for (int j = idx + 1; j < numberList.length; j++) {
                if (numberList[j] > secondDigit) {
                    secondDigit = numberList[j];
                }
            }

            sum += largest * 10 + secondDigit;
        }
        System.out.println(sum);
    }
}