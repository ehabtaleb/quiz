package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ehabtaleb on 01/11/16.
 */
public class StringProblemsTest {

  @Before public void setUp() throws Exception {

  }

  @Test public void testIsBalanced() throws Exception {
      assertThat(StringProblems.isBalanced(""), Is.is(1));
      assertThat(StringProblems.isBalanced("("), Is.is(0));
      assertThat(StringProblems.isBalanced("(9)"), Is.is(1));
      assertThat(StringProblems.isBalanced("{(9)}"), Is.is(1));
      assertThat(StringProblems.isBalanced("(9)<<{123}>><{[iuyr]}>"), Is.is(1));
      assertThat(StringProblems.isBalanced("(9)<}"), Is.is(0));
      assertThat(StringProblems.isBalanced("(9){<}>"), Is.is(0));
  }
}