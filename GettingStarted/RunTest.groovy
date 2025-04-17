/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testRunGroovysh() {
    result = "groovy RunGroovysh.groovy".execute().text
    assertResultContains "Groovy Shell (2.1.1, JVM: 1.7.0_04-ea)"
    assertResultContains "groovy:000> println 'Hello World!'"
    assertResultContains "Hello World!"
    assertResultContains "===> null"
    assertResultContains "groovy:000> exit"
  }

  void testGroovyc() {
    "groovyc Hello.groovy".execute().text
    def classFile = new File('Hello.class')
    assertTrue classFile.exists()
    classFile.deleteOnExit()

    result = "javap -c Hello".execute().text
    assertTrue (result.startsWith('''Compiled from "Hello.groovy"
public class Hello extends groovy.lang.Script'''))
  }

  void testStaticMethodThis() {
   result = Foo.getIt().toString()
   assertResultEquals '''class Foo'''
  }

  void testNoInnerClass() {
    result = "groovy NoInnerClass.groovy".execute().err.text
    assertResultContains 'Class definition not expected here'
  }
  
  void testCodeWithMainAndTest() {
    result = "groovy CodeWithMainAndTest.groovy".execute().text
    assertResultEquals 'main called' + '\n'
  }
  
    void testCodeWithMainAndRunnable() {
      result = "groovy CodeWithMainAndRunnable.groovy".execute().text
      assertResultEquals 'main called' + '\n'
    }
}
