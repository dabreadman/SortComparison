import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

//-------------------------------------------------------------------------
/* Run Time for Each Algorithm with different Input
+----------------------+---------------------+----------------------+-----------------------+---------------------------------+-----------------------------+------------------------------------+------------------------------+------------------------+----------------------------------+-------------------------------+------------------------------+---------------------------------+-------------------------+
|                      | <<<numbers10.txt>>> | <<<numbers100.txt>>> | <<<numbers1000.txt>>> | <<<numbers1000Duplicates.txt>>> | <<<numbersSorted1000.txt>>> | <<<numbersNearlyOrdered1000.txt>>> | <<<numbersReverse1000.txt>>> | <<<numbers10000.txt>>> | <<<numbers10000Duplicates.txt>>> | <<<numbersReverse10000.txt>>> | <<<numbersSorted10000.txt>>> | <<<resNearlyOrdered10000.txt>>> | <<<numbers100000.txt>>> |
+----------------------+---------------------+----------------------+-----------------------+---------------------------------+-----------------------------+------------------------------------+------------------------------+------------------------+----------------------------------+-------------------------------+------------------------------+---------------------------------+-------------------------+
| Selection Sort       | >>0.6204ms          | >>0.1555ms           | >>14.1591ms           | >>0.5468ms                      | >>0.2667ms                  | >>0.3382ms                         | >>0.3406ms                   | >>55.8267ms            | >>27.4176ms                      | >>30.9415ms                   | >>22.4025ms                  | >>21.3955ms                     | >>2135.9383ms           |
| Insertion Sort       | >>0.0061ms          | >>0.3729ms           | >>7.7271ms            | >>11.262ms                      | >>0.0023ms                  | >>0.1114ms                         | >>0.9167ms                   | >>55.0594ms            | >>47.6732ms                      | >>91.7751ms                   | >>0.0062ms                   | >>5.9153ms                      | >>4347.7834ms           |
| Merge Sort Iterative | >>0.0114ms          | >>0.0791ms           | >>0.2746ms            | >>0.176ms                       | >>0.038ms                   | >>0.1392ms                         | >>0.0691ms                   | >>1.4686ms             | >>1.2649ms                       | >>0.2918ms                    | >>0.2766ms                   | >>0.333ms                       | >>12.4874ms             |
| Merge Sort Recursion | >>0.008ms           | >>0.0799ms           | >>0.3964ms            | >>0.1505ms                      | >>0.0752ms                  | >>0.0902ms                         | >>0.0362ms                   | >>1.5689ms             | >>0.9138ms                       | >>0.3726ms                    | >>0.377ms                    | >>0.5028ms                      | >>10.8303ms             |
| Quick Sort           | >>0.0086ms          | >>0.0584ms           | >>0.7383ms            | >>0.2391ms                      | >>0.3694ms                  | >>0.0828ms                         | >>0.3156ms                   | >>1.4565ms             | >>1.0828ms                       | >>27.2283ms                   | >>32.902ms                   | >>0.758ms                       | >>9.8463ms              |
+----------------------+---------------------+----------------------+-----------------------+---------------------------------+-----------------------------+------------------------------------+------------------------------+------------------------+----------------------------------+-------------------------------+------------------------------+---------------------------------+-------------------------+

a. Which of the sorting algorithms does the order of input have an impact on? Why?
- Quick Sort: If sorted, get to worst case because more comparisons and more recursions. 

b. Which algorithm has the biggest difference between the best and worst performance, based
on the type of input, for the input of size 1000? Why?
- Insertion Sort: Insertion Sort checks if the element is larger than the left, so for a best-case(sorted array), the comparisons happens quickly.

c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
based on the input size? Please consider only input files with random order for this answer.
- Insertion Sort: As mentioned above, Insertion Sort compare element with the left. For a normally randomised array, there will be a lot of compares and swaps. 

d. Did you observe any difference between iterative and recursive implementations of merge
sort?
Iterative version would sort faster for sorted array, whereas the recursive version would have an edge on reversed array.
Otherwise, the difference between the two was not that apparent.

e. Which algorithm is the fastest for each of the 7 input files?
numbers10.txt					
-Insertion Sort

numbers100.txt
-Quick Sort

numbers1000.txt
-Merge Sort Iterative

numbers1000Duplicates.txt
-Merge Sort Recursion

numbersNearlyOrdered1000.txt
-Quick Sort

numbersReverse1000.txt
-Merge Sort Recursion

numbersSorted1000.txt
-Insertion Sort
 */

