/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START: OUTPUT"
def tellFortune(closure) {
  closure new Date("09/20/2012"), "Your day is filled with ceremony"
}
tellFortune() { date, fortune ->
  println "Fortune for ${date} is '${fortune}'"
}
println "//" + "END: OUTPUT"

tellFortune() { Date date, fortune ->
  println "Fortune for ${date} is '${fortune}'"
}
