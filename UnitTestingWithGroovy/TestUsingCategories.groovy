/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
import com.agiledeveloper.CodeWithHeavierDependencies

class TestUsingCategories extends GroovyTestCase {
  void testMyMethod() {
    def testObj = new CodeWithHeavierDependencies()

    use(MockHelper) {
      testObj.myMethod()
    
      assertEquals 35, MockHelper.result    
    }
  }
}

class MockHelper {
  def static result
  
  def static println(self, text) { result = text }
  
  def static someAction(CodeWithHeavierDependencies self) { 25 }
}
