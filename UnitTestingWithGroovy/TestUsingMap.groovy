/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
import com.agiledeveloper.ClassWithDependency

class TestUsingMap extends GroovyTestCase {
  void testMethodA() {
    def text = ''
    def fileMock = [write : { text = it }]
    
    def testObj = new ClassWithDependency()
    testObj.methodA(1, fileMock)
    
    assertEquals "The value is 1.", text
  }
}
