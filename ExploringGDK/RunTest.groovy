/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testObjectExtensions() { 
    evaluateScript 'ObjectExtensions.groovy'
    replaceAllObjectIDsInResult()
    assertResultEquals '''hello
<java.lang.String@ value=hello offset=0 count=5 hash=99162322>
'''
  }

  void testIndirectProperty() {
    evaluateScript 'IndirectProperty.groovy'
    assertResultMatchesFileContent 'IndirectProperty.output'
  }

  void testProcessParameters() {
    evaluateScript 'ProcessParameters.groovy'
    assertResultMatchesFileContent 'ProcessParameters.output'
  }

  void testThreadStart() {
    result =  'groovy ThreadStart.groovy'.execute().text
    result = result.replaceAll(/\d,/, 'x,')
    assertResultEquals '''Main Thread is Thread[main,x,main]. Daemon? false
Started Thread is Thread[Thread-x,x,main]. Daemon? false
Started Daemon Thread is Thread[Thread-x,x,main]. Daemon? true
Finished Started
'''
  }

  void testUsingProcess() {
    evaluateScript 'UsingProcess.groovy'
    result = result.trim()
    assertResultEquals '2       6      36'
  }

  void testIndirectMethod() {
    evaluateScript 'IndirectMethod.groovy'
    assertResultMatchesFileContent 'IndirectMethod.output'
  }

  void testIdentity() {
    evaluateScript 'Identity.groovy'
    replaceAllObjectIDsInResult()
    assertResultEquals '''4
true
4
true
this is Identity@,
owner is Identity@,
delegate is [1, 2, 3, 4].
'''
  }

  void testReadFile() {
    result = 'groovy ReadFile.groovy'.execute().text
  
    assertResultEquals "//" + '''START:READ_OUTPUT
"I went to the woods because I wished to live deliberately,
to front only the essential facts of life, and see if I could
not learn what it had to teach, and not, when I came to die,
to discover that I had not lived..."
- Henry David Thoreau

//''' + '''END:READ_OUTPUT
//''' + '''START:READLINE_OUTPUT
"I went to the woods because I wished to live deliberately,
to front only the essential facts of life, and see if I could
not learn what it had to teach, and not, when I came to die,
to discover that I had not lived..."
- Henry David Thoreau
//''' + '''END:READLINE_OUTPUT
//''' + '''START:FILTERLINE_OUTPUT
to front only the essential facts of life, and see if I could

//''' + '''END:FILTERLINE_OUTPUT
'''
  }

  void testShiftOperator() {
    evaluateScript 'ShiftOperator.groovy'
    def file = new File('output.txt')
    assertEquals 'some data...', file.text
    file.deleteOnExit()
  }

  void testArray() {
    evaluateScript 'Array.groovy'
    assertResultEquals '[3, 4, 5]' + '\n'
  }

  void testSleep() {
    evaluateScript 'Sleep.groovy'
    result = result.replaceAll(/\d\.\d* seconds/, "x.x seconds")
    assertResultEquals '''
Thread started
Let's interrupt that thread
Thread done in x.x seconds
Thread started
Interrupted... java.lang.InterruptedException: sleep interrupted
Thread done in x.x seconds
Thread started
Interrupted... java.lang.InterruptedException: sleep interrupted
Thread done in x.x seconds
'''
    }
    
    void testReadFileJava() {
      "javac ReadFile.java".execute().text
      new File('ReadFile.class').deleteOnExit()
      result = "java ReadFile".execute().text
      assertResultMatchesFileContent 'ReadFileJava.output'
    }
}
