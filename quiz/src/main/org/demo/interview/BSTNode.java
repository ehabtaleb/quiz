package org.demo.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by ehabtaleb on 05/02/17.
 */
public class BSTNode<Key extends Comparable<Key>> {

  private Node<Key> root;

  class Node<Key extends Comparable >{
    Key key;
    String value;
    Node<Key> left, right;

    public Node(Key k, String v){
      this.key = k;
      this.value = v;
    }
  }


  public Node insert(Key k, String v){
    Node x = root;
    int rank = k.compareTo((Key) x.key);
    if(rank == 0){
      return root;
    }
    while(x != null){
      if( rank > 0){
        x = x.right;
      }else if(rank < 0){
        x = x.left;
      }
    }
    return root;
  }

  public Node search(Key k){
    Node x = root;
    while(x != null){
      int rank = x.key.compareTo(k);
      if( rank > 0){
        x = x.right;
      }else if(rank < 0){
        x = x.left;
      }
      return x;
    }
    return null;
  }

  public ArrayList<LinkedList<Node>> levelLists(Node root){
    ArrayList<LinkedList<Node>> result = new ArrayList<>();
    int level = 0;
    if(root == null) return result;
    LinkedList<Node> list = new LinkedList<>();
    list.add(root);
    result.add(level, list);
    while (true){
      LinkedList<Node> prevLevelList = result.get(level);
      LinkedList<Node> dList = new LinkedList<>();
      for (int i = 0; i < prevLevelList.size(); i++) {
        Node n = prevLevelList.get(i);
        if(n != null) {
          if (n.left != null) dList.add(n.left);
          if (n.right != null) dList.add(n.right);
        }
      }
      if(dList.isEmpty()){
        break;
      }
      result.add(level+1, dList);
      level = level + 1;
    }
    return result;
  }


}
