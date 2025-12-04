package org.ea.day4;

import org.ea.Util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Day4a {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 4, false);

        int height = lines.size();
        int width = lines.get(0).length();

        boolean[] map = new boolean[height * width];
        int i = 0;
        for (String line : lines) {
            for (String s : line.split("")) {
                map[i] = s.equals("@");
                i++;
            }
        }

        boolean[] movableMap = new boolean[height * width];

        long sum = 0;
        boolean moved = true;
        while (moved) {
            Arrays.fill(movableMap, false);
            int count = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (movable(map, x, y, width, height)) {
                        movableMap[width * y + x] = true;
                        count++;
                    }
                }
            }
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (movableMap[width * y + x]) {
                        map[width * y + x] = false;
                    }
                }
            }
            moved = count > 0;
            sum += count;
        }
        System.out.println(sum);
    }

    private static boolean movable(boolean[] map, int x, int y, int width, int height) {
        if (!map[y * width + x]) return false;
        int count = 0;
        if (x < width - 1 && map[y * width + x + 1]) {
            count++;
        }
        if (x > 0 && map[y * width + x - 1]) {
            count++;
        }
        if (x < width - 1 && y < height - 1 && map[(y + 1) * width + x + 1]) {
            count++;
        }
        if (x > 0 && y < height - 1 && map[(y + 1) * width + x - 1]) {
            count++;
        }
        if (x < width - 1 && y > 0 && map[(y - 1) * width + x + 1]) {
            count++;
        }
        if (x > 0 && y > 0 && map[(y - 1) * width + x - 1]) {
            count++;
        }
        if (y < height - 1 && map[(y + 1) * width + x]) {
            count++;
        }
        if (y > 0 && map[(y - 1) * width + x]) {
            count++;
        }
        return count < 4;
    }
}