package edu.csupomona.algo.part1.wk1;

import edu.csupomona.algo.common.ListHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Count inversions in a list
 * Implemented based on Merge Sort
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * Created by Xing HU on 10/8/14.
 */
public class CountInversions {
    private static int count = 0;
    private long invCount = 0;

    public CountInversions() {
        invCount = 0;
    }

    public long getInvCount() {
        return invCount;
    }

    public void setInvCount(long invCount) {
        this.invCount = invCount;
    }

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

                // once an element was added from the right list
                // it indicates inversion happens
                invCount += left.size() - leftIdx;
            }

            ++count;
        }

        return sorted;
    }

    /**
     * Count inversions based on TopDown merge sort
     * @param list                  Input list
     * @return                      Sorted list
     */
    public List<Integer> count(List<Integer> list) {
        int len = list.size();
        if (len < 2)
            return list;

        List<Integer> left = count(list.subList(0, len / 2));
        List<Integer> right = count(list.subList(len / 2, len));

        return merge(left, right);
    }

    public static void main(String[] args) {
        ListHelper lh = new ListHelper();
        List<Integer> list = lh.genNaive(500);

        CountInversions ci = new CountInversions();

        count = 0;
        lh.printList(list);
        List<Integer> sorted = ci.count(list);
        lh.checkNaive(sorted);
        System.out.println("Looped " + count + " times");

        System.out.println("Inversions: " + ci.getInvCount());

    }
}
