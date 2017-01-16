package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Created by ehabtaleb on 11/01/17.
 */
public class StringBalanceTest {
  
  @Test
  public void testBalance(){
    Assert.assertThat(isBalanced("(hello)"), Is.is(true));
    Assert.assertThat(isBalanced("hello"), Is.is(true));
    Assert.assertThat(isBalanced("{()}"), Is.is(true));
    Assert.assertThat(isBalanced("()"), Is.is(true));
    Assert.assertThat(isBalanced("(>>"), Is.is(false));
    Assert.assertThat(isBalanced("(}"), Is.is(false));
    Assert.assertThat(isBalanced("()<>{}[]"), Is.is(true));
    Assert.assertThat(isBalanced("()<>{}[}"), Is.is(false));
    Assert.assertThat(isBalanced(""), Is.is(true));
  }

  private boolean isBalanced(String str) {
    String start = "({[<";
    String end = ")}]>";
    Stack<Character> stack = new Stack<>();
    int len = str.length();
    for (int i = 0; i < len; i++) {
      char c = str.charAt(i);
      if(start.indexOf(c) > 0){
        stack.push(Character.valueOf(c));
      }else if(end.indexOf(c) > 0 ){
        if(stack.isEmpty()){
          return false;
        }
        char s = stack.pop();
        if(end.indexOf(c) != start.indexOf(s)){
          stack.push(s);
          stack.push(c);
        }
      }
    }
    if(stack.isEmpty()){
      return true;
    }
    return false;
  }
}
