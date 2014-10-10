package edu.csupomona.algo.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Xing HU on 10/9/14.
 */
public class ListGenerator {

    private final Random RAND_;

    public ListGenerator() {
        RAND_ = new Random();
    }

    public List<Integer> genNormal(int len, int range) {
        List<Integer> list = new ArrayList<>();

        for (int idx = 0; idx < len; ++idx)
            list.add(RAND_.nextInt(range));

        return list;
    }
}
