/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
enum CoffeeSize { SHORT, SMALL, MEDIUM, LARGE, MUG }
def orderCoffee(size) {
  print "Coffee order received for size $size: "
  switch(size) {
    case [CoffeeSize.SHORT, CoffeeSize.SMALL]:
      println "you're health conscious"
      break
    case CoffeeSize.MEDIUM..CoffeeSize.LARGE: 
      println "you gotta be a programmer"
      break
    case CoffeeSize.MUG:
      println "you should try Caffeine IV"
      break
  }
}
orderCoffee(CoffeeSize.SMALL)
orderCoffee(CoffeeSize.LARGE) 
orderCoffee(CoffeeSize.MUG) 
print 'Available sizes are: '
for(size in CoffeeSize.values()) {
    print "$size "
}
