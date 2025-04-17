/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class TwoFileUserTest extends GroovyTestCase {
  void testUseFiles() {
    def testObj = new TwoFileUser()
    def testData = 'Multi Files'
    def fileMock = new groovy.mock.interceptor.MockFor(java.io.FileWriter)
    fileMock.demand.write() { assertEquals testData, it }
    fileMock.demand.write() { assertEquals testData.size(), it }
    fileMock.demand.close(2..2) {}
    fileMock.use {    
      testObj.useFiles(testData)
    }
  }
  
  void tearDown() {
    new File('output1.txt').delete()
    new File('output2.txt').delete()
  }
}

class TwoFileUser {
  def useFiles(str) {
    def file1 = new java.io.FileWriter("output1.txt")
    def file2 = new java.io.FileWriter("output2.txt")
    file1.write str
    file2.write str.size()
    file1.close()
    file2.close()
  }
}
