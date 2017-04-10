package org.demo.interview;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ehabtaleb on 06/02/17.
 */
public class ShiftArrayTest {


  @Test
  public void testLeftShift() throws Exception {
    Integer[] arr = new Integer[]{2,4,5,8,1,3,9,6};
    Sorting.printArray(arr);
    Integer[] shifted = leftShift(arr, 2);
    Sorting.printArray(shifted);
  }

  @Test
  public void testLeftShift4() throws Exception {
    Integer[] arr = new Integer[]{1,2,3,4,5};
    Sorting.printArray(arr);
    Integer[] shifted = leftShift(arr, 4);
    Sorting.printArray(shifted);
  }

  private Integer[] leftShift(Integer[] arr, int nShift) {

    int n = nShift % arr.length;
    Integer[] toShift = Arrays.copyOf(arr, n);

    for (int i = 0; i < (arr.length - n); i++) {
      arr[i] = arr[i+n];
    }
    int j = arr.length - n;
    for (int i = 0 ; i < toShift.length; i++) {
      arr[j+i] = toShift[i];
    }
    return arr;
  }
}
