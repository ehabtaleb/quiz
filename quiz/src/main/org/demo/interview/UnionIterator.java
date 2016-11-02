package org.demo.interview;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ehabtaleb on 31/07/16.
 */
public class UnionIterator<T extends Comparable> implements Iterator{

  private final Iterator<T> iterator1;
  private final Iterator<T> iterator2;

  private T next1;
  private T next2;

  public UnionIterator(Iterator<T> iter1, Iterator<T> iter2){
    this.iterator1 = iter1;
    this.iterator2 = iter2;
    this.next1 = safeNext(iterator1);
    this.next2 = safeNext(iterator2);

  }

  private T safeNext(Iterator<T> iter){
    T result = null;
    try {
      result = iter.next();
    }catch (NoSuchElementException e){
      return null;
    }
    return result;
  }

  @Override public boolean hasNext() {
    return next1 != null || next2 != null || iterator1.hasNext() || iterator2.hasNext();
  }

  @Override public T next() throws NoSuchElementException{
    if(!hasNext()){
      throw new NoSuchElementException();
    }
    T result = null;
    if(next1 == null || next1.compareTo(next2) > 0) {
      result = next2;
      next2 = safeNext(iterator2);
      return result;
    }else{
      result = next1;
      next1 = safeNext(iterator1);
      return result;
    }
  }

  public T peek(){
    if(next1 == null || next1.compareTo(next2) > 0) {
      return next2;
    }else {
      return next1;
    }
  }

  @Override public void remove() {

  }

}
