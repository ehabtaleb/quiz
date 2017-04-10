package org.demo.interview;

/**
 * Created by ehabtaleb on 28/11/16.
 */
public class InsertionSort {
  
  public static Integer[] sort(Integer[] array) {

    for (int i = 0; i < array.length; i++) {
      int j = i;
      int candidate = array[i];
      while (j > 0 && array[j-1] > array[j] ){
        array[j] = array[j -1];
        array[j-1] = candidate;
        j--;
      }
    }
    return array;
  }
}
