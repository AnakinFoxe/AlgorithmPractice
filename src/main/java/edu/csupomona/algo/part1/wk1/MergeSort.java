package edu.csupomona.algo.part1.wk1;

import edu.csupomona.algo.common.ListHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Merge Sort
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * Created by Xing HU on 10/8/14.
 */
public class MergeSort {
    private static int count;

    public MergeSort() {
    }

    /**
     * Merge two list into one sorted list
     * @param left                  Left half sorted list
     * @param right                 Right half sorted list
     * @return                      Complete sorted list
     */
    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> sorted = new ArrayList<>();

        int leftIdx = 0;
        int rightIdx = 0;
        for (int idx = 0; idx < left.size() + right.size(); ++idx) {
            // the only tricky part of Merge Sort is this if condition
            if ((rightIdx >= right.size())
                    || (leftIdx < left.size()) && (left.get(leftIdx) < right.get(rightIdx))) {
                sorted.add(left.get(leftIdx));
                ++leftIdx;
            } else {
                sorted.add(right.get(rightIdx));
                ++rightIdx;
            }

            ++count;
        }

        return sorted;
    }

    /**
     * TopDown Merge Sort
     * @param list                  Input list (will not be destroyed)
     * @return                      Sorted list
     */
    public List<Integer> sort(List<Integer> list) {
        int len = list.size();
        if (len < 2)
            return list;

        List<Integer> left = sort(list.subList(0, len/2));
        List<Integer> right = sort(list.subList(len/2, len));

        return merge(left, right);
    }

    public static void main(String[] args) {
        ListHelper lh = new ListHelper();
        List<Integer> list = lh.genNaive(1000);

        MergeSort ms = new MergeSort();

        count = 0;
        List<Integer> sorted = ms.sort(list);
        lh.checkNaive(sorted);
        System.out.println("Looped " + count + " times");

    }
}
