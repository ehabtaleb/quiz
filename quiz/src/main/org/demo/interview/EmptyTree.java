package org.demo.interview;

/**
 * Created by ehabtaleb on 26/12/16.
 */
public class EmptyTree <D extends Comparable> implements Tree<D>{

  @Override public boolean isEmpty() {
    return true;
  }

  @Override public BST<D> addElement(D element) {
    return new BST(element);
  }

  @Override public boolean isMember(D element) {
    return false;
  }

  @Override public int cardinality() {
    return 0;
  }

}
