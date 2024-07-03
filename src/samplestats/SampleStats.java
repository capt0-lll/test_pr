package samplestats;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class SampleStats {

    private final ArrayList<Integer> numbers = new ArrayList<>();

    public SampleStats(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int findMaxValue(){
        int max = numbers.getFirst();
        for (Integer number : numbers) {
            if (max < number) {
                max = number;
            }
        }
        return max;
    }

    public int findMinValue(){
        int min = numbers.getFirst();
        for (int i = 0; i < numbers.size(); i++) {
            if (min > numbers.get(i)) {
                min = numbers.get(i);
            }
        }
        return min;
    }

    public double findAverageArithmeticValue(){
        double sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }
        sum = sum / numbers.size();
        return sum;
    }

    public int findMedian(){
        ArrayList<Integer> sortedNumbers = new ArrayList<>(numbers);
        int median;
        sortedNumbers.sort(Integer::compareTo);
        if(numbers.size() % 2 == 0){
            median = (sortedNumbers.get(sortedNumbers.size()/2) +  sortedNumbers.get(sortedNumbers.size()/2 + 1)) / 2;
        } else {
            median = sortedNumbers.get(sortedNumbers.size()/2);
        }
        return median;
    }

    // OPTIONAL
    public int[] findBiggestAscendingSequence(){
        int [] biggestSequence = new int[0];
        for (int i = 1; i < numbers.size(); i++) {
            int sequenceStart = i;
            int sequenceLength = 0;
            while (numbers.get(i) > numbers.get(i - 1) ) {
                sequenceLength++;
                if(i + 1 < numbers.size())i++;
                else break;
            }
            if(biggestSequence.length < sequenceLength) {
                biggestSequence = new int[sequenceLength + 1];
                for (int j = sequenceStart; j < i + 1; j++) {
                    biggestSequence[j - sequenceStart] = numbers.get(j - 1);
                }
            }
        }
        return biggestSequence;
    }

    public int[] findBiggestDescendingSequence(){
        int [] biggestSequence = new int[0];
        for (int i = 1; i < numbers.size(); i++) {
            int sequenceStart = i;
            int sequenceLength = 0;
            while (numbers.get(i) < numbers.get(i - 1) ) {
                sequenceLength++;
                if(i + 1 < numbers.size())i++;
                else break;
            }
            if(biggestSequence.length < sequenceLength) {
                biggestSequence = new int[sequenceLength + 1];
                for (int j = sequenceStart; j < i + 1; j++) {
                    biggestSequence[j - sequenceStart] = numbers.get(j - 1);
                }
            }
        }
        return biggestSequence;
    }

}
