/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void withCompiledJavaCode(block) {
    "javac -d . CardType.java".execute().text
    "javac -d . Crust.java".execute().text
    "javac -d . Size.java".execute().text
    "javac -d . PizzaShop.java".execute().text
    "javac -d . OrderPizza.java".execute().text
    try {
      block()
    } finally {
      "/bin/rm -rf com".execute().text
    }
  }
  
  void testOrderPizza() {
    withCompiledJavaCode {
          result = "groovy OrderPizza.groovy".execute().text
          assertResultContains 'Pizza will arrive in 25 minutes'
    }
  }

  void testOrderPizza2() {
    withCompiledJavaCode {    
      result = "groovy OrderPizza2.groovy".execute().text
      assertResultContains 'Pizza will arrive in 25 minutes'
    }
  }

    void testClosureHelp() {
      withCompiledJavaCode {
        result = "groovy ClosureHelp.groovy".execute().text
        assertResultContains 'Pizza will arrive in 25 minutes'
      }
    }
  
  void testFluentLoops() {
    evaluateScript "FluentLoops.groovy"
    assertResultContains '''0123456789012345678901234567890123456789'''
  }

  void testGroovyPizzaOrderProcess() {
    evaluateScript 'GroovyPizzaOrderProcess.groovy'
    assertResultContains '''Validation and processing performed here for order received:size -> largecrust -> thintopping -> Olives, Onions, Bell Pepperaddress -> 101 Main St., ...card -> Visa, 1234-1234-1234-1234'''
  }

  void testDSLUsingCategory() {
    evaluateScript 'DSLUsingCategory.groovy'
    replaceDateInResultWithFormat()
    assertResultDate()
  }

  void testDSLUsingCategory2() {
    evaluateScript 'DSLUsingCategory2.groovy'
    replaceDateInResultWithFormat()
    assertResultDate()
  }

  void testDSLUsingExpandoMetaClass() {
    result = "groovy DSLUsingExpandoMetaClass.groovy".execute().text
    replaceDateInResultWithFormat()
    assertResultContains '''DAY MON DY HH:MM:SS TZN YYYY'''
  }

  void testTotal() {
    result = 'groovy Total.groovy'.execute().text
    assertResultEquals '''
Total is 14
groovy.lang.MissingPropertyException: No such property: total for class: Total
'''
  }

  void testTotal2() {
    evaluateScript 'Total2.groovy'
    assertResultEquals '''Total is 14
Total is 0
'''
  }

  void testCommandChain() {
    evaluateScript 'CommandChain.groovy'
    assertResultMatchesFileContent 'CommandChain.output'
  }
}
