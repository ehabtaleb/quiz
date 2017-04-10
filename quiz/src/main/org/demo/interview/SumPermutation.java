package org.demo.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehabtaleb on 04/02/17.
 */
public class SumPermutation {

  private static int match = 12;

  public static void findSumPermutation(List<Integer> input,
      List<Integer> output, int sum, int level) {
    // refuse
    if (sum > match) {
      return;
    }
    // found match
    if (sum == match) {
      System.out.println("output = " + output);
      return;
    }
    for (int i = 0; i < input.size(); i++) {
      List<Integer> inClone = new ArrayList<>(input);
      int n = inClone.remove(i);
      List<Integer> outClone = new ArrayList<>(output);
      outClone.add(n);
      sum = calcSum(outClone);
      findSumPermutation(inClone, outClone, sum, level + 1);
    }

  }

  private static int calcSum(List<Integer> outClone) {
    int sum = 0;
    for (int i = 0; i < outClone.size(); i++) {
      sum += outClone.get(i);
    }
    return sum;
  }
  
  
  public static void stringPermutation(String input, String output, int n, int level){
    
    if(output.length() > n){
      return;
    }
    if(output.length() == n){
      System.out.println("output = " + output);
      return;
    }

    for (int i = 0; i < input.length(); i++) {
      String inClone = input.substring(i+1);
      String outClone = String.valueOf(output);
      char c = input.charAt(i);
      outClone = outClone.concat(String.valueOf(c));
      System.out.println("inClone = " + inClone);
      System.out.println("outClone = " + outClone);
      stringPermutation(inClone, outClone, n, level + 1);
    }
  }
}
