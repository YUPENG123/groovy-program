/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:FOR_OUTPUT"
for(i in 0..2) {
  print "$i "
}
println "\n//" + "END:FOR_OUTPUT"

println "//" + "START:UPTO_OUTPUT"
0.upto(2) { print "$it "}
println "\n//" + "END:UPTO_OUTPUT"

println "//" + "START:TIMES_OUTPUT"
3.times { print "$it "}
println "\n//" + "END:TIMES_OUTPUT"

println "//" + "START:STEP_OUTPUT"
0.step(10, 2) { print "$it "}
println "\n//" + "END:STEP_OUTPUT"

println "//" + "START:REDUCED_OUTPUT"
3.times { print 'ho ' }
println 'Merry Groovy!'
println "//" + "END:REDUCED_OUTPUT"
