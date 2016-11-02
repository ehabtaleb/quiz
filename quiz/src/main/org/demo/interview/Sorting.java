package org.demo.interview;

import java.util.Arrays;

/**
 * Created by ehabtaleb on 20/10/16.
 */
public class Sorting {
  public static int[] selectionSort(int[] array) {
    if (array == null || array.length < 1){
      return array;
    }
    int currentSmallest = 0;
    int j = 0;
    for (int i = 0; i <array.length ; i++) {
      currentSmallest = findSmallest(array, i);
      //System.out.println(String.format("i=%d -- current smallest index %d ", i, currentSmallest));
      swap(j, currentSmallest, array);
      j++;
    }
    return array;
  }
  
  public static int[] insertionSort(int[] array){
    for (int i = 1; i < array.length; i++) {
      int candidate = array[i];
      int j = i;
      while(j>0 && array[j-1] > candidate){
        array[j] = array[j-1];
        j--;
      }
      array[j] = candidate;
    }
    
    return array;
  }

  private static int findSmallest(int[] array, int start) {
    int currentSmallest = start;
    for (int i = start; i < array.length; i++) {
      if (array[i] < array[currentSmallest]) {
        currentSmallest = i;
      }
    }
    return currentSmallest;
  }

  private static void swap(int j, int currentSmallest, int[] array) {
    int tmp = array[j];
    array[j] = array[currentSmallest];
    array[currentSmallest] = tmp;
  }

  public static void printArray(int[] arr){
    for (int i = 0; i < arr.length ; i++) {
      System.out.println(String.format("%d | %d ",  i, arr[i]));
    }
  }

  /*
  * the idea is to go throw n elements of array and placing in the right place on the left side
  * start with assuming that first element is sorted
  * 
  */
  public static int[] insertionSort1(int[] arr){
    for (int i = 1; i < arr.length; i++) {
      int candidate = arr[i];
      int j = i;
      while(j > 0 &&  candidate < arr[j -1] ){
        arr[j] = arr[j-1];
        j--;
      }
       arr[j] = candidate;
    }
  
    return arr;
  }
  
  
  public static int[] bubbleSort(int[] arr){
    for (int i = 0; i < arr.length; i++) {
      int maxIndx = getMax(arr, i);
      swapMax(arr, i, maxIndx);
    }
    return arr;
  }

  private static void swapMax(int[] arr, int i, int maxIndx) {
    int temp = arr[maxIndx];
    arr[maxIndx] = arr[i];
    arr[i] = temp;
  }

  private static int getMax(int[] arr, int start) {
    int idx = start;
    for (int i = start; i < arr.length; i++) {
      if(arr[i] > arr[idx]){
        idx = i;
      }
    }
    return idx;
  }

  public static int[] mergeSort(int[] array) {
    if(array.length <=1 ){
      return array;
    }
    int n = array.length/2;
    int[] arr1 = mergeSort(Arrays.copyOfRange(array, 0, n));
    int[] arr2 = mergeSort(Arrays.copyOfRange(array, n+1, array.length));
    return merge(arr1, arr2);
  }

  public static int[] merge(int[] arr1, int[] arr2) {
    int[] merged = new int[arr1.length+ arr2.length];
    int j1 = 0;
    int j2 = 0;
    int i = 0;
    while (j1 < arr1.length && j2 < arr2.length) {
        System.out.println(String.format("i=%d  j1=%d  j2=%d", i, arr1[j1], arr2[j2]));
        if (arr1[j1] < arr2[j2]) {
          merged[i] = arr1[j1];
          j1++;
        } else {
          merged[i] = arr2[j2];
          j2++;
        }
        i++;
    }
    while (j1 < arr1.length) {
        merged[i] = arr1[j1];
        j1++;
        i++;
    }
    while (j2 < arr2.length) {
        merged[i] = arr2[j2];
        j2++;
        i++;
    }
    return merged;
  }
}
