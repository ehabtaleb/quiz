package org.demo.interview;

import org.junit.Test;

/**
 * Created by ehabtaleb on 20/10/16.
 */
public class SortingTest {

  int[] array = new int[] { 10, 23, 2, 8 };
  int[] array2 = new int[] { 1, 4, 5, 9 };

  @Test public void testSelectionSort() {
    Sorting.printArray(array);
    int[] sorted = Sorting.selectionSort(array);
    System.out.println("sorted ================ ");
    Sorting.printArray(sorted);
  }

  @Test public void testInsertionSort() {
    Sorting.printArray(array);
    int[] sorted = Sorting.insertionSort1(array);
    System.out.println("sorted ================ ");
    Sorting.printArray(sorted);
  }

  @Test public void testMergeSort() {
    Sorting.printArray(array);
    int[] sorted = Sorting.mergeSort(array);
    System.out.println("sorted ================ ");
    Sorting.printArray(sorted);
  }


  @Test public void testBubleSort() {
    Sorting.printArray(array);
    int[] sorted = Sorting.bubbleSort(array);
    System.out.println("sorted ================ ");
    Sorting.printArray(sorted);
  }

  @Test
  public void testMerge(){
    int[] sorted = Sorting.selectionSort(array);
    int[] sorted2 = Sorting.selectionSort(array2);

    int[] merged = Sorting.merge(sorted,sorted2);
    Sorting.printArray(merged);
  }

}