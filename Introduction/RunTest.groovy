/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testDynamic() {
    evaluateScript 'Dynamic.groovy'
    assertResultEquals """84000.00
"""
  }

  void testList() {
    evaluateScript 'List.groovy'
    assertResultEquals '''Groovy is hip
class java.util.ArrayList
'''
  }

  void testLoop() {
    evaluateScript 'Loop.groovy'
    assertResultEquals ''
  }

  void testPalindrome() {
    evaluateScript 'Palindrome.groovy'
    assertResultEquals '''tattarrattat is a palindrome? true
Groovy is a palindrome? false
'''
  }

  void testUseGroovyClass() {
    evaluateScript 'UseGroovyClass.groovy'
    assertResultEquals '''class groovy.util.XmlParser
class java.lang.Object
'''
  }
}
