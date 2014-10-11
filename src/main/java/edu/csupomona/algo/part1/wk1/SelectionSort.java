package edu.csupomona.algo.part1.wk1;

import edu.csupomona.algo.common.ListHelper;

import java.util.List;

/**
 * Selection Sort
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * Created by Xing HU on 10/8/14.
 */
public class SelectionSort {
    private final ListHelper LH_;

    public SelectionSort() {
        LH_ = new ListHelper();
    }

    /**
     * The most naive implementation of Selection Sort
     * @param list              Input list
     */
    public void sort(List<Integer> list) {
        if (list.size() < 2)
            return;

        int count = 0;

        for (int sorted = 0; sorted < list.size()-1; ++sorted) {
            int minIdx = sorted;
            for (int idx = sorted + 1; idx < list.size(); ++idx) {
                if (list.get(minIdx) > list.get(idx))
                    minIdx = idx;

                ++count;
            }

            int tmp = list.get(sorted);
            list.set(sorted, list.get(minIdx));
            list.set(minIdx, tmp);
        }

        LH_.checkNaive(list);
        System.out.println("Looped " + count + " times");
    }

    public static void main(String[] args) {
        ListHelper lh = new ListHelper();
        List<Integer> list = lh.genNaive(1000);

        SelectionSort ss = new SelectionSort();
        ss.sort(list);
    }
}
