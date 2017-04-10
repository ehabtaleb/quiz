package org.demo.interview;

import org.junit.Test;

/**
 * Created by ehabtaleb on 28/11/16.
 */
public class InsertionSortTest  {

  @Test
  public void testSort() throws Exception {
    Integer[] arr = new Integer[]{2,4,5,8,1,3,9,6};
    Integer[] sorted = InsertionSort.sort(arr);
    Sorting.printArray(sorted);

  }
}