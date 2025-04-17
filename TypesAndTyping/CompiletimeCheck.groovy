/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
@groovy.transform.TypeChecked
def shout(String str) {
//...
  println "Printing in uppercase"
  println str.toUpperCase()
  
  println "Printing again in uppercase"
  println str.toUppercase()
}

try {
  shout('hello')  
} catch(ex) {
  println "Failed..."
}
