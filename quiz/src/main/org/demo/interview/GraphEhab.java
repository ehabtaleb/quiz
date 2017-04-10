package org.demo.interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ehabtaleb on 02/12/16.
 */
public class GraphEhab {

  public static class Node{
    public Node(int d){
      this.data = d;
    }
    int data;
    Node left;
    Node right;
    public String toString(){
      return data+"";
    }
  }

  public static boolean checkBST(Node root) {
    if(root == null){
      return true;
    }
    Map dataMap = new HashMap();
    dataMap.put(root.data, root);
    boolean bst = checkBST(root.left, dataMap);
    if(bst) {
      bst &= checkBST(root.right, dataMap);
    }
    return bst;
  }

  private static boolean checkBST(Node root, Map dataMap) {
    if(root == null){
      return true;
    }
    LinkedList<Node> nextToVisit = new LinkedList();
    nextToVisit.add(root);
    while(!nextToVisit.isEmpty()){
      Node node = nextToVisit.remove();
      if(dataMap.containsKey(node.data)){
        return false;
      }
      if(node.left != null && node.data < node.left.data ){
        return false;
      }
      if(node.right != null && node.data > node.right.data ){
        return false;
      }
      dataMap.put(root.data, root);
      if(node.left != null) {
        nextToVisit.add(node.left);
      }
      if(node.right != null) {
        nextToVisit.add(node.right);
      }
    }
    return true;
  }

}
