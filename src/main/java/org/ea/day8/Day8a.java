package org.ea.day8;

import org.ea.Util;

import java.io.IOException;
import java.util.*;

public class Day8a {
    public static void main(String[] args) throws IOException  {
        List<String> lines = Util.readInput(false, 8, false);
        final int CONNECTIONS = 1000;

        List<JunkBox> boxes = new ArrayList<>();
        for (String l : lines) {
            if (l.isBlank()) continue;
            boxes.add(new JunkBox(l));
        }

        Map<Double, List<JunkBox[]>> lenMap = new HashMap<>();
        for (int i = 0; i < boxes.size(); i++) {
            for (int j = i + 1; j < boxes.size(); j++) {
                JunkBox jb1 = boxes.get(i);
                JunkBox jb2 = boxes.get(j);
                double distance = jb1.distance(jb2);
                if (!lenMap.containsKey(distance)) {
                    lenMap.put(distance, new ArrayList<>());
                }
                lenMap.get(distance).add(new JunkBox[] {jb1, jb2});
            }
        }

        List<Double> len = new ArrayList<>();
        len.addAll(lenMap.keySet());
        len.sort(Comparator.comparingDouble(a -> a));

        Map<Integer, List<JunkBox>> curcuits = new HashMap<>();
        int curcuitItr = 1;
        for (int i = 0; i < CONNECTIONS; i++) {
            List<JunkBox[]> boxesConnections = lenMap.get(len.get(i));
            for (JunkBox[] conn : boxesConnections) {
                if (conn[0].getCircuit() == -1 && conn[1].getCircuit() == -1) {
                    conn[0].setCircuit(curcuitItr);
                    conn[1].setCircuit(curcuitItr);
                    curcuits.put(curcuitItr, new ArrayList<>());
                    curcuits.get(curcuitItr).add(conn[0]);
                    curcuits.get(curcuitItr).add(conn[1]);
                    curcuitItr++;
                } else if (conn[0].getCircuit() != -1 && conn[1].getCircuit() == -1) {
                    conn[1].setCircuit(conn[0].getCircuit());
                    curcuits.get(conn[0].getCircuit()).add(conn[1]);
                } else if (conn[0].getCircuit() == -1 && conn[1].getCircuit() != -1) {
                    conn[0].setCircuit(conn[1].getCircuit());
                    curcuits.get(conn[1].getCircuit()).add(conn[0]);
                } else if (
                    conn[0].getCircuit() != -1 &&
                    conn[1].getCircuit() != -1 &&
                    conn[0].getCircuit() != conn[1].getCircuit()
                ) {
                    int oldCurcuit = conn[1].getCircuit();
                    for (JunkBox jb : curcuits.get(oldCurcuit)) {
                        jb.setCircuit(conn[0].getCircuit());
                        curcuits.get(conn[0].getCircuit()).add(jb);
                    }
                    curcuits.remove(oldCurcuit);
                }
            }
        }

        List<Integer> curcuitSizes = new ArrayList<>();
        for (List<JunkBox> curcuit : curcuits.values()) {
            curcuitSizes.add(curcuit.size());
        }
        curcuitSizes.sort((a,b) -> b - a);
        System.out.println(curcuitSizes.get(0) * curcuitSizes.get(1) * curcuitSizes.get(2));
    }

    // 59840 - high
}
