/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testInterceptingCalls() {
    evaluateScript "InterceptingCalls.groovy"
    assertResultContains 'Call to start intercepted... running filter... check called...'
    assertResultContains 'start called...'
    assertResultContains 'Call to drive intercepted... running filter... check called...'
    assertResultContains 'drive called...'
    assertResultContains 'Call to check intercepted... check called...'
    assertResultContains 'Call to speed intercepted... running filter... check called...'
    assertResultContains 'groovy.lang.MissingMethodException: '
    assertResultContains 'No signature of method: Car.speed() '
    assertResultContains 'is applicable for argument types: () values: []'
  }

  void testInterceptingCallsUsingMetaClass() {
    evaluateScript "InterceptingCallsUsingMetaClass.groovy"
    assertResultContains 'Call to start intercepted... running filter... check called...'
    assertResultContains 'start called...'
    assertResultContains 'Call to drive intercepted... running filter... check called...'
    assertResultContains 'drive called...'
    assertResultContains 'Call to check intercepted... check called...'
    assertResultContains 'Call to speed intercepted... running filter... check called...'
    assertResultContains 'groovy.lang.MissingMethodException: '
    assertResultContains 'No signature of method: Car.speed() '
    assertResultContains 'is applicable for argument types: () values: []'
  }

  void testInterceptInteger() {
    evaluateScript "InterceptInteger.groovy"
    assertResultContains 'Call to floatValue intercepted on 5... '
    assertResultContains 'running pre-filter...'
    assertResultContains 'running post-filter...'
    assertResultContains '5.0'
    assertResultContains 'Call to intValue intercepted on 5...'
    assertResultContains 'running pre-filter...'
    assertResultContains 'running post-filter...'
    assertResultContains '5'
    assertResultContains 'Call to empty intercepted on 5...'
    assertResultContains 'groovy.lang.MissingMethodException: '
    assertResultContains 'No signature of method: java.lang.Integer.empty()'
    assertResultContains 'is applicable for argument types: () values: []'
  }

  void testExamineMetaClass() {
    evaluateScript 'ExamineMetaClass.groovy'
    assertResultMatchesFileContent 'ExamineMetaClass.output'
  }

  void testMetaClassUsed() {
    result = 'groovy MetaClassUsed.groovy'.execute().text
    assertResultMatchesFileContent 'MetaClassUsed.output'
  }
}
