/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def pickEven(n, block) {
  for(int i = 2; i <= n; i += 2) {
    block(i)
  }
}

pickEven(10, { println it } )

pickEven(10) { println it }

pickEven(10) { evenNumber -> println evenNumber }

total = 0
pickEven(10) { total += it }
println "Sum of even numbers from 1 to 10 is ${total}"

product = 1
pickEven(10) { product *= it }
println "Product of even numbers from 1 to 10 is ${product}"
