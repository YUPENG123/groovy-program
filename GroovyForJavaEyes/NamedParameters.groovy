/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class Robot {
  def type, height, width
  def access(location, weight, fragile) {
    println "Received fragile? $fragile, weight: $weight, loc: $location"
  }
}
robot = new Robot(type: 'arm', width: 10, height: 40)
println "$robot.type, $robot.height, $robot.width"

robot.access(x: 30, y: 20, z: 10, 50, true)
//You can change the order
robot.access(50, true, x: 30, y: 20, z: 10)

def access(Map location, weight, fragile) {
  print "Received fragile? $fragile, weight: $weight, loc: $location"
}
