package org.demo.interview;

import org.hamcrest.core.AnyOf;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

/**
 * Created by ehabtaleb on 01/11/16.
 */
public class StringProblemsTest {

  @Before public void setUp() throws Exception {

  }

  @Test public void testIsBalanced() throws Exception {
      assertThat(StringProblems.isBalanced(""), is(1));
      assertThat(StringProblems.isBalanced("("), is(0));
      assertThat(StringProblems.isBalanced("(9)"), is(1));
      assertThat(StringProblems.isBalanced("{(9)}"), is(1));
      assertThat(StringProblems.isBalanced("(9)<<{123}>><{[iuyr]}>"), is(1));
      assertThat(StringProblems.isBalanced("(9)<}"), is(0));
      assertThat(StringProblems.isBalanced("(9){<}>"), is(0));
  }

  @Test
  public void testFrequencyTest(){
    //assertThat(StringProblems.sortFrequency("trhreee"), AnyOf.anyOf(
    //    is("eeerrth"), is("eeerrht")));

    assertThat(StringProblems.frequencySort("trhreee"), AnyOf.anyOf(is("eeerrth"), is("eeerrht")));
    assertThat(StringProblems.frequencySort("ccc"), AnyOf.anyOf(is("ccc"), is("ccc")));
    assertThat(StringProblems.frequencySort("cccaaa"), AnyOf.anyOf(is("aaaccc"), is("cccaaa")));


  }

  @Test
  public void testIsStringPermutation(){
    assertThat(StringProblems.isStringPermutation("ABCD", "ACDB"), is(true));
    assertThat(StringProblems.isStringPermutation("ABCD", "ACDC"), is(false));
  }

  @Test public void testStringPermutation() throws Exception {
    assertThat(StringProblems.stringPermutation("AB"), is(new String[] { "AB", "BA" }));
    Sorting.printArray(StringProblems.stringPermutation("ABC"));
    Sorting.printArray(StringProblems.stringPermutation("ABCD"));
    assertThat(StringProblems.stringPermutation("ABC"),
        is(new String[] { "ABC", "ACB", "BAC", "BCA", "CAB", "CBA" }));
  }

}