package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by ehabtaleb on 11/02/17.
 */
public class SortStack {
  
  
  @Test
  public void testSortStack(){
    int[] items = new int[]{3,4,1,7,9,8,5,2};
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < items.length; i++) {
      s.push(items[i]);
    }
    Stack r = sort(s);
    while (!r.empty()){
      System.out.print(r.pop() + " ");
    }
    System.out.println( );
  }

  public static Stack sort(Stack<Integer> s) {
    Stack<Integer> r = new Stack<>();
    while(!s.empty()){
      int tmp = s.pop();
      while (!r.empty() && tmp > r.peek()){
        s.push(r.pop());
      }
      r.push(tmp);
    }
    return r;
  }

  @Test
  public void testReverseStack() {
    int[] items = new int[] { 3, 4, 1, 7, 9, 8, 5, 2 };
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < items.length; i++) {
      s.push(items[i]);
    }
    Stack r = reverse(s);
    while (!r.empty()){
      System.out.print(r.pop() + " ");
    }
    System.out.println();
  }

  public Stack reverse(Stack<Integer> stack){
    if(stack.empty()) {
      return stack;
    }
    int x = stack.pop();
    reverse(stack);
    stack.push( x);
    return stack;
  }



}
