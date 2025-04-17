/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testScriptClosuresParameterTypes() { 
    evaluateScript "ClosuresParameterTypes.groovy"
    assertResultMatchesFileContent 'ClosuresParameterTypes.output'
  }

  void testClosureWithTwoParameters() {
    evaluateScript "ClosureWithTwoParameters.groovy" 
    assertResultMatchesFileContent 'ClosureWithTwoParameters.output'
  }

  void testSimulate() {
    evaluateScript "Simulate.groovy"
    assertResultMatchesFileContent 'Simulate.output'
  }

  void testStrategy() {
    evaluateScript "Strategy.groovy"
    assertResultEquals '''Total of even numbers from 1 to 10 is 30
Total of odd numbers from 1 to 10 is 25
'''
  }

  void testQueryingClosures() {
    evaluateScript "QueryingClosures.groovy"
    assertResultMatchesFileContent 'QueryingClosures.output'
  }

  void testUsingEvenNumbers() {
    evaluateScript "UsingEvenNumbers.groovy"
    assertResultEquals '''Sum of even numbers from 1 to 10 is 30
Product of even numbers from 1 to 10 is 3840
Squares of even numbers from 1 to 10 is [4, 16, 36, 64, 100]
'''
  }

  void testMissingClosure() {
    evaluateScript "MissingClosure.groovy"
    assertResultMatchesFileContent 'MissingClosure.output'
  }

  void testCurrying() {
    evaluateScript "Currying.groovy"
    assertResultMatchesFileContent 'Currying.output'
  }

  void testThisOwnerDelegate() {
    evaluateScript "ThisOwnerDelegate.groovy"
    replaceAllObjectIDsInResult()
    assertResultEquals '''In First Closure:
class is ThisOwnerDelegate$_run_closure1
this is ThisOwnerDelegate@, super:groovy.lang.Script
owner is ThisOwnerDelegate@, super:groovy.lang.Script
delegate is ThisOwnerDelegate@, super:groovy.lang.Script
In Closure within the First Closure:
class is ThisOwnerDelegate$_run_closure1_closure2
this is ThisOwnerDelegate@, super:groovy.lang.Script
owner is ThisOwnerDelegate$_run_closure1@, super:groovy.lang.Closure
delegate is ThisOwnerDelegate$_run_closure1@, super:groovy.lang.Closure
'''
  }

  void testPickEven() {
    evaluateScript "PickEven.groovy"
    assertResultEquals '''2
4
6
8
10
2
4
6
8
10
2
4
6
8
10
Sum of even numbers from 1 to 10 is 30
Product of even numbers from 1 to 10 is 3840
'''
  }

  void testMethodRouting() {
    evaluateScript 'MethodRouting.groovy'
    assertResultMatchesFileContent 'MethodRouting.output'
  }

  void testCoroutine() {
    evaluateScript 'Coroutine.groovy'
    assertResultMatchesFileContent 'Coroutine.output'
  }

  void testResourceCleanup() {
    evaluateScript 'ResourceCleanup.groovy'
    assertResultMatchesFileContent 'ResourceCleanup.output'
  }

  void testFileClose() {
    def code = new File('FileClose.groovy').text
    def (withOutClose, withClose) = code.split('
    
    new GroovyShell().evaluate(withOutClose)
    assertEquals '', new File('output.txt').text

    def outputFile = new File('output.txt')
    outputFile.deleteOnExit()
    new GroovyShell().evaluate(withClose)
    assertEquals 'a', outputFile.text
    outputFile.deleteOnExit()
  }
  
  void testSimpleFactorial () {
    evaluateScript 'simpleFactorial.groovy'
    assertResultMatchesFileContent 'simpleFactorial.output'
  }

  void testTrampolineFactorial () {
    evaluateScript 'trampolineFactorial.groovy'
    assertResultMatchesFileContent 'trampolineFactorial.output'
  }

  void testTrampolineFactorialType () {
    evaluateScript 'trampolineFactorialType.groovy'
    assertResultMatchesFileContent 'trampolineFactorialType.output'
  }

  void testTrampoline() {
    evaluateScript 'trampoline.groovy'
    assertResultMatchesFileContent 'trampoline.output'
  }

  void testRodCutting() {
    evaluateScript 'rodCutting.groovy'
    assertResultContains '''
Max revenue for 27 is RevenueDetails(43, [5, 5, 5, 5, 5, 2])
Time taken'''
    assertResultContains '''
Max revenue for 27 is RevenueDetails(43, [5, 5, 5, 5, 5, 2])
Time taken'''
  }
}