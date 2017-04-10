package org.demo.interview;

import junit.framework.TestCase;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ehabtaleb on 02/12/16.
 */
public class ArrayProblemsTest {

  @Test
  public void testLeftShift() throws Exception {
    Integer[] arr = new Integer[]{2,4,5,8,1,3,9,6};
    Sorting.printArray(arr);
    Integer[] shifted = ArrayProblems.leftShift(arr, arr.length, 2);
    Sorting.printArray(shifted);
  }

  @Test
  public void testLeftShift4() throws Exception {
    Integer[] arr = new Integer[]{1,2,3,4,5};
    Sorting.printArray(arr);
    Integer[] shifted = ArrayProblems.leftShift(arr,arr.length, 4);
    Sorting.printArray(shifted);
  }

  @Test public void testGetAllSubSets() throws Exception {

    Integer[] arr = new Integer[]{2,4,5,8,1,3,9,6};
    Sorting.printArray(arr);

    ArrayList<ArrayList<Integer>> sets = ArrayProblems.getAllSubSets(arr);
    for (ArrayList<Integer> list : sets){
      System.out.println("list = " + list);
    }
  }

  @Test
  public void testMaxProfit(){
    int[] stock_prices_yesterday = new int[] {10, 7, 5, 8, 11, 9};
    Assert.assertThat(ArrayProblems.maxProfit(stock_prices_yesterday), Is.is(6));

    stock_prices_yesterday = new int[] {1, 2, 5, 8, 11, 15};
    Assert.assertThat(ArrayProblems.maxProfit(stock_prices_yesterday), Is.is(14));

    stock_prices_yesterday = new int[] {15, 2, 5, 8, 11, 14};
    Assert.assertThat(ArrayProblems.maxProfit(stock_prices_yesterday), Is.is(12));

    stock_prices_yesterday = new int[] {1, 2, 5, 3, 11, 1};
    Assert.assertThat(ArrayProblems.maxProfit(stock_prices_yesterday), Is.is(10));

    stock_prices_yesterday = new int[] {1, 2, 9, 5, 2, 12, 1};
    Assert.assertThat(ArrayProblems.maxProfit(stock_prices_yesterday), Is.is(11));

    stock_prices_yesterday = new int[] {11, 10, 9, 8, 5, 1};
    Assert.assertThat(ArrayProblems.maxProfit(stock_prices_yesterday), Is.is(0));
  }

  @Test
  public void testFormat(){
    int n = 6;
    for(int i = n-1 ; i > 0; i--) {
      int compl = n - i;
      StringBuilder buff = new StringBuilder();
      for (int j = 1; j <= compl; j++) {
        buff.append("#");
      }
      System.out.println(String.format("%" + i + "s", buff.toString()));
    }
    System.out.println(String.format("%" + n + "s", "#"));
  }

  @Test
  public void testMaxLengthSubArray(){
    //Assert.assertThat(ArrayProblems.maxLengthSubArray(new int[]{4,3,1,2,1,1,1,2}, 5), Is.is(4));
    Assert.assertThat(ArrayProblems.maxLengthSubArray(new int[]{4,3}, 2), Is.is(0));
    Assert.assertThat(ArrayProblems
        .maxLengthSubArray(new int[] { 4, 3, 5, 2, 1, 1, 1, 2 }, 5), Is.is(4));
  }


  @Test
  public void testMaxSubArray(){

    Assert.assertThat(ArrayProblems.maxSubArray(
        new int[] { 4, 3, 2, 1, 1, 1, 2 }, 5), AnyOf.anyOf(
        Is.is(new int[] { 2, 1, 1, 1 }), Is.is(new int[] { 1, 1, 1, 2})));
  }

}