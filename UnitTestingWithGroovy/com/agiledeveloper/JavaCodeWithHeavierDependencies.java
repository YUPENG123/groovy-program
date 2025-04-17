/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
package com.agiledeveloper;

public class JavaCodeWithHeavierDependencies
{
  public int someAction()
  {
    try
    {
      Thread.sleep(5000); // simulates time consuming action
    }
    catch(InterruptedException ex) {}
    
    return (int) (Math.random() * 100); // Simulated result of some action
  }

  public void myMethod()
  {
    int value = someAction() + 10;

    System.out.println(value);
  }
}
