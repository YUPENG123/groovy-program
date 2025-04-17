/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testListTest() {
    result = "groovy ListTest.groovy".execute().text
    assertResultContains 'OK (1 test)'
  }

  void testExpectException() {
    result = "groovy ExpectException.groovy".execute().text
    assertResultContains 'OK (2 tests)'  
  }

  void testTestByOverriding() {
    result = "groovy TestByOverriding.groovy".execute().text
    assertResultContains 'OK (1 test)'
  }

  void testTestJavaByOverride() {
    "javac -d . com/agiledeveloper/JavaCodeWithHeavierDependencies.java".execute().text
    new File('com/agiledeveloper/JavaCodeWithHeavierDependencies.class').deleteOnExit()
    result = "groovy TestJavaByOverride.groovy".execute().text
    assertResultContains 'OK (1 test)'
  }

  void testTestUsingAHandTossedMock() {
    result = "groovy TestUsingAHandTossedMock.groovy".execute().text
    assertResultContains 'OK (1 test)'
  }

  void testTestUsingCategories() {
    result = "groovy TestUsingCategories.groovy".execute().text
    assertResultContains 'OK (1 test)'
  }

  void testTestUsingExpando() {
    result = "groovy TestUsingExpando.groovy".execute().text
    assertResultContains 'OK (1 test)'
  }

  void testTestUsingMap() {
    result = "groovy TestUsingMap.groovy".execute().text
    assertResultContains 'OK (1 test)'
  }

  void testTestUsingExpandoMetaClass() {
    result = "groovy TestUsingExpandoMetaClass.groovy".execute().text
    assertResultContains 'OK (1 test)'
  }

  void testTestUsingStubFor() {
    // Constructor if not intercepted. This may change in the future.
    def outputFile = new File('output.txt')

    result = "groovy TestUsingStubFor.groovy".execute().text
    assertResultContains 'OK (1 test)'

    assertTrue outputFile.exists()
    outputFile.deleteOnExit()
  }

  void testTestMethodCUsingMock() {
    result = "groovy TestMethodCUsingMock.groovy".execute().text
    assertResultContains 'OK (1 test)'
  }

  void testLearingMock() {
    result = "groovy LearningMock.groovy".execute().text
    assertResultContains 'OK (2 tests)'  
  }
  
  void testRunCarTest() {
    "javac -d classes src/Car.java".execute().text
    new File('classes/com/agiledeveloper/Car.class').deleteOnExit()
    evaluateScript('RunCarTest.groovy')
    assertResultContains'OK (2 tests)'
  }

  void testTwoFileUserTest() {
    result = 'groovy TwoFileUserTest.groovy'.execute().text
    assertResultContains'OK (1 test)'
    new File('output1.txt').deleteOnExit()
    new File('output2.txt').deleteOnExit()
  }
}
