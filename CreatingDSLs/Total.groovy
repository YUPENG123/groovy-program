/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:METHOD_OUTPUT"
value = 0
def clear() { value = 0 }
def add(number) { value += number }
def total() { println "Total is $value" }

clear()
add 2
add 5
add 7
total()
println "//" + "END:METHOD_OUTPUT"

println "//" + "START:PROPERTY_OUTPUT"
try {
  total
} catch(Exception ex) {
  println ex
}
println "//" + "END:PROPERTY_OUTPUT"
