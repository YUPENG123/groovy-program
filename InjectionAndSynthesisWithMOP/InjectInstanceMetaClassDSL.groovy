/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class Person {
  def play() { println 'playing...' }
}

def jack = new Person()
def paul = new Person()

jack.metaClass {
  sing = { ->
    'oh baby baby...'
  }
  dance = { ->
    'start the music...'
  }
}

println jack.sing()
println jack.dance()

jack.metaClass = null
try {
  jack.dance()
} catch(ex) {
  println ex.message
}