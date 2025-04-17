/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testGroovyTypes() {
    evaluateScript "GroovyTypes.groovy"
    assertResultMatchesFileContent 'GroovyTypes.output'
  }

  void testTakeHelp() {
    evaluateScript 'TakeHelp.groovy'
    assertResultMatchesFileContent 'TakeHelp.output'
  }

  void tearDown() {
    def file = ['Employee', 'Executive', 'GiveRaiseJava']
    file.each {
      def classFile = new File("${it}.class")
      classFile.deleteOnExit()
    }
  }
  
  void testGiveRaiseJava() {
    "javac GiveRaiseJava.java".execute().text
    result = "java GiveRaiseJava".execute().text
    assertResultMatchesFileContent 'GiveRaiseJava.output'
  }

  void testGiveRaiseGroovy() {
    "javac Employee.java".execute().text
    "javac Executive.java".execute().text
    result = "groovy GiveRaise".execute().text
    assertResultMatchesFileContent 'GiveRaise.output'
  }

  void testUsingList() {
    "javac UsingList.java".execute().text 
    new File('UsingList.class').deleteOnExit()
    def process = "java UsingList".execute()
    
    def error = process.err.text
    result = process.text + error
    assertResultMatchesFileContent 'UsingList.output'
  }

  void testUsingCollection() {
     "javac UsingCollection.java".execute().text
     result = "java UsingCollection".execute().text
     assertResultEquals '''Added three items, removed two, so 1 item to remain.
Number of elements is: 2
Number of elements is: 2
'''
     new File('UsingCollection.class').deleteOnExit()
  }
 
  void testUsingCollectionGroovy() {
     result = 'groovy RunUsingCollectionGroovy.groovy'.execute().text
     assertResultMatchesFileContent 'RunUsingCollectionGroovy.output'
  }

  void testUsingCollectionJava() {
     result = 'groovy RunUsingCollection.groovy'.execute().text
     assertResultMatchesFileContent 'RunUsingCollection.output'
  }

  void testNoCompilertimeCheck() {
    evaluateScript "NoCompiletimeCheck.groovy"
    assertResultMatchesFileContent 'NoCompiletimeCheck.output'
  }
}
