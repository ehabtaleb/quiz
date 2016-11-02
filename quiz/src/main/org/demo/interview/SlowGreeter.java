package org.demo.interview;

/**
 * Created by ehabtaleb on 25/10/16.
 */
public class SlowGreeter {
  static {
    new SlowGreeter();
  }

  private void sayHello() {
    System.out.println("Hello Slackers!!!");
  }

  public SlowGreeter() {
    Thread thread = new Thread(new Runnable() {
      public void run() {
        sayHello();
      }
    });
    thread.start();
    try {
      thread.join();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  public static void main(String... args) {
    System.out.println("We love sharing knowledge :-)");
    new SlowGreeter();
  }
}