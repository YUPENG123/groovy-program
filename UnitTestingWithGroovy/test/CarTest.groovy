/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class CarTest extends GroovyTestCase
{
  def car
  void setUp()
  {
    car = new com.agiledeveloper.Car()
  }
  void testInitialize()
  {
    assertEquals 0, car.miles
  }
  void testDrive()
  {
    car.drive(10)
    assertEquals 10, car.miles
  }
}