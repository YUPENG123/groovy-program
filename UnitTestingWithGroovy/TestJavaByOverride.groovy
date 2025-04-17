/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
import com.agiledeveloper.JavaCodeWithHeavierDependencies

class TestCodeWithHeavierDependenciesUsingOverriding extends GroovyTestCase {
  void testMyMethod() {
    def testObj = new ExtendedJavaCode()

    def originalPrintStream = System.out
    def printMock = new PrintMock()    
    System.out = printMock
    
    try {
      testObj.myMethod()
    } finally { System.out = originalPrintStream }
    
    assertEquals 35, printMock.result
  }
}

class ExtendedJavaCode extends JavaCodeWithHeavierDependencies {
  int someAction() { 25 }
}

class PrintMock extends PrintStream {
  PrintMock() { super(System.out) }
  
  def result
  
  void println(int text) { result = text }
}