/**
 * Test class for SortComparison.java
 *
 * @author Yi Xiang Tan aka dabreadman
 * @version HT 2019
 */
@RunWith(JUnit4.class)
public class SortComparisonTest {
    //~ Constructor ........................................................
    @Test
    public void testConstructor() {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    @Test
    public void selectionSortTest() {
        double[] a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63};
        double[]result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);

        Assert.assertArrayEquals("Selection Sort: 10", result, SortComparison.selectionSort(a), 0);

        a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63, 3669.57,
                4917.36, 9100.94, 2652.57, 8931.88, 2203.51, 6317.98, 5710.77, 3321.58, 1044.55, 5029.31, 5673.94,
                8541.65, 401.409, 1080.22, 6393.96, 131.11, 7201.84, 1018.14, 4829.45, 2543.55, 6766.97, 8967.82,
                7598.96, 7202.92, 9076.23, 9286.11, 3776.63, 8997.56, 7788.8, 3242.55, 1942.31, 9955.53, 1612.96,
                7080.34, 5015.19, 9363.01, 7163.23, 1051.9, 2092.05, 5593.97, 7054.32, 782.337, 5105.3, 1961.97,
                2742.11, 6386.02, 4482.08, 398.718, 4672.51, 777.565, 381.004, 1600.44, 3978.32, 6888.98, 5347.12,
                6869.2, 2724.57, 4659.33, 2765.55, 4500.86, 9350.69, 869.318, 4538.89, 9456.25, 8557.19, 1209.76,
                141.639, 2345.15, 8663.13, 4373.9, 7695.48, 8740.03, 3769.34, 9443.28, 7984.93, 8386.34, 9466.56,
                5860.52, 5991.63, 3193.47, 4211.62, 9041.07, 1584.62, 8351.59, 7319.42, 4918.37, 2121.29, 1197.52,
                483.631};
        result =  Arrays.copyOf(a,a.length);
        Arrays.sort(result);


        Assert.assertArrayEquals("Selection Sort: 100", result, SortComparison.selectionSort(a), 0);
        assertNull("Selection Sort: null", SortComparison.selectionSort(null));
    }

    @Test
    public void insertionSortTest() {
        double[] a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63};
        double[]result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);

        Assert.assertArrayEquals("Insertion Sort: 10", result, SortComparison.insertionSort(a), 0);

        a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63, 3669.57,
                4917.36, 9100.94, 2652.57, 8931.88, 2203.51, 6317.98, 5710.77, 3321.58, 1044.55, 5029.31, 5673.94,
                8541.65, 401.409, 1080.22, 6393.96, 131.11, 7201.84, 1018.14, 4829.45, 2543.55, 6766.97, 8967.82,
                7598.96, 7202.92, 9076.23, 9286.11, 3776.63, 8997.56, 7788.8, 3242.55, 1942.31, 9955.53, 1612.96,
                7080.34, 5015.19, 9363.01, 7163.23, 1051.9, 2092.05, 5593.97, 7054.32, 782.337, 5105.3, 1961.97,
                2742.11, 6386.02, 4482.08, 398.718, 4672.51, 777.565, 381.004, 1600.44, 3978.32, 6888.98, 5347.12,
                6869.2, 2724.57, 4659.33, 2765.55, 4500.86, 9350.69, 869.318, 4538.89, 9456.25, 8557.19, 1209.76,
                141.639, 2345.15, 8663.13, 4373.9, 7695.48, 8740.03, 3769.34, 9443.28, 7984.93, 8386.34, 9466.56,
                5860.52, 5991.63, 3193.47, 4211.62, 9041.07, 1584.62, 8351.59, 7319.42, 4918.37, 2121.29, 1197.52,
                483.631};
        result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);

        Assert.assertArrayEquals("Insertion Sort: 100", result, SortComparison.insertionSort(a), 0);

        assertNull("Insertion Sort: null", SortComparison.insertionSort(null));
    }

    @Test
    public void mergeSortIterativeTest() {
        double[] a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63};
        double[]result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);

        Assert.assertArrayEquals("Iterative Merge Sort: 10", result, SortComparison.mergeSortIterative(a), 0);

        a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63, 3669.57,
                4917.36, 9100.94, 2652.57, 8931.88, 2203.51, 6317.98, 5710.77, 3321.58, 1044.55, 5029.31, 5673.94,
                8541.65, 401.409, 1080.22, 6393.96, 131.11, 7201.84, 1018.14, 4829.45, 2543.55, 6766.97, 8967.82,
                7598.96, 7202.92, 9076.23, 9286.11, 3776.63, 8997.56, 7788.8, 3242.55, 1942.31, 9955.53, 1612.96,
                7080.34, 5015.19, 9363.01, 7163.23, 1051.9, 2092.05, 5593.97, 7054.32, 782.337, 5105.3, 1961.97,
                2742.11, 6386.02, 4482.08, 398.718, 4672.51, 777.565, 381.004, 1600.44, 3978.32, 6888.98, 5347.12,
                6869.2, 2724.57, 4659.33, 2765.55, 4500.86, 9350.69, 869.318, 4538.89, 9456.25, 8557.19, 1209.76,
                141.639, 2345.15, 8663.13, 4373.9, 7695.48, 8740.03, 3769.34, 9443.28, 7984.93, 8386.34, 9466.56,
                5860.52, 5991.63, 3193.47, 4211.62, 9041.07, 1584.62, 8351.59, 7319.42, 4918.37, 2121.29, 1197.52,
                483.631};
        result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);

        Assert.assertArrayEquals("Iterative Merge Sort: 100", result, SortComparison.mergeSortIterative(a), 0);

        assertNull("Iterative Merge Sort: null", SortComparison.mergeSortIterative(null));
    }

    @Test
    public void mergeSortRecursiveTest() {
        double[] a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63};
        double[]result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);

        Assert.assertArrayEquals("Recursive Merge Sort: 10", result, SortComparison.mergeSortRecursive(a), 0);

        a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63, 3669.57,
                4917.36, 9100.94, 2652.57, 8931.88, 2203.51, 6317.98, 5710.77, 3321.58, 1044.55, 5029.31, 5673.94,
                8541.65, 401.409, 1080.22, 6393.96, 131.11, 7201.84, 1018.14, 4829.45, 2543.55, 6766.97, 8967.82,
                7598.96, 7202.92, 9076.23, 9286.11, 3776.63, 8997.56, 7788.8, 3242.55, 1942.31, 9955.53, 1612.96,
                7080.34, 5015.19, 9363.01, 7163.23, 1051.9, 2092.05, 5593.97, 7054.32, 782.337, 5105.3, 1961.97,
                2742.11, 6386.02, 4482.08, 398.718, 4672.51, 777.565, 381.004, 1600.44, 3978.32, 6888.98, 5347.12,
                6869.2, 2724.57, 4659.33, 2765.55, 4500.86, 9350.69, 869.318, 4538.89, 9456.25, 8557.19, 1209.76,
                141.639, 2345.15, 8663.13, 4373.9, 7695.48, 8740.03, 3769.34, 9443.28, 7984.93, 8386.34, 9466.56,
                5860.52, 5991.63, 3193.47, 4211.62, 9041.07, 1584.62, 8351.59, 7319.42, 4918.37, 2121.29, 1197.52,
                483.631};
        result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);

        Assert.assertArrayEquals("Recursive Merge Sort: 100", result, SortComparison.mergeSortRecursive(a), 0);

        assertNull("Recursive Merge Sort: null", SortComparison.mergeSortRecursive(null));
    }

    @Test
    public void testQuickSort() {
        double[] a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63};
        double[]result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);

        Assert.assertArrayEquals("Quick Sort: 10", result, SortComparison.quickSort(a), 0);

        a = new double[]{2910.66, 8458.14, 1522.08, 5855.37, 1934.75, 8106.23, 1735.31, 4849.83, 1518.63, 3669.57,
                4917.36, 9100.94, 2652.57, 8931.88, 2203.51, 6317.98, 5710.77, 3321.58, 1044.55, 5029.31, 5673.94,
                8541.65, 401.409, 1080.22, 6393.96, 131.11, 7201.84, 1018.14, 4829.45, 2543.55, 6766.97, 8967.82,
                7598.96, 7202.92, 9076.23, 9286.11, 3776.63, 8997.56, 7788.8, 3242.55, 1942.31, 9955.53, 1612.96,
                7080.34, 5015.19, 9363.01, 7163.23, 1051.9, 2092.05, 5593.97, 7054.32, 782.337, 5105.3, 1961.97,
                2742.11, 6386.02, 4482.08, 398.718, 4672.51, 777.565, 381.004, 1600.44, 3978.32, 6888.98, 5347.12,
                6869.2, 2724.57, 4659.33, 2765.55, 4500.86, 9350.69, 869.318, 4538.89, 9456.25, 8557.19, 1209.76,
                141.639, 2345.15, 8663.13, 4373.9, 7695.48, 8740.03, 3769.34, 9443.28, 7984.93, 8386.34, 9466.56,
                5860.52, 5991.63, 3193.47, 4211.62, 9041.07, 1584.62, 8351.59, 7319.42, 4918.37, 2121.29, 1197.52,
                483.631};
        result = Arrays.copyOf(a, a.length);
        Arrays.sort(result);

        Assert.assertArrayEquals("Quick Sort: 100", result, SortComparison.quickSort(a), 0);

        assertNull("Quick Sort: null", SortComparison.quickSort(null));
    }

    // ----------------------------------------------------------

    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty() {
        double[] emptyArray = new double[0];
        assertEquals(emptyArray, SortComparison.selectionSort(emptyArray));
        assertEquals(emptyArray, SortComparison.insertionSort(emptyArray));
        assertEquals(emptyArray, SortComparison.mergeSortIterative(emptyArray));
        assertEquals(emptyArray, SortComparison.mergeSortRecursive(emptyArray));
        assertEquals(emptyArray, SortComparison.quickSort(emptyArray));
    }

    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.

    // ----------------------------------------------------------

    /**
     * Main Method.
     * Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     */
    public static void main(String[] args) {
        String[] files = new String[]{
        		"/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbers10.txt",
                "/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbers100.txt",
                "/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbers1000.txt",
                "/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbers1000Duplicates.txt",
                "/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbers10000.txt",
                "/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbers10000Duplicates.txt",
                "/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbers100000.txt",
                "/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbersNearlyOrdered1000.txt",
                "/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbersReverse1000.txt",
                "/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbersReverse10000.txt",
        		"/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbersSorted1000.txt",
          		"/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/numbersSorted10000.txt",
          		"/Docs/Study/Eclipse Workspace/Y2_Workspace/SortComparison/files/resNearlyOrdered10000.txt"
             };

        for (String file : files) {
        	
        	//store numbers for each files
            ArrayList<Double> number = new ArrayList<>();
            //read file(s)
            try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
                //read next line
            	String line = buffer.readLine();
                //read till finish
                while (line != null) {
                    line = buffer.readLine();
                    //parse number into array
                    if (line != null) 
                    	number.add(Double.parseDouble(line));
                }

                double[] numbers = new double[number.size()];
                for(int i=0; i<number.size();i++) {
                	numbers[i]=number.get(i);
                }
                
                System.out.println("<<<"+file.split("/")[file.split("/").length - 1]+">>>");
                //start to count time for each sorting algorithm
                double[]a = Arrays.copyOf(numbers,numbers.length);
                double startTime = System.nanoTime();
                SortComparison.selectionSort(a);
                double endTime = System.nanoTime();
                double duration = (endTime - startTime) / 1000000;
                System.out.println(" Selection Sort \n>>" + duration + "ms");

                a = Arrays.copyOf(numbers,numbers.length);
                startTime = System.nanoTime();
                SortComparison.insertionSort(a);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println(" Insertion Sort \n>>" + duration + "ms");

                a = Arrays.copyOf(numbers,numbers.length);
                startTime = System.nanoTime();
                SortComparison.mergeSortIterative(a);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println(" MergeSort Iterative \n>>" + duration + "ms");

                a = Arrays.copyOf(numbers,numbers.length);
                startTime = System.nanoTime();
                SortComparison.mergeSortRecursive(a);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println(" MergeSort Recursive \n>>" + duration + "ms");

                a = Arrays.copyOf(numbers,numbers.length);
                startTime = System.nanoTime();
                SortComparison.quickSort(a);
                endTime = System.nanoTime();
                duration = (endTime - startTime) / 1000000;
                System.out.println(" QuickSort \n>>" + duration + "ms");
                
                //System.out.println("------------------------------------------------");
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

