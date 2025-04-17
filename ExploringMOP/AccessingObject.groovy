/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:ACCESSOUTPUT"
def printInfo(obj) {
  // Assume user entered these values from standard input
  usrRequestedProperty = 'bytes'
  usrRequestedMethod = 'toUpperCase'
  
  println obj[usrRequestedProperty]
  //or
  println obj."$usrRequestedProperty"

  println obj."$usrRequestedMethod"()
  //or
  println obj.invokeMethod(usrRequestedMethod, null)  
}

printInfo('hello')
println "//" + "END:ACCESSOUTPUT"

println "//" + "START:LISTOUTPUT"
println "Properties of 'hello' are: "
'hello'.properties.each { println it }
println "//" + "END:LISTOUTPUT"
