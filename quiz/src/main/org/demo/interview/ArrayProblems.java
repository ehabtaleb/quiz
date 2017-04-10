package org.demo.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayProblems {

  public static <T> T[] leftShift(T[] array, int length, int nShift) {

    T[] toShift = Arrays.copyOf(array, nShift);
    int count = 0;
    for (int i = 0; (i + nShift) < length; i++) {
      array[i] = array[nShift + i];
      count++;
    }
    for (int i = 0; i < toShift.length; i++) {
      array[count] = toShift[i];
      count++;
    }
    return array;
  }

  public static ArrayList<ArrayList<Integer>> getAllSubSets(Integer [] set){


    return null;

  }

  // stock_prices_yesterday = [10, 7, 5, 8, 11, 9]
  public static int maxProfit(int [] prices){
    int maxProfit = 0;
    int start = 0;
    int i = 1;
    while( i < prices.length && prices[i] <= prices[i -1]){
      start = i;
      i++;
    }
    for (int j = start+ 1; j < prices.length; j++) {
      //sell today
      int temp1 = prices[j] - prices[start];
      // start from yesterday
      int temp2 = prices[j] - prices[j-1];

      int localProfit = Math.max(temp1, temp2);
      if(temp2 > temp1) {
        start = j - 1;
      }
      if(maxProfit < localProfit){
        maxProfit = localProfit;
      }
    }
    return maxProfit;
  }

  /**
   * Max subArray <=k 
   * {4,3,1,2,1,1,1,2} k = 5 ==> 4 {1,2,1,1}
   */
  
  public static int maxLengthSubArray(int[] a, int k ){
    int maxLength = 0;
    int start = 0;
    int end = 0;
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      if(sum <= k){
        end = i;
      } else {// sum > k
        if(sum > k && start < a.length){
          sum -= a[start];
          start += 1;
          end = i;
        }
      }
      maxLength = Math.max(maxLength, (end - start +1));
    }
    return maxLength;
  }

  public static int[] maxSubArray(int[] a, int k ){
    int maxLength = 0;
    int start = 0;
    int end = 0;
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
      if(sum <= k){
        end = i;
      } else {// sum > k
        if(sum > k && start < a.length){
          sum -= a[start];
          start += 1;
          end = i;
        }
      }
      maxLength = Math.max(maxLength, (end - start +1));
    }
    int[] result = new int[end -start+1];
    System.arraycopy(a, start, result, 0, result.length);
    return result;
  }
}
