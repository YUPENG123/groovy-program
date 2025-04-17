/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:TOSSN_OUTPUT"
class StringUtil {
  def static toSSN(self) { //write toSSN(String self) to restrict to String 
    if (self.size() == 9) {
      "${self[0..2]}-${self[3..4]}-${self[5..8]}"
    }
  }
}
use(StringUtil) {
  println "123456789".toSSN()
  println new StringBuilder("987654321").toSSN()
}

try {
  println "123456789".toSSN()
} catch(MissingMethodException ex) {
  println ex.message
}
println "//" + "END:TOSSN_OUTPUT"

println "//" + "START:TOSSN_ANNOTATED_OUTPUT"
@Category(String)
class StringUtilAnnotated {
  def toSSN() {
    if (size() == 9) {
      "${this[0..2]}-${this[3..4]}-${this[5..8]}"
    }
  }
}
use(StringUtilAnnotated) {
  println "123456789".toSSN()
}
println "//" + "END:TOSSN_ANNOTATED_OUTPUT"

@Category(Object)
class StringUtilAnnotated2 {
  def toSSN() {
    if (size() == 9) {
      "${this[0..2]}-${this[3..4]}-${this[5..8]}"
    }
  }
}

use(StringUtilAnnotated2) {
  println "123456789".toSSN()
  println new StringBuilder("987654321").toSSN()
}

println "//" + "START:EXTRACT_OUTPUT"
class FindUtil {
  def static extractOnly(String self, closure) {
    def result = ''
    self.each {
      if (closure(it)) { result += it }
    }
    result
  }
}
use(FindUtil) {
  println "121254123".extractOnly { it == '4' || it == '5' }
}

println "//" + "END:EXTRACT_OUTPUT"

println "//" + "START:MULTI_OUTPUT"
use(StringUtil, FindUtil) {
  str = "123487651"
  println str.toSSN()
  println str.extractOnly { it == '8' || it == '1' }
}
println "//" + "END:MULTI_OUTPUT"

println "//" + "START:PAD_OUTPUT"
class Helper {
  def static toString(String self) {
    def method = self.metaClass.methods.find { it.name == 'toString' }
    '!!' + method.invoke(self, null) + '!!'
  }
}

use(Helper) { 
  println 'hello'.toString() 
}
println "//" + "END:PAD_OUTPUT"
