package org.demo.interview;

/**
 * Created by ehabtaleb on 17/02/17.
 */
public class Bits {

  public static boolean isNBitSet(int x, int idx) {
    int mask = 1 << idx;
    System.out.println("mask = " + mask);
    return (x & mask) != 0;
  }

  public static int setNBit(int x, int idx) {
    int mask = 1 << idx;
    System.out.println("mask = " + mask);
    x |= mask;
    return x;
  }

  public static int countOneBit(int x){
    int count = 0;
    while (x != 0){
      count += x & 1;
      x = x >> 1;
    }
    return count;
  }
}
