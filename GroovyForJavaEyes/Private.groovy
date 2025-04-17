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
  private int miles
  
  def drive(distance) {
    try {
      year = 2000
    } catch(ex) {
      println "can't change year"
    }
  }
}

car = new Car()

car.drive(10)

car.miles = 20

println car.miles