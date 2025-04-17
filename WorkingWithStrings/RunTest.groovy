/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testLiterals() {
    evaluateScript "Literals.groovy"
    result = result.replace('\n', '')
    assertResultContains '''//''' + '''START:LITERALOUTPUTHe said, "That is Groovy"//''' + '''END:LITERALOUTPUT//''' + '''START:CLASSOUTPUTjava.lang.String//''' + '''END:CLASSOUTPUT//''' + '''START:EXPRESSION_OUTPUTThe value is ${value}//''' + '''END:EXPRESSION_OUTPUT//''' + '''START:INDEX_OUTPUTlgroovy.lang.MissingMethodException: No signature of method: java.lang.String.putAt() is applicable for argument types: (java.lang.Integer, java.lang.String) values: [2, !]'''
    
  }

  void testExpressions() {
    evaluateScript "Expressions.groovy"
    assertResultMatchesFileContent 'Expressions.output'
  }

  void testLazyEval() {
    evaluateScript 'LazyEval.groovy'
    assertResultMatchesFileContent 'LazyEval.output'
  }

  void testMultilineStrings() {
    evaluateScript "MultilineStrings.groovy"
    
    assertResultMatchesFileContent 'MultilineStrings.output'
  }

  void testCreateXML() {
    evaluateScript "CreateXML.groovy"
    assertResultMatchesFileContent 'CreateXML.output'
  }

  void testStringConvenience() {
    evaluateScript "StringConvenience.groovy"
    assertResultMatchesFileContent 'StringConvenience.output'
  }

  void testRegEx() {
    evaluateScript "RegEx.groovy"
    assertResultMatchesFileContent 'RegEx.output'
  }
  
  void testStringRange() {
    evaluateScript 'StringRange.groovy'
    assertResultMatchesFileContent 'StringRange.output'
  }

  void testStringProcess() {
    evaluateScript 'StringProcess.groovy'
    assertResultMatchesFileContent 'StringProcess.output'
  }
}
