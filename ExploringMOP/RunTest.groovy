/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testAccessingObject() {
    evaluateScript "AccessingObject.groovy"
    replaceAllObjectIDsInResult()
    assertResultEquals '''
[104, 101, 108, 108, 111]
[104, 101, 108, 108, 111]
HELLO
HELLO
Properties of 'hello' are: 
class=class java.lang.String
bytes=[B@
empty=false
'''
  }

  void testMethodCallonPOJO() {
    def val = new Integer(3)
    
    assertEquals "3", val.toString()  
  }

  void testTestMethodInvocation() {
    result = "groovy TestMethodInvocation.groovy".execute().text
    result = result.replaceAll(/0\.[\d]*/, "0.000")
    assertResultEquals '''........
Time: 0.000

OK (8 tests)

'''
  }

  void testUsingMetaMethod() {
    evaluateScript 'UsingMetaMethod.groovy'
    assertResultMatchesFileContent 'UsingMetaMethod.output'
  }
}
