/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def sum(n) {
  total = 0
  for(int i = 2; i <= n; i += 2) {
    total += i
  }
  total
}
println "Sum of even numbers from 1 to 10 is ${sum(10)}"

def product(n) {
  prod = 1
  for(int i = 2; i <= n; i += 2) {
    prod *= i
  }
  prod
}
println "Product of even numbers from 1 to 10 is ${product(10)}"

def sqr(n) {
  squared = []
  for(int i = 2; i <= n; i += 2) {
    squared << i ** 2
  }
  squared  
}
println "Squares of even numbers from 1 to 10 is ${sqr(10)}"
