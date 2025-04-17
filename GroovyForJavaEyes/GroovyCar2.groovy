/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class Car {
  final year
  private miles = 0
  
  Car(theYear) { year = theYear }

  def getMiles() {
    println "getMiles called"
    miles
  }
  
  private void setMiles(miles) { 
    throw new IllegalAccessException("you're not allowed to change miles") 
  }
  
  def drive(dist) { if (dist > 0) miles += dist }
}

def car = new Car(2012)

println "Year: $car.year"
println "Miles: $car.miles"
println  'Driving'
car.drive(10)
println "Miles: $car.miles"

try {
  print 'Can I set the year? '
  car.year = 1900
} catch(groovy.lang.ReadOnlyPropertyException ex) {
  println ex.message
}

try {
  print 'Can I set the miles? '
  car.miles = 12
} catch(IllegalAccessException ex) {
  println ex.message
}
