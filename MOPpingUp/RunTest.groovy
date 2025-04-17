/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testUsingExpando() {
    evaluateScript 'UsingExpando.groovy'
    assertResultContains '//' + 'START:DEFINE_OUTPUTcarA: {year=2012, miles=10}carB: {year=2012, miles=0}//' + 'END:DEFINE_OUTPUT//' + 'START:METHOD_OUTPUT10 miles driventurning...//' + 'END:METHOD_OUTPUT'
  }

  void testDynamicObjectsUsingExpando() {
    evaluateScript 'DynamicObjectsUsingExpando.groovy'
    assertResultContains 'miles year make  Avg. MPY42451 2003 Acura 8490.224031 2003 Chevy 4806.214233 2006 Honda 7116.542451 2003 Acura 8490.2'
  }

  void testDelegation() {
    evaluateScript 'Delegation.groovy'
    assertResultContains 'Scheduling ...intercepting call to simpleWork1...worker does work1 with spec fastworker does work1 with spec qualityintercepting call to simpleWork2...worker does work2worker does work2intercepting call to advancedWork1...Expert does work1 with spec fastExpert does work1 with spec qualityintercepting call to advancedWork2...Expert does work2 with scope prototype spec fastExpert does work2 with scope product spec qualityintercepting call to simpleWork3...groovy.lang.MissingMethodException: No signature of method: Manager.simpleWork3() is applicable for argument types: () values: []'
 }

  void testDelegationRefactored() {
    evaluateScript 'DelegationRefactored.groovy'
    assertResultContains 'Scheduling ...intercepting call to simpleWork1...worker does work1 with spec fastworker does work1 with spec qualityintercepting call to simpleWork2...worker does work2worker does work2intercepting call to advancedWork1...Expert does work1 with spec fastExpert does work1 with spec qualityintercepting call to advancedWork2...Expert does work2 with scope prototype spec fastExpert does work2 with scope product spec qualityintercepting call to isLeapYear...Is 2008 a leap year? trueintercepting call to simpleWork3...groovy.lang.MissingMethodException: No signature of method: Manager.simpleWork3() is applicable for argument types: () values: []'
 }
}
