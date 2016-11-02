package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ehabtaleb on 25/10/16.
 */
public class SplitInversionTest {

  @Test
  public void testCountSplitInversion(){
    int[] arr = new int[]{1,2,3,8,4,5,6,7};
    int count = SplitInversion.countSplitInversion(arr);
    assertThat(count, Is.is(4));

  }

}