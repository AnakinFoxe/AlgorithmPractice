package edu.csupomona.algo.part1.wk1;

import edu.csupomona.algo.common.ListHelper;

import java.util.List;

/**
 * Insertion Sort
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 * Created by Xing HU on 10/8/14.
 */
public class InsertionSort {

    private final ListHelper LH_;

    public InsertionSort() {
        LH_ = new ListHelper();
    }

    /**
     * Optimized Insertion Sort which won't traversal all the sorted elements
     * @param list                  Input list
     */
    public void sort(List<Integer> list) {
        int count = 0;
        for (int idx = 1; idx < list.size(); ++idx) {
            int current = list.get(idx);
            int expectedIdx = idx;

            // searching in the sorted part
            for (int sortedIdx = idx - 1; sortedIdx >= 0; --sortedIdx) {
                ++count;

                int search = list.get(sortedIdx);

                // encounters larger elements
                if (search > current )
                    expectedIdx = sortedIdx;

                // once encounters smaller element
                if (search < current)
                    // stop searching
                    break;
            }

            if (expectedIdx != idx) {
                // remove current element from its old idx
                list.remove(idx);

                // insert current element into expectedIdx
                list.add(expectedIdx, current);
            }
        }

        LH_.checkNaive(list);
        System.out.println("Looped " + count + " times");
    }

    public static void main(String[] args) {
        ListHelper lh = new ListHelper();
        List<Integer> list = lh.genNaive(1000);

        InsertionSort is = new InsertionSort();

        is.sort(list);
    }
}
