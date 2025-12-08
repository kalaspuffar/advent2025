package org.ea.day7;

import java.math.BigInteger;
import java.util.Objects;

public class Tachyon {
    private final int x;
    private final int y;
    private BigInteger res;

    public Tachyon(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public BigInteger getRes() {
        return res;
    }

    public void setRes(BigInteger res) {
        this.res = res;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tachyon tachyon = (Tachyon) o;
        return x == tachyon.x && y == tachyon.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
