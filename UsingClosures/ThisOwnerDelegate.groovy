/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def examiningClosure(closure) {
  closure()
}

examiningClosure() { 
  println "In First Closure:"
  println "class is " + getClass().name
  println "this is " + this + ", super:" + this.getClass().superclass.name
  println "owner is " + owner + ", super:" + owner.getClass().superclass.name
  println "delegate is " + delegate +
              ", super:" + delegate.getClass().superclass.name
  
  examiningClosure() { 
    println "In Closure within the First Closure:"
    println "class is " + getClass().name
    println "this is " + this + ", super:" + this.getClass().superclass.name
    println "owner is " + owner + ", super:" + owner.getClass().superclass.name
    println "delegate is " + delegate +
                ", super:" + delegate.getClass().superclass.name
  }  
}
