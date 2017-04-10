package org.demo.interview;

/**
 * Created by ehabtaleb on 02/02/17.
 */
public class MaxPriorityQueue<Key extends Comparable<Key>> {

  private Key[] keys;
  private int next;
  public MaxPriorityQueue(int capacity) {
    keys = (Key[]) new Comparable[capacity];
    next = 0;
  }

  public int getParent(int child){
    if(child < 1){
      return -1;
    }
    return child /2;
  }

  public int getRightChild(int parent){
    int child = parent * 2+1;
    if(child >= keys.length){
      return -1;
    }
    return child;
  }

  public int getLeftChild(int parent){
    int left = parent * 2;
    if(left >= keys.length){
      return -1;
    }
    return left;
  }

  public void insert(Key key){
    keys[next] = key;
    swim(next);
    next = next + 1;
  }

  public Key deleteMax(){
    Key max = keys[0];
    keys[0] = keys[next-1];
    sink(0);
    next = next - 1;
    return max;
  }

  private void sink(int idx) {

    int left = getLeftChild(idx);
    int right = getRightChild(idx);
    int maxChild = keys[left].compareTo(keys[right]) > 0? left: right;
    while (idx < keys.length && keys[idx].compareTo(keys[maxChild]) < 0) {
      swap(keys, maxChild, idx);
      idx = maxChild;
      left = getLeftChild(idx);
      right = getRightChild(idx);
      maxChild = keys[left].compareTo(keys[right]) > 0? left: right;
    }
  }

  public void show(){
    for (int i = 0; i < keys.length; i++) {
      System.out.print(keys[i] + " ");
    }
    System.out.println();
  }
  private void swim(int idx) {
    while (idx > 0 && keys[getParent(idx)].compareTo(keys[idx]) < 0){
      swap(keys, idx, getParent(idx));
      idx = getParent(idx);
    }
  }

  private void swap(Key[] keys, int child, int parent) {
    Key temp = keys[child];
    keys[child] = keys[parent];
    keys[parent] = temp;
  }
}
