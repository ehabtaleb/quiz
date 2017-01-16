package org.demo.interview;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by ehabtaleb on 02/12/16.
 */
public class ArrayProblemsTest {

  @Test
  public void testLeftShift() throws Exception {
    int[] arr = new int[]{2,4,5,8,1,3,9,6};
    Sorting.printArray(arr);
    int[] shifted = ArrayProblems.leftShift(arr, arr.length, 2);
    Sorting.printArray(shifted);
  }

  @Test
  public void testLeftShift4() throws Exception {
    int[] arr = new int[]{1,2,3,4,5};
    Sorting.printArray(arr);
    int[] shifted = ArrayProblems.leftShift(arr,arr.length, 4);
    Sorting.printArray(shifted);
  }
}