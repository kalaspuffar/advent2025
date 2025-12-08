package org.ea.day5;

public class FreshRange {
    private long start;
    private long end;
    private final int id;
    private static int idCount = 0;

    public FreshRange(String range) {
        String[] arr = range.split("-");
        this.start = Long.parseLong(arr[0]);
        this.end = Long.parseLong(arr[1]);
        this.id = idCount++;
    }

    public boolean inRange(String sval) {
        long val = Long.parseLong(sval);
        return inRange(val);
    }

    public boolean inRange(long val) {
        if (val > end) return false;
        if (val < start) return false;
        return true;
    }

    public boolean overlap(FreshRange testRange) {
        if (testRange.id == this.id) return false;
        if (inRange(testRange.start) || inRange(testRange.end)) {
            if (testRange.start < start) {
                this.start = testRange.start;
            }
            if (testRange.end > end) {
                this.end = testRange.end;
            }
            return true;
        }
        return false;
    }

    public long getSize() {
        return end - start + 1;
    }
}
