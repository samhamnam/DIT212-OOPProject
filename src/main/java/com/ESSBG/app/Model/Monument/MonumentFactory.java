package com.ESSBG.app.Model.Monument;

import com.ESSBG.app.Model.Monument.Monuments.*;
import com.ESSBG.app.Model.Player.Player;

import java.util.*;

public class MonumentFactory {
    private List<Monument> monuments = new ArrayList<>();

    private MonumentFactory() {
        initMonumentList();
        shuffle(monuments);
    }


    /**
     * Adds a letter representing each possible monument to tmpList if tmpList is empty
     */

    private void initMonumentList() {
        monuments.add(new Alexandria());
        monuments.add(new Babylon());
        monuments.add(new Rhodos());
        monuments.add(new Olympia());
        monuments.add(new Halikarnassos());
        monuments.add(new Gizah());
        monuments.add(new Ephesos());


    }

    /**
     * Shuffles a list using Fisher yates method
     *
     * @param list
     * @param <T>
     */
    private <T> void shuffle(List<T> list) {
        Random random = new Random();
        int size = list.size();

        for (int i = size - 1; i > 0; i--) {

            int j = random.nextInt(i + 1);

            T tmp1 = list.get(i);
            T tmp2 = list.get(j);
            list.set(i, tmp2);
            list.set(j, tmp1);
        }
    }


    public static List<Monument> getMonuments() {
        MonumentFactory m = new MonumentFactory();
        return m.monuments;
    }


}
