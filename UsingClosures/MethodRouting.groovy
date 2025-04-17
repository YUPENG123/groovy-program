/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class Handler {
  def f1() { println "f1 of Handler called ..."}
  def f2() { println "f2 of Handler called ..."}  
}

class Example {
  def f1() { println "f1 of Example called ..."}
  def f2() { println "f2 of Example called ..."}

  def foo(closure) {
    closure.delegate = new Handler()
    closure()
  }
}

def f1() { println "f1 of Script called..." }

new Example().foo {
  f1()
  f2()
}
