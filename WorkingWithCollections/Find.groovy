/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:FINDOUTPUT"
lst = [4, 3, 1, 2, 4, 1, 8, 9, 2, 6]

println lst.find { it == 2 }
println "//" + "END:FINDOUTPUT"

println "//" + "START:FIND_GREATER_THAN_4OUTPUT"
println lst.find { it > 4 }
println "//" + "END:FIND_GREATER_THAN_4OUTPUT"

println "//" + "START:FIND_ALLOUTPUT"
println lst.findAll { it == 2 }
println "//" + "END:FIND_ALLOUTPUT"

println "//" + "START:FIND_ALL_GREATER_THAN_4OUTPUT"
println lst.findAll { it > 4 }
println "//" + "END:FIND_ALL_GREATER_THAN_4OUTPUT"
