/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
package com.agiledeveloper

public class ClassWithDependency
{
  def methodA(val, file)
  {
    file.write "The value is ${val}."
  }
  def methodB(val)
  {
    def file = new java.io.FileWriter("output.txt")
    file.write "The value is ${val}."
  }
  def methodC(val)
  {
    def file = new java.io.FileWriter("output.txt")
    file.write "The value is ${val}."
    file.close()
  }
}
