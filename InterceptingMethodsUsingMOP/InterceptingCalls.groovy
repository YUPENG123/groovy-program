/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class Car implements GroovyInterceptable {
  def check() { System.out.println "check called..." }
  
  def start() { System.out.println "start called..." }
  
  def drive() { System.out.println "drive called..." }
  
  def invokeMethod(String name, args) {
    System.out.print("Call to $name intercepted... ")

    if (name != 'check') {
      System.out.print("running filter... ")
      Car.metaClass.getMetaMethod('check').invoke(this, null) 
    }

    def validMethod = Car.metaClass.getMetaMethod(name, args)
    if (validMethod != null) {
      validMethod.invoke(this, args) 
    } else {
      Car.metaClass.invokeMethod(this, name, args) 
    }
  }
}

car = new Car()

car.start()
car.drive()
car.check()
try {
  car.speed()
} catch(Exception ex) {
  println ex
}
