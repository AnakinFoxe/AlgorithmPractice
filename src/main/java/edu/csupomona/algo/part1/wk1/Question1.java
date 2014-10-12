package edu.csupomona.algo.part1.wk1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This file contains all of the 100,000 integers between 1 and
 * 100,000 (inclusive) in some order, with no integer repeated.
 *
 * Your task is to compute the number of inversions in the file given,
 * where the ith row of the file indicates the ith entry of an array.
 * Because of the large size of this array, you should implement the
 * fast divide-and-conquer algorithm covered in the video lectures.
 *
 * Created by Xing HU on 10/11/14.
 */
public class Question1 {

    private CountInversions ci;

    public Question1() {
        ci = new CountInversions();
    }

    /**
     * Using CountInversions class
     * @throws IOException
     */
    public void run() throws IOException {
        FileReader fr = new FileReader("src/main/resources/part1/wk1/IntegerArray.txt");
        try (BufferedReader br = new BufferedReader(fr)) {
            String line;
            List<Integer> list = new ArrayList<>();
            while ((line = br.readLine()) != null)
                list.add(Integer.valueOf(line));

            ci.count(list);
            System.out.println(ci.getInvCount());
        }
    }

    public static void main(String[] args) throws IOException {
        Question1 q1 = new Question1();
        q1.run();
    }
}
