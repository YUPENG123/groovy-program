/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
import com.agiledeveloper.CodeWithHeavierDependencies

class TestCodeWithHeavierDependenciesUsingOverriding extends GroovyTestCase {
  void testMyMethod() {
    def testObj = new CodeWithHeavierDependenciesExt()
    
    testObj.myMethod()
    
    assertEquals 35, testObj.result
  }
}

class CodeWithHeavierDependenciesExt extends CodeWithHeavierDependencies {
  def result
  
  int someAction() { 25 }
  
  def println(text) { result = text }
}
