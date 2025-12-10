package org.ea.day8;

public class JunkBox {
    private final int x;
    private final int y;
    private final int z;
    private int circuit = -1;

    public JunkBox(String s) {
        String[] arr = s.split(",");
        this.x = Integer.parseInt(arr[0]);
        this.y = Integer.parseInt(arr[1]);
        this.z = Integer.parseInt(arr[2]);
    }

    public int getCircuit() {
        return circuit;
    }

    public void setCircuit(int circuit) {
        this.circuit = circuit;
    }

    public double distance(JunkBox jb) {
        double distx = Math.pow(jb.x - this.x, 2);
        double disty = Math.pow(jb.y - this.y, 2);
        double distz = Math.pow(jb.z - this.z, 2);
        return Math.sqrt(distx + disty + distz);
    }

    public int getX() {
        return x;
    }
}
