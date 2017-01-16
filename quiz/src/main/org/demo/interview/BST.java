package org.demo.interview;

/**
 * Created by ehabtaleb on 26/12/16.
 */
public class BST <D extends Comparable> implements Tree<D> {
  private D root;
  private Tree<D> leftTree;
  private Tree<D> rightTree;

  public BST(D root) {
    this.root = root;
    this.leftTree = new EmptyTree<>();
    this.rightTree = new EmptyTree<>();
  }

  public BST(D root, Tree<D> leftTree, Tree<D> rightTree) {
    this.root = root;
    this.leftTree = leftTree;
    this.rightTree = rightTree;
  }

  @Override public boolean isEmpty() {
    return false;
  }

  @Override public BST addElement(D element) {
    int rank = element.compareTo(root);
    if (rank < 0){
      leftTree.addElement(element);
    }else if (rank > 1){
      rightTree.addElement(element);
    }
    return this;
  }

  @Override public boolean isMember(D element) {
    int rank = element.compareTo(root);
    if (rank == 0){
      return true;
    }
    if (rank < 0){
      return leftTree.isMember(element);
    }
    return rightTree.isMember(element);
  }


  @Override public int cardinality() {
    return 1+ leftTree.cardinality()+rightTree.cardinality();
  }
}
