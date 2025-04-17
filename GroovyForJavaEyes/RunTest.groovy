/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testStatic() {
    evaluateScript 'Static.groovy'
    assertResultEquals ''
  }

  void testEase() {
    evaluateScript 'Ease.groovy'
    assertResultMatchesFileContent 'Ease.output'
  }

  void testOptionalParameters() {
    evaluateScript 'OptionalParameters.groovy'
    assertResultMatchesFileContent 'OptionalParameters.output'
  }

  void testBool() {
    evaluateScript 'Bool.groovy'
    assertResultMatchesFileContent 'Bool.output'
  }

  void testExceptionHandling() {
    evaluateScript 'ExceptionHandling.groovy'
    assertResultEquals '''Oops: java.io.FileNotFoundException: nonexistentfile (No such file or directory)
Oops: java.io.FileNotFoundException: nonexistentfile (No such file or directory)
'''
  }
  
  void testExecute() {
    evaluateScript "Execute.groovy"
    assertResultStartsWith "//" + "START:SVN_OUTPUT"
    assertResultContains "total"
    assertResultContains "Groovy Version"
  }

  void testExecuteGroovyVersion() {
    evaluateScript "Execute.groovy"
    assertResultContains "Groovy Version: 2.1.1 JVM: 1.7.0_04-ea Vendor: Oracle Corporation OS: Mac OS X"
  }

  void testGreetings() {
    evaluateScript "Greetings"
    assertResultMatchesFileContent 'Greetings.output'
  }

  void testLightGreetings() {
    evaluateScript "LightGreetings.groovy"
    assertResultEquals 'ho ho ho Merry Groovy!' + '\n'
  }

  void testLighterGreetings() {
    evaluateScript "LighterGreetings.groovy"
    assertResultEquals 'ho ho ho Merry Groovy!' + '\n'
  }

  void testWaysToLoop() {
    evaluateScript "WaysToLoop.groovy"
    assertResultMatchesFileContent 'WaysToLoop.output'
  }

  void testGroovyCar() {
    evaluateScript 'GroovyCar.groovy'
    assertResultMatchesFileContent 'GroovyCar.output'
  }

  void testGroovyCar2() {
    evaluateScript 'GroovyCar2.groovy'
    assertResultMatchesFileContent 'GroovyCar2.output'
  }
  
  void testPrivate() {
    result = "groovy Private.groovy".execute().err.text
    assertResultMatchesFileContent 'Private.output'
  }

  void testUsingProperties() {
    evaluateScript 'UsingProperties.groovy'
    assertResultEquals ''
  }

  void testNamedParameters() {
    evaluateScript 'NamedParameters.groovy'
    assertResultMatchesFileContent 'NamedParameters.output'
  }

  void testMultipleAssignments() {
    evaluateScript 'MultipleAssignments.groovy'
    assertResultMatchesFileContent 'MultipleAssignments.output'
  }

  void testMapParameterCheck() {
    def process = "groovy MapParameterCheck.groovy".execute()
    def error = process.err.text
    result = process.text + error
    assertResultMatchesFileContent 'MapParameterCheck.output'
  }

  void testSwing() { 
    def showCalled = false
    
    def theFrame = null
    javax.swing.JFrame.metaClass.show = { ->
      theFrame = delegate
      delegate.class.getMethod('show').invoke(delegate, null)
      showCalled = true
    }

    theFrame = runInGroovyShell('Swing.groovy')
    assertTrue showCalled
    theFrame.dispose()
  } 
  
  void testNoTypeCheck() { 
    result = "groovyc NoTypeCheck.groovy".execute().err.text
    assertResultEquals ''
    def classFile = new File('NoTypeCheck.class')
    assertTrue classFile.exists()
    classFile.deleteOnExit()

    evaluateScript 'NoTypeCheck.groovy'
    assertResultContains '
    assertResultContains 'org.codehaus.groovy.runtime.typehandling.GroovyCastException:'
    assertResultContains "Cannot cast object 'hello' with class 'java.lang.String'"
    assertResultContains "to class 'java.lang.Integer'"
    assertResultContains '
    assertResultContains '
    assertResultContains 'groovy.lang.MissingMethodException:'
    assertResultContains 'No signature of method: java.lang.Integer.blah() is applicable'
    assertResultContains 'for argument types: () values: []'
    assertResultContains 'Possible solutions:'
  }

  void testOperatorOverloading() { 
    evaluateScript 'OperatorOverloading.groovy'
    assertResultMatchesFileContent 'OperatorOverloading.output'
  } 

  void testEquals() {
    evaluateScript 'Equals.groovy'
    assertResultMatchesFileContent 'Equals.output'    
  }

  void testWhatsEquals() {
    evaluateScript 'WhatsEquals.groovy'
    assertResultMatchesFileContent 'WhatsEquals.output'
  }

  void testBlock() { 
    shouldFail { new GroovyShell().evaluate(new File('Block.java')) }
  } 

  void testSemiColon() { 
    result = "groovy SemiColon.groovy".execute().err.text
    assertResultContains 'Caught: groovy.lang.MissingMethodException: No signature of method: java.lang.Integer.call() is applicable for argument types:'
  }

  void testSemiColonAdded() { 
    def semiColonAdded = new File('SemiColonAdded.groovy')
    semiColonAdded.deleteOnExit()
    semiColonAdded.text = new File('SemiColon.groovy').text.replaceAll("3", '3;')
    evaluateScript 'SemiColonAdded.groovy'
    assertResultContains 'Instance Initializer called...Semi@'
  }

  void testArrayInGroovy() {
    evaluateScript 'ArrayInGroovy.groovy'
    assertResultMatchesFileContent 'ArrayInGroovy.output'
  }

  void testJavaArrayInGroovy() {
    result = "groovy JavaArrayInGroovy.groovy".execute().err.text
    assertResultContains 'org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed'
  }

  void testNotInt() {
    evaluateScript 'NotInt.groovy'
    assertResultMatchesFileContent 'NotInt.output'
  }

  void testForEach() {
    evaluateScript 'ForEach.groovy'
    assertResultEquals '''Hello
Hi
Howdy
Hello
Hi
Howdy
'''
  }

  void testUsingCoffeeSize() {
    def version = "groovy -v".execute().text

    evaluateScript 'UsingCoffeeSize.groovy'
    assertResultMatchesFileContent 'UsingCoffeeSize.output'
  }

  void testAgileMethodologies() {
    evaluateScript 'AgileMethodologies.groovy'
    assertResultMatchesFileContent 'AgileMethodologies.output'
  }

  void testActivity() {
    evaluateScript 'Activity.groovy'
    assertResultEquals '''SATURDAY - Play
SUNDAY - Relax
'''
  }

  void testAuthorInfo() {
    result = "groovyc AuthorInfo.groovy".execute().err.text
    new File('AuthorInfo.class').deleteOnExit()
    assertResultEquals ''
  }

  void testActivityWorkaround() {
    evaluateScript 'ActivityWorkaround.groovy'
    assertResultMatchesFileContent 'ActivityWorkaround.output'    
  }

  void testVarArgs() {
    evaluateScript 'VarArgs.groovy'
    assertResultMatchesFileContent 'VarArgs.output'
  }
  
  void testDeprecationJavaCompiled() {
    "javac ClassWithDeprecation.java".execute().text
    result = "javac -Xlint UseDeprecated.java".execute().err.text
    assertResultContains "UseDeprecated.java:"
    assertResultContains 'warning: [deprecation] foo() in ClassWithDeprecation has been deprecated'
    assertResultContains 'obj.foo();'
    assertResultContains '1 warning'
    def classFile = new File('UseDeprecated.class')
    assertTrue classFile.exists()
    classFile.deleteOnExit()
    classFile = new File('ClassWithDeprecation.class')
    assertTrue classFile.exists()
    classFile.deleteOnExit()
  }
    
  void testDeprecationGroovyCompiled() {
   "groovyc ClassWithDeprecation.java".execute().text
   result = "javac -Xlint UseDeprecated.java".execute().err.text
   assertResultContains "UseDeprecated.java:"
   assertResultContains 'warning: [deprecation] foo() in ClassWithDeprecation has been deprecated'
   assertResultContains 'obj.foo();'
   assertResultContains '1 warning'
   def classFile = new File('UseDeprecated.class')
   assertTrue classFile.exists()
   classFile.deleteOnExit()
   classFile = new File('ClassWithDeprecation.class')
   assertTrue classFile.exists()
   classFile.deleteOnExit()
  }

  void testOverride() {
    result = "groovyc ClassWithOverride.java".execute().err.text
    assertResultEquals ''
    def classFile = new File('ClassWithOverride.class')
    assertTrue classFile.exists()
    classFile.deleteOnExit()
  }

  void testStaticImportExample() {
    evaluateScript 'StaticImportExample.groovy'
    boolean match =  result =~ /0\.\d*/
    assertTrue match
  }

  void testGenericsJavaCompiled() {
    evaluateScript 'CompileGenerics.groovy'
    def expected = """Generics.java:8: error: no suitable method found for add(double)
    list.add(2.0);
        ^
    method ArrayList.add(int,Integer) is not applicable
      (actual and formal argument lists differ in length)
    method ArrayList.add(Integer) is not applicable
      (actual argument double cannot be converted to Integer by method invocation conversion)
Generics.java:9: error: no suitable method found for add(String)
    list.add("hello");
        ^
    method ArrayList.add(int,Integer) is not applicable
      (actual and formal argument lists differ in length)
    method ArrayList.add(Integer) is not applicable
      (actual argument String cannot be converted to Integer by method invocation conversion)
2 errors

"""
    assertEquals expected, result
  }

  void testGenericsGroovyCompiled() {
    def process = "groovy RunGenerics.groovy".execute()
    def error = process.err.text
    result = (process.text + error).replace('\n', '')
    
    assertResultEquals new File('RunGenerics.output').text.replace('\n', '')
  }
  
  def removeFromByteCode(bytecode) {
    bytecode.replaceAll(/__timeStamp__\w+;/, '__timeStamp__').replaceAll(
      /__timeStamp__\w+:/, '__timeStamp__').replaceAll(/ldc2_w(.)*\n/, 'ldc2_w')
  }
  
  void testByteCodeGenerated() {
    "groovyc NoTypeCheck.groovy".execute().text
    new File('NoTypeCheck.class').deleteOnExit()
    result = removeFromByteCode("javap -c NoTypeCheck".execute().text)

    def expected = removeFromByteCode(
        new File('NoTypeCheckByteCodeFull.output').text)
    
    assertResultEquals expected
  }
  
  void testAnonymousConflict() {
    result = "groovy AnonymousConflict.groovy".execute().err.text
    
    assertResultContains 'org.codehaus.groovy.control.MultipleCompilationErrorsException: startup failed:'
    assertResultContains 'AnonymousConflict.groovy:'
    assertResultContains '2: unexpected token: println @ line 2, column 3.'
    assertResultContains 'println "the calculation provided"'
    assertResultContains '1 error'
  }

  void testAnonymousConflictResolved() {
    evaluateScript 'AnonymousConflictResolved.groovy'
    assertResultMatchesFileContent 'AnonymousConflictResolved.output'
  }

  void testAnnotations() {
    evaluateScript 'Annotations.groovy'
    assertResultMatchesFileContent 'Annotations.output'
  }
}
