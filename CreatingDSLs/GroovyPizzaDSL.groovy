/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def large = 'large'
def thin = 'thin'
def visa = 'Visa'
def Olives = 'Olives'
def Onions = 'Onions'
def Bell_Pepper = 'Bell Pepper'

orderInfo = [:]

def methodMissing(String name, args) {
  orderInfo[name] = args
}

def acceptOrder(closure) {
  closure.delegate = this
  closure()
  println "Validation and processing performed here for order received:"
  orderInfo.each { key, value ->
    println "${key} -> ${value.join(', ')}"
  }
}
