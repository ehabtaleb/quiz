package org.demo.interview;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by ehabtaleb on 04/02/17.
 */
public class SumPermutationTest {


  @Test
  public void testStringPermutation(){

    SumPermutation.stringPermutation("hello", "", 5, 0);
  }

  @Test
  public void testFindSumPermutation() throws Exception {

    ArrayList input_list = new ArrayList();
    input_list.add(1);
    input_list.add(2);
    input_list.add(3);
    input_list.add(4);
    input_list.add(5);
    ArrayList output_list = new ArrayList();

    // First call
    SumPermutation.findSumPermutation(input_list, output_list, 0, 0);

  }
}