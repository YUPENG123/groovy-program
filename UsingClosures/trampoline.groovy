/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def factorial(int factorialFor) {
  def tailFactorial
  tailFactorial = { int number, BigInteger theFactorial = 1 ->
    number == 1 ? theFactorial : 
      tailFactorial.trampoline(number - 1, number * theFactorial)
  }.trampoline()
  tailFactorial(factorialFor)  
}
println "factorial of 5 is ${factorial(5)}"
println "Number of bits in the result is ${factorial(5000).bitCount()}"