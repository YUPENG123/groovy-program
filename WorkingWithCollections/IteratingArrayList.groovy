/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:PRINTOUTPUT"
lst = [1, 3, 4, 1, 8, 9, 2, 6]

lst.each { println it }
println "//" + "END:PRINTOUTPUT"

println "//" + "START:SUMOUTPUT"
total = 0
lst.each { total += it }
println "Total is $total"
println "//" + "END:SUMOUTPUT"

println "//" + "START:DOUBLEOUTPUT"
doubled = []
lst.each { doubled << it * 2 }

println doubled
println "//" + "END:DOUBLEOUTPUT"

println "//" + "START:COLLECTOUTPUT"
println lst.collect { it * 2 }
println "//" + "END:COLLECTOUTPUT"
