/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def completeOrder(amount, taxComputer) {
  tax = 0
  if (taxComputer.maximumNumberOfParameters == 2) {// expects tax rate
    tax = taxComputer(amount, 6.05)
  } else {// uses a default rate
    tax = taxComputer(amount)
  }
  println "Sales tax is ${tax}"
}
completeOrder(100) { it * 0.0825 }
completeOrder(100) { amount, rate -> amount * (rate/100) }
