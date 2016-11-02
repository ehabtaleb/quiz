package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by ehabtaleb on 31/07/16.
 */
public class UnionIteratorTest {

  @Test
  public void testNext() throws Exception {

    Iterator<Integer> t1 =
        Arrays.asList(
            new Integer[] { Integer.valueOf(1), Integer.valueOf(3),
                Integer.valueOf(5) }).iterator();
    Iterator<Integer> t2 =
        Arrays.asList(
            new Integer[] { Integer.valueOf(2), Integer.valueOf(4),
                Integer.valueOf(6) }).iterator();
    UnionIterator<Integer> unionIterator = new UnionIterator(t1, t2);

    assertThat(unionIterator.hasNext(), Is.is(true));
    assertThat(unionIterator.next(), Is.is(1));
    assertThat(unionIterator.next(), Is.is(2));
    assertThat(unionIterator.next(), Is.is(3));
    assertThat(unionIterator.next(), Is.is(4));
    assertThat(unionIterator.next(), Is.is(5));
    assertThat(unionIterator.next(), Is.is(6));
  }

  @Test
  public void testEqualNext() {
    Iterator<Integer> t1 =
        Arrays.asList(
            new Integer[] { Integer.valueOf(2), Integer.valueOf(4),
                Integer.valueOf(6) }).iterator();
    Iterator<Integer> t2 =
        Arrays.asList(
            new Integer[] { Integer.valueOf(2), Integer.valueOf(4),
                Integer.valueOf(6) }).iterator();
    UnionIterator<Integer> unionIterator = new UnionIterator(t1, t2);

    assertThat(unionIterator.hasNext(), Is.is(true));
    assertThat(unionIterator.next(), Is.is(2));
    assertThat(unionIterator.next(), Is.is(2));
    assertThat(unionIterator.next(), Is.is(4));
    assertThat(unionIterator.next(), Is.is(4));
    assertThat(unionIterator.next(), Is.is(6));
    assertThat(unionIterator.next(), Is.is(6));
  }

  @Test(expected = NoSuchElementException.class)
  public void testEmptyNext() {

    Iterator<Integer> t1 = Arrays.asList(new Integer[] {}).iterator();
    Iterator<Integer> t2 = Arrays.asList(new Integer[] {}).iterator();
    UnionIterator<Integer> unionIterator = new UnionIterator(t1, t2);

    assertThat(unionIterator.hasNext(), Is.is(false));
    unionIterator.next();
  }

  @Test
  public void testEmptyOneIteratorNext() {

    Iterator<Integer> t1 = Arrays.asList(new Integer[] {}).iterator();
    Iterator<Integer> t2 =
        Arrays.asList(
            new Integer[] { Integer.valueOf(2), Integer.valueOf(4),
                Integer.valueOf(6) }).iterator();
    UnionIterator<Integer> unionIterator = new UnionIterator(t1, t2);

    assertThat(unionIterator.hasNext(), Is.is(true));
    assertThat(unionIterator.next(), Is.is(2));
    assertThat(unionIterator.next(), Is.is(4));
    assertThat(unionIterator.next(), Is.is(6));
  }

  @Test
  public void testPeek() {

    Iterator<Integer> t1 = Arrays.asList(new Integer[] {}).iterator();
    Iterator<Integer> t2 =
        Arrays.asList(
            new Integer[] { Integer.valueOf(2), Integer.valueOf(4),
                Integer.valueOf(6) }).iterator();
    UnionIterator<Integer> unionIterator = new UnionIterator(t1, t2);

    assertThat(unionIterator.hasNext(), Is.is(true));
    assertThat(unionIterator.peek(), Is.is(2));
    assertThat(unionIterator.next(), Is.is(2));
    assertThat(unionIterator.peek(), Is.is(4));
    assertThat(unionIterator.peek(), Is.is(4));
    assertThat(unionIterator.peek(), Is.is(4));
    assertThat(unionIterator.next(), Is.is(4));
  }

}