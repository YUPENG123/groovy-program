/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  def output = '''Languages and authors
C++ authored by Stroustrup
Java authored by Gosling
Lisp authored by McCarthy
Modula-2 authored by Wirth
Oberon-2 authored by Wirth
Pascal authored by Wirth
Languages by Wirth:Modula-2, Oberon-2, Pascal
'''
  
  void testUsingDOMCategory() {
    evaluateScript 'UsingDOMCategory.groovy'
    assertResultEquals output
  }

  void testUsingXMLParser() {
    evaluateScript 'UsingXMLParser.groovy'
    assertResultEquals output
  }

  void testUsingXMLSlurper() {
    evaluateScript 'UsingXMLSlurper.groovy'
    assertResultEquals output
  }

  void testUsingXMLSlurperWithNS() {
    evaluateScript 'UsingXMLSlurperWithNS.groovy'
    assertResultEquals '''Languages: Java, Groovy, Erlang, English, German, French
Natural languages: English, German, French
'''
  }
}
