package org.ea.day5;

import org.ea.Util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Day5b {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 5, false);

        List<FreshRange> ranges = new ArrayList<>();

        for (String line : lines) {
            if (line.isBlank()) break;
            if (line.contains("-")) {
                ranges.add(new FreshRange(line));
            }
        }

        boolean change = true;
        while (change) {
            change = false;
            Iterator<FreshRange> it = ranges.iterator();
            while (it.hasNext()) {
                FreshRange testRange = it.next();
                boolean found = false;
                for (FreshRange fr : ranges) {
                    if (fr.overlap(testRange)) {
                        change = true;
                        found = true;
                    }
                }
                if (found) it.remove();
            }
        }

        BigInteger freshIds = BigInteger.ZERO;
        for (FreshRange fr : ranges) {
            freshIds = freshIds.add(BigInteger.valueOf(fr.getSize()));
        }

        System.out.println(freshIds);
    }
}
//358895407379846
//16074516590883
//352946349407338