package org.demo.interview;

import java.util.Arrays;

/**
 * Created by ehabtaleb on 25/10/16.
 */
public class SplitInversion {

  public static int countSplitInversion(int[] array){
    if(array.length <= 1){
      return 0;
    }
    int n = array.length / 2;
    int[] leftArray = Arrays.copyOfRange(array, 0, n);
    int[] rightArray = Arrays.copyOfRange(array, n, array.length);
    System.out.println("leftArray = ");
    Sorting.printArray(leftArray);
    System.out.println("rightArray = ");
    Sorting.printArray(rightArray);
    int left = countSplitInversion(leftArray);
    int right = countSplitInversion(rightArray);
    int scount = splitMerge(leftArray, rightArray);
    return left+ right+scount;
  }

  private static int splitMerge(int[] leftArray, int[] rightArray) {
    int j = 0;
    int k = 0;
    int[] merged = new int[leftArray.length+rightArray.length];
    int count = 0;
    int i = 0;
    while(j < leftArray.length && k < rightArray.length){
      if(leftArray[j] > rightArray[k]){
        merged[i] = rightArray[k];
        System.out.println(String.format("i=%d  ,leftArray[j] %d >  rightArray[k] %d", i, leftArray[j], rightArray[k]));
        count++;
        k++;
      }else{
        merged[i] = leftArray[j];
        j++;
      }
      i++;
    }
    while(j < leftArray.length){
      merged[i] = leftArray[j];
      j++;
      i++;
    }
    while(k < rightArray.length){
      merged[i] = rightArray[k];
      k++;
      i++;
    }
    return count;
  }



}
