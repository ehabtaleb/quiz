package org.demo.interview;

/**
 * Created by ehabtaleb on 02/12/16.
 */
public interface Tree<D extends Comparable> {

  boolean isEmpty();

  BST addElement(D element);

  boolean isMember(D element);

  int cardinality();

}
