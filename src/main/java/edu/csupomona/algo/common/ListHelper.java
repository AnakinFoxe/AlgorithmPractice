package edu.csupomona.algo.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * Helper class for list manipulation
 * Created by Xing HU on 10/9/14.
 */
public class ListHelper {

    private final Random RAND_;

    public ListHelper() {
        RAND_ = new Random();
    }

    /**
     * Generate list full with random integer without any limitation
     * @param len                   Expected list length
     * @param range                 Value range for each element
     * @return                      Generated list
     */
    public List<Integer> genNormal(int len, int range) {
        List<Integer> list = new ArrayList<>();

        for (int idx = 0; idx < len; ++idx)
            list.add(RAND_.nextInt(range));

        return list;
    }

    /**
     * Generate list with random but distinct integers
     * @param len                   Expected list length
     * @param range                 Value range for each element
     * @return                      Generated list
     */
    public List<Integer> genDistinct(int len, int range) {
        if (range < len) {
            System.out.println("The range is too small to generate distinct list");
            return null;
        }

        List<Integer> list = new ArrayList<>();
        HashSet<Integer> tmp = new HashSet<>();

        int idx = 0;
        while (idx < len) {
            int value = RAND_.nextInt(range);
            if (tmp.contains(value))    // skip if exists
                continue;

            list.add(value);
            tmp.add(value);
            ++idx;
        }

        return list;
    }

    /**
     * Generate the most naive random list.
     * E.g. a length 10 list with distinct elements from 0 to 9
     * @param len                   Expected list length
     * @return                      The most naive random list
     */
    public List<Integer> genNaive(int len) {
        return genDistinct(len, len);
    }


    /**
     * Check whether sorted list match the most naive sorted list.
     * E.g. 0=>1=>2=>3=>....=>n
     * @param list                  Sorted list
     * @return                      true: match
     */
    public boolean checkNaive(List<Integer> list) {
        for (int idx = 0; idx < list.size(); ++idx)
            if (idx != list.get(idx)) {
                System.out.print("[FAILED] ");
                printList(list);
                return false;
            }

        System.out.print("[PASSED] ");
        printList(list);
        return true;
    }

    /**
     * Display the list in a format way.
     * @param list                  Input list
     */
    public void printList(List<Integer> list) {
        for (int elm : list)
            System.out.print(elm + "=>");
        System.out.println("EOL (length:" + list.size() + ")");
    }
}
