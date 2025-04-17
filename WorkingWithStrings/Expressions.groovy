/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:EXPRESSION_OUTPUT"
value = 12
println "He paid \$${value} for that."
println "//" + "END:EXPRESSION_OUTPUT"

println "//" + "START:EVALUATE_OUTPUT"
what = new StringBuilder('fence')
text = "The cow jumped over the $what"
println text

what.replace(0, 5, "moon")
println text
println "//" + "END:EVALUATE_OUTPUT"

println "//" + "START:CLASS_OUTPUT"
def printClassInfo(obj) {
  println "class: ${obj.getClass().name}"
  println "superclass: ${obj.getClass().superclass.name}"
}

val = 125
printClassInfo ("The Stock closed at ${val}")
printClassInfo (/The Stock closed at ${val}/)
printClassInfo ("This is a simple String")

println "//" + "END:CLASS_OUTPUT"
