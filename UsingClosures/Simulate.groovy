/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class Equipment {
  def calculator
  Equipment(calc) { calculator = calc }
  def simulate() {
    println "Running simulation"
    calculator() // We may send parameters as well
  }
}
def eq1 = new Equipment({ println "Calculator 1" })
def aCalculator = { println "Calculator 2" }
def eq2 = new Equipment(aCalculator)
def eq3 = new Equipment(aCalculator)

eq1.simulate()
eq2.simulate()
eq3.simulate()
