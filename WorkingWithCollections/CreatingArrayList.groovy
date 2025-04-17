/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:CREATEOUTPUT"
lst = [1, 3, 4, 1, 8, 9, 2, 6]
println lst
println lst.getClass().name
println "//" + "END:CREATEOUTPUT"

println "//" + "START:FETCH_ELEMENTSOUTPUT"
println lst[0]
println lst[lst.size() - 1]
println "//" + "END:FETCH_ELEMENTSOUTPUT"

println "//" + "START:INDEXOUTPUT"
println lst[-1]
println lst[-2]
println "//" + "END:INDEXOUTPUT"

println "//" + "START:RANGEOUTPUT"
println lst[2..5]
println "//" + "END:RANGEOUTPUT"

println "//" + "START:NEGATIVE_RANGEOUTPUT"
println lst[-6..-3]
println "//" + "END:NEGATIVE_RANGEOUTPUT"


println "//" + "START:MODRANGEOUTPUT"
subLst = lst[2..5]
println subLst.dump()
subLst[0] = 55
println "After  subLst[0]=55 lst = $lst"
println "//" + "END:MODRANGEOUTPUT"
