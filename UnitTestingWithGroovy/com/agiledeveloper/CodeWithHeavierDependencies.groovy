/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
package com.agiledeveloper

public class CodeWithHeavierDependencies
{
  public void myMethod()
  {
    def value = someAction() + 10

    println(value)
  }

  int someAction()
  {
    Thread.sleep(5000) // simulates time consuming action

    return Math.random() * 100 // Simulated result of some action
  }
}
