/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testUsingCategories() {
    evaluateScript "UsingCategories.groovy"
    assertResultContains '''
123-45-6789
987-65-4321
No signature of method: java.lang.String.toSSN() is applicable for argument types: () values: []
Possible solutions:'''
    assertResultContains '''
123-45-6789
123-45-6789
987-65-4321
54
123-48-7651
181
!!hello!!
'''
  }

  void testUsingExpandoMetaClass() {
    evaluateScript "UsingExpandoMetaClass.groovy"
    replaceDateInResultWithFormat()
    def dayOfYear = Calendar.instance.get(Calendar.DAY_OF_YEAR)
    assertResultContains """//""" + """START:METHOD_OUTPUTDAY MON DY HH:MM:SS TZN YYYY//""" + """END:METHOD_OUTPUT//""" + """START:PROPERTY_OUTPUTDAY MON DY HH:MM:SS TZN YYYY//""" + """END:PROPERTY_OUTPUT//""" + """START:STATIC_METHOD_OUTPUTIs 2 even? trueIs 3 even? false//""" + """END:STATIC_METHOD_OUTPUT//""" + """START:CONSTRUCTOR_OUTPUT${dayOfYear}//""" + """END:CONSTRUCTOR_OUTPUT//""" + """START:OVERRIDE_CONSTRUCTOR_OUTPUTIntercepting constructor call4Intercepting constructor call${dayOfYear}//""" + """END:OVERRIDE_CONSTRUCTOR_OUTPUT"""
  }

  void testUsingEMCDSL() {
    evaluateScript "UsingEMCDSL.groovy"
    replaceDateInResultWithFormat()
    def dayOfYear = Calendar.instance.get(Calendar.DAY_OF_YEAR)
    assertResultContains """//""" + """START:METHOD_OUTPUTDAY MON DY HH:MM:SS TZN YYYY//""" + """END:METHOD_OUTPUT//""" + """START:PROPERTY_OUTPUTDAY MON DY HH:MM:SS TZN YYYY//""" + """END:PROPERTY_OUTPUT//""" + """START:STATIC_METHOD_OUTPUTIs 2 even? trueIs 3 even? false//""" + """END:STATIC_METHOD_OUTPUT//""" + """START:CONSTRUCTOR_OUTPUTIntercepting constructor call${dayOfYear}//""" + """END:CONSTRUCTOR_OUTPUT//""" + """START:OVERRIDE_CONSTRUCTOR_OUTPUTIntercepting constructor call4Intercepting constructor call${dayOfYear}//""" + """END:OVERRIDE_CONSTRUCTOR_OUTPUT"""
  }

  void testMethodOnHierarchy() {
    evaluateScript "MethodOnHierarchy.groovy"
    replaceDateInResultWithFormat()
    assertResultContains '''//''' + '''START:REDUNDANT_OUTPUTDAY MON DY HH:MM:SS TZN YYYYDAY MON DY HH:MM:SS TZN YYYY//''' + '''END:REDUNDANT_OUTPUT//''' + '''START:ONBASE_OUTPUTsomeMethod calledsomeMethod called//''' + '''END:ONBASE_OUTPUT'''
  }

  void testMethodSynthesisUsingMethodMissing() {
    evaluateScript 'MethodSynthesisUsingMethodMissing.groovy'
    assertResultContains 'working...methodMissing called for playTennisplaying Tennis...methodMissing called for playBasketBallplaying BasketBall...methodMissing called for playVolleyBallplaying VolleyBall...methodMissing called for playTennisplaying Tennis...methodMissing called for playPoliticsError: groovy.lang.MissingMethodException: No signature of method: Person.playPolitics() is applicable for argument types: () values: []'
  }

  void testMethodSynthesisUsingMethodMissing2() {
    evaluateScript 'MethodSynthesisUsingMethodMissing2.groovy'
    assertResultContains 'methodMissing called for playTennisplaying Tennis...playing Tennis...'
  }

  void testInterceptingMissingMethods() {
    evaluateScript 'InterceptingMissingMethods.groovy'
    assertResultContains 'intercepting call for workworking...intercepting call for playTennismethodMissing called for playTennisplaying Tennis...intercepting call for playTennisplaying Tennis...'
  }

  void testMethodSynthesisUsingEMC() {
    evaluateScript 'MethodSynthesisUsingEMC.groovy'
    assertResultContains 'working...methodMissing called for playTennisplaying Tennis...playing Tennis...methodMissing called for playPoliticsgroovy.lang.MissingMethodException: No signature of method: Person.playPolitics() is applicable for argument types: () values: []'
  }

  void testMethodSynthesisAndInterceptionUsingEMC() {
    evaluateScript 'MethodSynthesisAndInterceptionUsingEMC.groovy'
    assertResultContains 'intercepting call for workworking...intercepting call for playTennismethodMissing called for playTennisplaying Tennis...intercepting call for playTennisplaying Tennis...'
  }

  void testInjectInstance() {
    result = "groovy InjectInstance.groovy".execute().text
    assertResultContains '''
oh baby baby...
groovy.lang.MissingMethodException: No signature of method: Person.sing() is applicable for argument types: () values: []
Possible solutions:'''
    assertResultContains '''
playing...
groovy.lang.MissingMethodException: No signature of method: Person.sing() is applicable for argument types: () values: []
Possible solutions:'''
    assertResultContains '
  }

    void testInjectInstanceMetaClass() {
      result = "groovy InjectInstanceMetaClass.groovy".execute().text
      assertResultContains '''oh baby baby...
groovy.lang.MissingMethodException: No signature of method: Person.sing() is applicable for argument types: () values: []
Possible solutions:'''
      assertResultContains '''playing...
groovy.lang.MissingMethodException: No signature of method: Person.sing() is applicable for argument types: () values: []
Possible solutions:'''
    }

    void testInjectInstanceMetaClassDSL() {
      result = "groovy InjectInstanceMetaClassDSL.groovy".execute().text
      assertResultContains '''oh baby baby...
start the music...
No signature of method: Person.dance() is applicable for argument types: () values: []
Possible solutions:'''
    }

  void testInjectInstanceOnJava() {
    def process = "groovy InjectInstanceOnJava.groovy".execute()
    def error = process.err.text
    result = process.text + error
    assertResultContains '''oh baby baby...
groovy.lang.MissingMethodException: No signature of method: java.lang.String.sing() is applicable for argument types: () values: []
Possible solutions:'''
  }

  void testSynthesizeInstance() {
    result = "groovy SynthesizeInstance.groovy".execute().text
    assertResultContains """I'm Jack of all trades... I can sing
I'm Jack of all trades... I can dance
I'm Jack of all trades... I can juggle
groovy.lang.MissingMethodException: No signature of method: Person.sing() is applicable for argument types: () values: []
"""
  }

  void testMixin() {
    result = "groovy mixin.groovy".execute().text
    assertResultContains '''
John Smith is listening as a friend
Buddy is listening as a friend
No signature of method: Cat.listen() is applicable for argument types: () values: []
Possible solutions:'''
    assertResultContains '''
Socks is listening as a friend
sample is listening as a friend
sample2 is listening as a friend
hello
'''
    }
    
    void testFilter() {
      evaluateScript 'Filters.groovy'
      assertResultMatchesFileContent 'Filters.output'
    }
}
