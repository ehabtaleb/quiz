package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ehabtaleb on 15/02/17.
 */
public class RecursionsTest {

  @Test public void testNFibonacciNumber() throws Exception {

    Assert.assertThat(Recursions.nFibonacciNumber(3), Is.is(2l));
    Assert.assertThat(Recursions.nFibonacciNumber(4), Is.is(3l));
    Assert.assertThat(Recursions.nFibonacciNumber(5), Is.is(5l));
    Assert.assertThat(Recursions.nFibonacciNumber(100), Is.is(3736710778780434371L));

    System.out.println("iter done !! " );
    Assert.assertThat(Recursions.nFibonacciNumberRecursive(3), Is.is(2l));
    Assert.assertThat(Recursions.nFibonacciNumberRecursive(4), Is.is(3l));
    Assert.assertThat(Recursions.nFibonacciNumberRecursive(5), Is.is(5l));
  }
}