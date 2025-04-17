/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
import com.agiledeveloper.CodeWithHeavierDependencies

class TestUsingExpandoMetaClass extends GroovyTestCase {
  void testMyMethod() {
    def result
    def emc = new ExpandoMetaClass(CodeWithHeavierDependencies, true)
    emc.println = { text -> result = text }  
    emc.someAction = { -> 25 }  
    emc.initialize()
      
    def testObj = new CodeWithHeavierDependencies()
    testObj.metaClass = emc

    testObj.myMethod()
    
    assertEquals 35, result    
  }
}
