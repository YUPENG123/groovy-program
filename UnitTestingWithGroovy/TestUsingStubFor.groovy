/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
import com.agiledeveloper.ClassWithDependency

class TestUsingStubFor extends GroovyTestCase {
  void testMethodB() {
    def testObj = new ClassWithDependency()

    def fileMock = new groovy.mock.interceptor.StubFor(java.io.FileWriter)
    def text
    fileMock.demand.write { text = it.toString() }
    fileMock.demand.close {}

    fileMock.use { 
      testObj.methodB(1)
    }
  
    assertEquals "The value is 1.", text
  }
}
