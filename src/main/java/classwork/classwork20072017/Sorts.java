package classwork.classwork20072017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Class implements two sort algorithms: insertion sort, quicksort with Hoare partitioning
 * <p>
 * <p> Class implements methods to form lists with integer variables and sorting methods
 */
public class Sorts {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(25);
        setNumberList(integerList);
        quickSort(integerList);
        System.out.println(integerList);
        List<Integer> randomList = new ArrayList<>(100);
        setRandomNumberList(randomList);
        insertionSort(randomList);
        System.out.println(randomList);
    }

    /**
     * Fill input list with numbers which user input in console
     *
     * @param integerList input list which will be filled with 25 Integer variables from console
     */
    private static void setNumberList(List<Integer> integerList) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = 25;
            while (n > 0) {
                System.out.println("Please enter a number");
                String inputString = reader.readLine();
                if (inputString.matches("[-]?\\d+")) {
                    integerList.add(Integer.parseInt(inputString));
                    --n;
                }
            }
        } catch (IOException e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    /**
     * Fill input list with random numbers
     *
     * @param integerList input list which will be filled with 100 random Integer variables [0, 1000)
     */
    private static void setRandomNumberList(List<Integer> integerList) {
        for (int i = 0; i < 100; ++i) {
            integerList.add(Math.random() < 0.5 ? (int) (Math.random() * 1000) : -(int) (Math.random() * 1000));
        }
    }

    /**
     * Sort input list with insertion sort algorithm
     *
     * @param integerList input list which will be sorted
     */
    static void insertionSort(List<Integer> integerList) {
        for (int i = 1, n = integerList.size(); i < n; ++i) {
            int key = integerList.get(i);
            int j = i;
            while (j > 0 && integerList.get(j - 1) > key) {
                integerList.set(j, integerList.get(j - 1));
                --j;
            }
            integerList.set(j, key);
        }
    }

    /**
     * Sort input list with quicksort algorithm with Hoare partitioning
     *
     * @param integerList input list which will be sorted
     */
    static void quickSort(List<Integer> integerList) {
        quickSort(integerList, 0, integerList.size() - 1);
    }

    /**
     * Sort input list with quicksort algorithm with Hoare partitioning
     * <p>
     * <p> 1. Determine pivot index in list
     * <p> if low index < high index:
     * <p> 2. Recursively call of this method for left part of list (from low Index to pivot index inclusive)
     * <p> 3. Recursively call of this method for right part of list
     * (from next index after pivot index to high index inclusive)
     *
     * @param integerList input list which will be sorted
     * @param lowIndex    first index which represent start index in part of the list which will be sorted
     * @param highIndex   last index which represent end index in part of the list which will be sorted
     */
    private static void quickSort(List<Integer> integerList, int lowIndex, int highIndex) {
        if (highIndex > lowIndex) {
            int pivotIndex = partition(integerList, lowIndex, highIndex);
            quickSort(integerList, lowIndex, pivotIndex);
            quickSort(integerList, pivotIndex + 1, highIndex);
        }
    }

    /**
     * Sort elements and find index of pivot element (implementation of Hoare partition scheme)
     *
     * @param integerList input list in which will be found index of pivot
     * @param lowIndex    first index which represents start index in part
     *                    of the list in which will be found  index of pivot element
     * @param highIndex   last index which represents end index in part
     *                    of the list in which will be found index of pivot element
     * @return index of pivot element
     */
    private static int partition(List<Integer> integerList, int lowIndex, int highIndex) {
        int pivot = integerList.get((highIndex + lowIndex) >>> 1);
        while (true) {
            while (integerList.get(lowIndex) < pivot) {
                ++lowIndex;
            }
            while (integerList.get(highIndex) > pivot) {
                --highIndex;
            }
            if (highIndex <= lowIndex) {
                return highIndex;
            }
            int tempInteger = integerList.get(lowIndex);
            integerList.set(lowIndex, integerList.get(highIndex));
            integerList.set(highIndex, tempInteger);
            ++lowIndex;
            --highIndex;
        }
    }
}
