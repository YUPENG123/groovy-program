/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
try {
println "//" + "START:TYPE_OUTPUT"
Integer val = 4
val = 'hello'
} catch(Exception ex) {
  println ex.getClass().name + ": "
  println ex.message[0..56]
  println ex.message[57..-1]
} finally {
println "//" + "END:TYPE_OUTPUT"
}

try {
println "//" + "START:METHOD_OUTPUT"
Integer val = 4
val.blah()
} catch(Exception ex) {
  println ex.getClass().name + ": "
  println ex.message[0..62]
  println ex.message[63..-1]
} finally {
println "//" + "END:METHOD_OUTPUT"
}
