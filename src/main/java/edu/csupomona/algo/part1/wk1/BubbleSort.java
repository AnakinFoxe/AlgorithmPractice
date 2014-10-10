package edu.csupomona.algo.part1.wk1;

import edu.csupomona.algo.common.ListHelper;

import java.util.List;

/**
 * Bubble Sort
 * Created by Xing HU on 10/8/14.
 */
public class BubbleSort {

    /**
     * Sort the input list using Bubble Sort
     * @param list          Input list
     */
    public void sort(List<Integer> list) {
        // double for-loop and both are related with variable "end"
        // O(n^2)
        for (int end = list.size(); end > 0; --end) {
            for (int idx = 0; idx < end - 1; ++idx) {
                int left = list.get(idx);
                int right = list.get(idx + 1);
                if (left > right) {
                    list.set(idx + 1, left);
                    list.set(idx, right);
                }
            }
        }
    }


    public static void main(String[] args) {
        ListHelper lh = new ListHelper();
        BubbleSort bs = new BubbleSort();

        List<Integer> list = lh.genNaive(100);

        bs.sort(list);
        lh.checkNaive(list);
    }
}
