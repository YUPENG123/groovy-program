/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def emc = new ExpandoMetaClass(String)
emc.sing = { ->
  'oh baby baby...'
  }
emc.initialize()

def jack = new String()
def paul = new String()

jack.metaClass = emc

println jack.sing()

try {
  paul.sing()
} catch(ex) {
  println ex
}
