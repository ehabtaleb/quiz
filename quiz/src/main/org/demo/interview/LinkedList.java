package org.demo.interview;

/**
 * Created by ehabtaleb on 07/03/17.
 */
public class LinkedList {

  public static Node reverse( Node n) {
    if(n == null || n.next == null){
      return n;
    }
    Node curr = n.next;
    Node prev = n;
    prev.next = null;
    while (curr.next != null){
      Node tmp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tmp;
    }
    curr.next= prev;
    return curr;
  }

  public static void print(Node node) {
    if(node == null) return;
    Node cur = node;
    while(cur != null){
      System.out.print(cur.data+" ");
      cur = cur.next;
    }
  }

  public static class Node {
    int data;
    Node next;
    public Node(int d){
      data= d;
    }

    public Node add(Node node) {
      next = node;
      return node;
    }
  }
}
