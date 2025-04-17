/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  def groovyJar = "ls /opt/groovy/current/embeddable".execute().text.split('\n').collect {"/opt/groovy/current/embeddable/$it" }.join(":")
  
  void testRunGreet() {
    evaluateScript 'RunGreet.groovy'
    assertResultEquals '''Groovy Rocks!
'''
  }

  void testRunUseCar() {
    evaluateScript 'RunUseCar.groovy'
    assertResultMatchesFileContent 'RunUseCar.output'
  }

  void testRunUseJavaClass() {
    evaluateScript 'RunUseJavaClass.groovy'
    assertResultMatchesFileContent 'RunUseJavaClass.output'
  }  

  void testUseGreetJava() {
    "javac -d . GreetJava.java".execute().text
    new File('com/agiledeveloper/GreetJava.class').deleteOnExit()
    result = "groovy UseGreetJava".execute().text
    assertResultMatchesFileContent 'UseGreetJava.output'
  }

  void testScript1() {
    evaluateScript 'Script1.groovy'
    assertResultMatchesFileContent 'Script1.output'
  }

  void testScript2() {
    evaluateScript 'Script2.groovy'
    assertResultMatchesFileContent 'Script2.output'
  }

  void testScript2a() {
    evaluateScript 'Script2a.groovy'
    assertResultMatchesFileContent 'Script2a.output'
  }

  void testScript3() {
    evaluateScript 'Script3.groovy'
    assertResultMatchesFileContent 'Script3.output'
  }

  void testUseAGroovyClass() {
    "groovyc -j UseAGroovyClass.java UseAGroovyClass2.java AGroovyClass.groovy".execute().text
    new File('AGroovyClass.class').deleteOnExit()
    new File('UseAGroovyClass.class').deleteOnExit()
    new File('UseAGroovyClass2.class').deleteOnExit()
    new File('UseAGroovyClass$1.class').deleteOnExit()
    new File('UseAGroovyClass2$1.class').deleteOnExit()
    
    result = "java -classpath $groovyJar:. UseAGroovyClass".execute().text
    assertResultMatchesFileContent 'UseAGroovyClass1.output'

    result = "java -classpath /opt/groovy/current/embeddable/$groovyJar:. UseAGroovyClass2".execute().text
    assertResultMatchesFileContent 'UseAGroovyClass2.output'
  }

  void testCallDynamicMethod() {
    "groovyc -j CallDynamicMethod.java DynamicGroovyClass.groovy".execute().text
    new File('CallDynamicMethod.class').deleteOnExit()
    new File('DynamicGroovyClass.class').deleteOnExit()
            
    result = "java -classpath $groovyJar:. CallDynamicMethod".execute().text
    assertResultMatchesFileContent 'CallDynamicMethod.output'
  }
}
