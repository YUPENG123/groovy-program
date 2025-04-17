/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class A {
  boolean equals(other) {
    println "equals called"
    false
  }  
}

class B implements Comparable {
  boolean equals(other) {
    println "equals called"
    false
  }  
  
  int compareTo(other) {
    println "compareTo called"
    0
  }
}

new A() == new A()
new B() == new B()
