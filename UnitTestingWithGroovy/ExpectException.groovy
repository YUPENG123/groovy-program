/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
public class ExpectException extends GroovyTestCase {
  def divide(a, b) {
    a/b
  }

  void testExpectExceptionUsingTry() {
    try {
      divide(2, 0)
      fail "Expected ArithmeticException ..."
    } catch(ArithmeticException ex) {
      assertTrue true // Success
    }
  }

  void testExpectException() {
    shouldFail { divide(2, 0) }

    shouldFail(ArithmeticException) { divide(2, 0) }

    shouldFail ArithmeticException, { divide(2, 0) }
  }
}
