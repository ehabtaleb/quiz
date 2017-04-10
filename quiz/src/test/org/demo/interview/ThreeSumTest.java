package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ehabtaleb on 28/01/17.
 */
public class ThreeSumTest {
  
  @Test
  public void testThreeSum(){
    
    int[] arr = new int[]{2,43,-50,7,-3,5,7,-2};
    Assert.assertThat(threeSum(arr), Is.is(3));
  }

  private int threeSum(int[] arr) {
    int n = arr.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        for (int k = j+1; k < n; k++) {
          if(arr[i]+arr[j]+arr[k] == 0){
            count++;
          }
        }
      }
    }
    return count;
  }

  @Test
  public void testReverseArrayInPlace(){
    int[] arr = new int[]{2,4,5,7,13,15,17,22};
    Assert.assertThat(reverse(arr), Is.is(new int[]{22, 17, 15, 13, 7, 5, 4, 2}));
    int[] evenArr = new int[]{2,4,5,7,13,14,15,17,22};
    Assert.assertThat(reverse(evenArr), Is.is(new int[]{22, 17, 15, 14, 13, 7, 5, 4, 2}));

  }

  private int[] reverse(int[] arr) {
    for (int i = 0, j = arr.length-1 ; i < arr.length /2 ; i++, j--) {
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }
    return arr;
  }

  @Test
  public void testBinarySearch(){
    int[] arr = new int[]{2,4,5,7,13,15,17,22};
    Assert.assertThat(binarySearch(arr, 5), Is.is(2));
    Assert.assertThat(binarySearch(arr,6), Is.is(-1));
  }

  private int binarySearch(int[] arr, int key) {
    return binarySearch(arr, 0, arr.length -1, key);
  }

  private int binarySearch(int[] arr, int lo, int high, int key) {
    Sorting.printArray(arr);
    /*
    System.out.println("lo = " + lo);
    System.out.println("high = " + high);
    System.out.println("key = " + key);*/
    if(lo > high){
      return -1;
    }

    int mid = (high + lo) /2 ;
    System.out.println("mid = " +mid+" arr[mid] = " + arr[mid]);
    if(key == arr[mid]){
      return mid;
    }
    if(key < arr[mid]){
      return binarySearch(arr, lo, mid-1 , key);
    }else {
      return binarySearch(arr, mid+1, high , key);
    }
  }
}

