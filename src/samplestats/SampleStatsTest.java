package samplestats;

import java.util.Arrays;

public class SampleStatsTest {
    public static void main(String[] args) {
        String fileName = "data/10m.txt";
        SampleStats stats = new SampleStats(fileName);

        System.out.println(stats.findMaxValue());

        System.out.println(stats.findMinValue());

        System.out.println(stats.findMedian());

        System.out.println(stats.findAverageArithmeticValue());

        System.out.println(Arrays.toString(stats.findBiggestAscendingSequence()));

        System.out.println(Arrays.toString(stats.findBiggestDescendingSequence()));

    }
}