/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:INJECT_OUTPUT"
class Person {
  def play() { println 'playing...' }
}
def emc = new ExpandoMetaClass(Person)
emc.sing = { ->
  'oh baby baby...'
}
emc.initialize()

def jack = new Person()
def paul = new Person()

jack.metaClass = emc

println jack.sing()

try {
  paul.sing()
} catch(ex) {
  println ex
}
println "//" + "END:INJECT_OUTPUT"

println "//" + "START:REMOVE_OUTPUT"
jack.metaClass = null
try {
  jack.play()
  jack.sing()
} catch(ex) {
  println ex
}
println "//" + "END:REMOVE_OUTPUT"
