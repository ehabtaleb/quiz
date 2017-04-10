package org.demo.interview;

import java.util.*;
import java.util.LinkedList;

/**
 * Created by ehabtaleb on 14/03/17.
 */
public class AutoComplete {

  private Node trie;

  public AutoComplete(String[] dict){
    trie = new Node("");
    for (String s: dict){
      insertWord(s);
    }
  }

  private void insertWord(String s) {
    int n = s.length();
    Node curr = trie;
    for (int i = 0; i < n; i++) {
      Node node = curr.characters.get(s.charAt(i));
      if(node == null){
        node = new Node(s.substring(0,i+1));
      }
      curr.characters.put(s.charAt(i), node);
      if(i == s.length()-1){
        node.word = true;
      }
    }
  }

  public List<String> findWords(String pre){
    LinkedList<String> result = new LinkedList<>();
    Node curr = trie;
    for (char c : pre.toCharArray()){
      Node n = curr.characters.get(c);
      if(n != null){
        curr = n;
      }else{
        for (Map.Entry<Character, Node> e : curr.characters.entrySet()){
          if(e.getValue().word){
            result.add(e.getValue().prefix);
          }
        }
      }
    }
    return result;
  }

  private class Node{
    String prefix;
    HashMap<Character, Node> characters = new HashMap<>();
    boolean word;

    public Node(String pre){
      prefix = pre;
    }


  }
 
}
