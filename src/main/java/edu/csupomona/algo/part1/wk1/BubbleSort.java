package edu.csupomona.algo.part1.wk1;

import edu.csupomona.algo.common.ListHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Bubble Sort
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * Created by Xing HU on 10/8/14.
 */
public class BubbleSort {

    private final ListHelper LH_;

    public BubbleSort() {
        LH_ = new ListHelper();
    }

    /**
     * The most naive Bubble Sort
     * @param list          Input list
     */
    public void sort1(List<Integer> list) {
        if (list.size() < 2)
            return;

        int count = 0;
        // double for-loop and both are related with variable "end"
        // O(n^2)
        int end = list.size();
        boolean swapped;
        do {
            swapped = false;
            for (int idx = 0; idx < end - 1; ++idx) {
                int left = list.get(idx);
                int right = list.get(idx + 1);
                if (left > right) {
                    list.set(idx + 1, left);
                    list.set(idx, right);

                    swapped = true;
                }

                ++count;    // loop time
            }
        } while (swapped);

        LH_.checkNaive(list);
        System.out.println("Looped " + count + " times");
    }

    /**
     *  Optimized by early cutting
     * @param list              Input list
     */
    public void sort2(List<Integer> list) {
        if (list.size() < 2)
            return;

        int count = 0;
        for (int end = list.size(); end > 0; --end) {
            boolean swapped = false;
            for (int idx = 0; idx < end - 1; ++idx) {
                int left = list.get(idx);
                int right = list.get(idx + 1);
                if (left > right) {
                    list.set(idx + 1, left);
                    list.set(idx, right);

                    swapped = true;
                }

                ++count;    // loop time
            }

            if (!swapped)
                break;
        }

        LH_.checkNaive(list);
        System.out.println("Looped " + count + " times");
    }

    /**
     * Slightly more optimized by ignoring already sorted part
     * @param list              Input list
     */
    public void sort3(List<Integer> list) {
        if (list.size() < 2)
            return;

        int count = 0;
        int end = list.size();
        while (end > 0) {
            boolean swapped = false;
            int lastSwap = 0;
            for (int idx = 0; idx < end - 1; ++idx) {
                int left = list.get(idx);
                int right = list.get(idx + 1);
                if (left > right) {
                    list.set(idx + 1, left);
                    list.set(idx, right);

                    swapped = true;
                    lastSwap = idx + 1;
                }

                ++count;    // loop time
            }
            end = lastSwap;

            if (!swapped)
                break;
        }

        LH_.checkNaive(list);
        System.out.println("Looped " + count + " times");
    }


    public static void main(String[] args) {
        ListHelper lh = new ListHelper();
        BubbleSort bs = new BubbleSort();

        List<Integer> list = lh.genNaive(1000);

        bs.sort1(new ArrayList<>(list));
        bs.sort2(new ArrayList<>(list));
        bs.sort3(new ArrayList<>(list));
    }
}
