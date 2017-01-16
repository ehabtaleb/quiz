package org.demo.interview;

import java.util.Arrays;

public class ArrayProblems {
  
  public static int[] leftShift(int[] array, int n, int d){

    int[] shifted = Arrays.copyOf(array, d);
    int count = 0;
    for (int i = 0; (i+d) < n ; i++) {
      array[i] = array[d+i];
      count++;
    }
    for (int i = 0; i < shifted.length; i++) {
      array[count]= shifted[i];
      count++;
    }
    return array;
  }
}
