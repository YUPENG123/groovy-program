/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class Test extends GroovyTestCase {
  def testObj = new Sample()

  void testSomeWriter() {
    def fileMock = new groovy.mock.interceptor.MockFor(java.io.FileWriter)
    fileMock.demand.write(3..3) {} // If you want to say upto 3 times, use 0..3
    fileMock.demand.flush {}
    fileMock.demand.getEncoding { return "whatever" } // return is optional
    fileMock.demand.write { assertEquals 'whatever', it.toString() }
    fileMock.demand.close {}

    fileMock.use {
      testObj.someWriter()
    }  
  }

  void testSomeWriter2() {
    def fileMock = new groovy.mock.interceptor.MockFor(java.io.FileWriter)
    def params = ['one', 'two', 3]
    def index = 0
    fileMock.demand.write(3..3) { assert it == params[index++] } 
      // If you want to say upto 3 times, use 0..3
    fileMock.demand.flush {}
    fileMock.demand.getEncoding { return "whatever" } // return is optional
    fileMock.demand.write { assertEquals 'whatever', it.toString() }
    fileMock.demand.close {}

    fileMock.use {
      testObj.someWriter()
    }  
  }
}

class Sample {
  def someWriter() {
    def file = new FileWriter('output.txt')
    file.write("one")
    file.write("two")
    file.write(3)
    file.flush()
    file.write(file.getEncoding())
    file.close()
  }  
}
