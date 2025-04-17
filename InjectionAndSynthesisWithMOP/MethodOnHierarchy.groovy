/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:REDUNDANT_OUTPUT"
daysFromNow = { ->
  Calendar today = Calendar.instance
  today.add(Calendar.DAY_OF_MONTH, (int)delegate)
  today.time
}
  
Integer.metaClass.daysFromNow = daysFromNow
Long.metaClass.daysFromNow = daysFromNow
  
println 5.daysFromNow()
println 5L.daysFromNow()
println "//" + "END:REDUNDANT_OUTPUT"

println "//" + "START:ONBASE_OUTPUT"
Number.metaClass.someMethod = { ->
  println "someMethod called"
}
  
2.someMethod()
2L.someMethod()
println "//" + "END:ONBASE_OUTPUT"
