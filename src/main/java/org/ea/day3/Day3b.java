package org.ea.day3;

import org.ea.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3b {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 3, false);

        BigInteger sum = BigInteger.ZERO;
        for (String line : lines) {
            int[] numberList = new int[line.length()];
            String[] numbers = line.split("");
            int i = 0;
            for (String s : numbers) {
                numberList[i] = Integer.parseInt(s);
                i++;
            }

            int idx = 0;
            String number = "";
            for (int numbersLeft = 11; numbersLeft > -1; numbersLeft--) {
                List<Integer> res = findLargest(numberList, numbersLeft, idx);
                idx = res.get(0);
                number += "" + res.get(1);
            }
            sum = sum.add(new BigInteger(number));
        }
        System.out.println(sum);

        // 3121910778619
    }

    private static List<Integer> findLargest(int[] numberList, int numbersLeft, int idx) {
        int newIdx = 0;
        int largest = 0;
        for (int i = idx; i < numberList.length - numbersLeft; i++) {
            if (numberList[i] > largest) {
                largest = numberList[i];
                newIdx = i + 1;
            }
        }
        return Arrays.asList(newIdx, largest);
    }
}