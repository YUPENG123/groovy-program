/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def timeIt(length, closure) {
  long start = System.nanoTime()
  println "Max revenue for $length is ${closure(length)}"
  long end = System.nanoTime()
  println "Time taken ${(end - start)/1.0e9} seconds"
}

def rodPrices = [0, 1, 3, 4, 5, 8, 9, 11, 12, 14, 
  15, 15, 16, 18, 19, 15, 20, 21, 22, 24, 
  25, 24, 26, 28, 29, 35, 37, 38, 39, 40]

def desiredLength = 27

@groovy.transform.Immutable
class RevenueDetails {
  int revenue
  ArrayList splits
}

println "//" + "START:RECURSIVE_OUTPUT"
def cutRod(prices, length) {
  if(length == 0)
    new RevenueDetails(0, [])
  else {
    def maxRevenueDetails = new RevenueDetails(Integer.MIN_VALUE, [])
    for(rodSize in 1..length) {
      def revenueFromSecondHalf = cutRod(prices, length - rodSize)
      def potentialRevenue = new RevenueDetails(
        prices[rodSize] + revenueFromSecondHalf.revenue,
        revenueFromSecondHalf.splits + rodSize)
      if(potentialRevenue.revenue > maxRevenueDetails.revenue) 
        maxRevenueDetails = potentialRevenue
    }
    maxRevenueDetails
  }
}

timeIt desiredLength, { length -> cutRod(rodPrices, length) }
println "//" + "END:RECURSIVE_OUTPUT"

println "//" + "START:MEMOIZED_OUTPUT"
def cutRod
cutRod = { prices, length ->
  if(length == 0)
    new RevenueDetails(0, [])
  else {
    def maxRevenueDetails = new RevenueDetails(Integer.MIN_VALUE, [])
    for(rodSize in 1..length) {
      def revenueFromSecondHalf = cutRod(prices, length - rodSize)
      def potentialRevenue = new RevenueDetails(
        prices[rodSize] + revenueFromSecondHalf.revenue,
        revenueFromSecondHalf.splits + rodSize)
      if(potentialRevenue.revenue > maxRevenueDetails.revenue) 
        maxRevenueDetails = potentialRevenue
    }
    maxRevenueDetails
  }
}.memoize()

timeIt desiredLength, { length -> cutRod(rodPrices, length) }
println "//" + "END:MEMOIZED_OUTPUT"
