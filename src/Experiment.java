// Experiment.java

import java.util.Arrays;

public class Experiment {

    private Sorter sorter;
    private Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public long measureSortTime(int[] arr, String type) {

        int[] copy = Arrays.copyOf(arr, arr.length);

        long startTime = System.nanoTime();

        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(copy);
        } else if (type.equalsIgnoreCase("advanced")) {
            sorter.advancedSort(copy);
        }

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public long measureSearchTime(int[] arr, int target) {

        long startTime = System.nanoTime();

        searcher.search(arr, target);

        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public void runAllExperiments() {

        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {

            System.out.println("\n==================================");
            System.out.println("Array Size: " + size);
            System.out.println("==================================");

            int[] randomArray = sorter.generateRandomArray(size);
            int[] sortedArray = sorter.generateSortedArray(size);

            // BASIC SORT
            long basicRandomTime =
                    measureSortTime(randomArray, "basic");

            long basicSortedTime =
                    measureSortTime(sortedArray, "basic");

            // ADVANCED SORT
            long advancedRandomTime =
                    measureSortTime(randomArray, "advanced");

            long advancedSortedTime =
                    measureSortTime(sortedArray, "advanced");

            // SEARCH
            int target = sortedArray[size / 2];

            long searchTime =
                    measureSearchTime(sortedArray, target);

            System.out.println("Bubble Sort (Random Array): "
                    + basicRandomTime + " ns");

            System.out.println("Bubble Sort (Sorted Array): "
                    + basicSortedTime + " ns");

            System.out.println("Merge Sort (Random Array): "
                    + advancedRandomTime + " ns");

            System.out.println("Merge Sort (Sorted Array): "
                    + advancedSortedTime + " ns");

            System.out.println("Binary Search Time: "
                    + searchTime + " ns");
        }
    }
}