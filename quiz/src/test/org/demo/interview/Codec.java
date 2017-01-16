package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by ehabtaleb on 15/01/17.
 */
public class Codec {


  @Test
  public void testCodec(){

    Codec codec = new Codec();
    Assert.assertThat(codec.serialize(codec.deserialize("1")), Is.is("1,x,x"));
    Assert.assertThat(codec.serialize(codec.deserialize("1,2")), Is.is("1,2,x,x,x"));
    Assert.assertThat(codec.serialize(codec.deserialize("1,2,3")), Is.is("1,2,3"));
    Assert.assertThat(codec.serialize(codec.deserialize("1,x,2")), Is.is("1,x,2"));
    Assert.assertThat(codec.serialize(codec.deserialize("1,2,x,3")), Is.is("1,2,x,3"));
  }


  /**
   * Definition for a binary tree node.
   * */
   public class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode(int x) { val = x; }
    }




    private static String N = "x";
    private static String SPLIT = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
      if(root == null){
        return "";
      }
      LinkedList<TreeNode> queue = new LinkedList<>();
      LinkedList<TreeNode> visited = new LinkedList<>();
      StringBuilder buff = new StringBuilder();
      queue.add(root);
      while(!queue.isEmpty()){
        TreeNode node = queue.poll();
        /*if(visited.contains(node)){
          continue;
        }*/
        if(node == null){
          buff.append(N).append(SPLIT);
          continue;
        }
        buff.append(node.val).append(SPLIT);
        visited.add(node);
        queue.add(node.left);
        queue.add(node.right);

      }

      buff.deleteCharAt(buff.length() -1);
      System.out.println(buff);
      return buff.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      if(data == null || data.length() < 1){
        return null;
      }
      LinkedList<String> values = new LinkedList<>();
      values.addAll(Arrays.asList(data.split(SPLIT)));
      LinkedList<TreeNode> queue = new LinkedList<>();
      String val = values.poll();
      if(val.equals(N)) return null;
      TreeNode root = new TreeNode(Integer.valueOf(val));
      queue.add(root);
      while(!queue.isEmpty()){
        TreeNode node = queue.poll();

        buildSubTree(node, values);
        if(node.left != null){
          queue.add(node.left);
        }
        if(node.right != null){
          queue.add(node.right);
        }
      }
      return root;
    }

    void buildSubTree(TreeNode node, LinkedList<String> values){
      String val = values.poll();
      if(val != null && !N.equals(val)){
        TreeNode left = new TreeNode(Integer.valueOf(val));
        node.left = left;
      }
      val = values.poll();
      if(val != null && !N.equals(val)){
        TreeNode right = new TreeNode(Integer.valueOf(val));
        node.right = right;
      }
    }

}
