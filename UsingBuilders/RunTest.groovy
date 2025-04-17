/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testBuildXML() {
    evaluateScript "BuildXML.groovy"
    assertResultEquals '''<languages>
  <language name='C++'>
    <author>Stroustrup</author>
  </language>
  <language name='Java'>
    <author>Gosling</author>
  </language>
  <language name='Lisp'>
    <author>McCarthy</author>
  </language>
</languages>
'''
  }

  void testUsingInfoBuilder() {
    evaluateScript "UsingInfoBuilder.groovy"
    assertResultContains '''James knows C++, Java, GroovySara knows Perl, Java, RubyNick knows Groovy, Perl, RubyC++ is used by JamesJava is used by James, SaraGroovy is used by James, NickPerl is used by Sara, NickRuby is used by Sara, Nick'''
  }

  void testUsingSkillBuilder() {
    evaluateScript "UsingSkillBuilder.groovy"
    assertResultContains '''employee and languagesJames Infrastructure  knows C++, Java, GroovySara Simulation  knows Perl, Java, RubyNick Automation  knows Groovy, Perl, Rubylanguages and employeeC++ usedby James Infrastructure Java usedby James Infrastructure , Sara Simulation Groovy usedby James Infrastructure , Nick Automation Perl usedby Sara Simulation , Nick Automation Ruby usedby Sara Simulation , Nick Automation '''
  }

  void testBuildSwing() {
    def showCalled = false
    def theFrame = null
  
    javax.swing.JFrame.metaClass.show = { ->
      theFrame = delegate
      delegate.class.getMethod('show').invoke(delegate, null)
      showCalled = true
    }
    
    theFrame = new GroovyShell().evaluate(new File('BuildSwing.groovy').text + "; frame")
    assertTrue showCalled
    theFrame.dispose()
  }

  void testUsingTodoBuilder() {
    evaluateScript 'UsingTodoBuilder.groovy'
    assertResultEquals '''To-Do:
 - Prepare Vacation [start: 02/15 end: 02/22]
  x Reserve Flight [on: 01/01]
  - Reserve Hotel [on: 01/02]
  - Reserve Car [on: 01/02]
 - Buy New Mac
  - Install QuickSilver
  - Install TextMate
  - Install Groovy
   - Run all tests

'''
  }

  void testUsingTodoBuilderWithSupport() {
    evaluateScript 'UsingTodoBuilderWithSupport.groovy'
    assertResultEquals '''To-Do:
 - Prepare Vacation [start: 02/15 end: 02/22]
  x Reserve Flight [on: 01/01]
  - Reserve Hotel [on: 01/02]
  - Reserve Car [on: 01/02]
 - Buy New Mac
  - Install QuickSilver
  - Install TextMate
  - Install Groovy
   - Run all tests

'''
  }

  void testUsingFactoryBuilderSupport() {
    result = 'groovy UsingFactoryBuilderSupport.groovy'.execute().text
    assertResultEquals'''//''' + '''START:USE_OUTPUT
Robot iRobot operating...
move distance... 20
turn left... 90 degrees
move distance... 50
//''' + '''END:USE_OUTPUT
//''' + '''START:USE_INVALID_OUTPUT
java.lang.RuntimeException: 'forward' doesn't support nesting.
//''' + '''END:USE_INVALID_OUTPUT
'''
  }

  void testUsingXMLBuilder() {
    result =  'groovy UsingXMLBuilder.groovy'.execute().text
    assertResultEquals """<languages>
  <language name='C++'>
    <author>Stroustrup</author>
  </language>
  <language name='Java'>
    <author>Gosling</author>
  </language>
  <language name='Lisp'>
    <author>McCarthy</author>
  </language>
</languages>"""
  }

    void testUsingJSONBuilder() {
      evaluateScript "BuildJSON.groovy"
      assertResultEquals '''
{"first":"John","last":"Smith","tools":{"script":"Groovy","test":"Spock"},"sigs":["Java","Groovy"]}
{"firstName":"John","lastName":"Smith","special interest groups":["Java","Groovy"],"preferred tools":{"numberOfTools":2,"tools":{"script":"Groovy","test":"Spock"}}}
'''
    }
  
  void testBuildUsingStreamingBuilder() {
    result = 'groovy BuildUsingStreamingBuilder.groovy'.execute().text
    assertResultEquals """<?xml version='1.0'?>
<languages xmlns:computer='Computer'><!--Created using StreamingMarkupBuilder--><computer:language name='C++'><author>Stroustrup</author></computer:language><computer:language name='Java'><author>Gosling</author></computer:language><computer:language name='Lisp'><author>McCarthy</author></computer:language></languages>
"""
  }
  
  void testParseJSON() {
    evaluateScript "ParseJSON.groovy"
    assertResultEquals '''John Smith is interested in Java, Groovy
'''
  }
}
