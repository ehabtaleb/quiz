package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

/**
 * Created by ehabtaleb on 17/02/17.
 */
public class BitsTest {


  @Test public void testSetNBit() throws Exception {

    assertThat(Bits.setNBit(3, 2), is(7));

  }

  @Test public void testIsNBitSet() throws Exception {

    assertThat(Bits.isNBitSet(3, 0), is(true));
    assertThat(Bits.isNBitSet(3, 1), is(true));
    assertThat(Bits.isNBitSet(3, 2), is(false));
    assertThat(Bits.isNBitSet(16, 4), is(true));
  }

  @Test public void testCountOneBit() throws Exception {
    assertThat(Bits.countOneBit(4), is(1));
    assertThat(Bits.countOneBit(5), is(2));
  }
}