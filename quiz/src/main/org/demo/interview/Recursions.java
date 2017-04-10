package org.demo.interview;

/**
 * Created by ehabtaleb on 15/02/17.
 */
public class Recursions {

  public static long nFibonacciNumber(int n) {
    if (n == 0 ) return 0;
    if(n == 1) return 1;

    long n0 = 0, n1 = 1;
    for (int i = 2; i < n; i++) {
      long tmp1 = n1;
      n1 = n0 + n1;
      n0 = tmp1;
    }
    return n0 + n1;
  }

  public static long nFibonacciNumberRecursive(int n) {
    if(n == 0) return 0;
    if(n == 1) return 1;
    if(n < 0) return -1;
    return nFibonacciNumberRecursive(n -1) + nFibonacciNumberRecursive(n-2);
  }
}
