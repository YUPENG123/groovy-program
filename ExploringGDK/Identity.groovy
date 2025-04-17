/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
lst = [1, 2]
lst.add(3)
lst.add(4)
println lst.size()
println lst.contains(2)

println "//" + "START:CONTEXTOUTPUT"
lst = [1, 2]
lst.with {
  add(3)
  add(4)
  println size()
  println contains(2)
}
println "//" + "END:CONTEXTOUTPUT"

println "//" + "START:THIS_AND_DELEGATE_OUTPUT"
lst.with {
  println "this is ${this},"
  println "owner is ${owner},"
  println "delegate is ${delegate}."
}
println "//" + "END:THIS_AND_DELEGATE_OUTPUT"
