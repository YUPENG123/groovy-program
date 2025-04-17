/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:OPTIONAL_OUTPUT"
def log(x, base=10) {
  Math.log(x) / Math.log(base)
}

println log(1024)
println log(1024, 10)
println log(1024, 2)
println "//" + "END:OPTIONAL_OUTPUT"

println "//" + "START:ARRAY_OUTPUT"
def task(name, String[] details) {
  println "$name - $details"
}

task 'Call', '123-456-7890'
task 'Call', '123-456-7890', '231-546-0987'
task 'Check Mail'
println "//" + "END:ARRAY_OUTPUT"
