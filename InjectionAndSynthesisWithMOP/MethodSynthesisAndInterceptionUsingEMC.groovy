/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class Person {
  def work() { "working..." }
}

Person.metaClass.invokeMethod = { String name, args ->
  System.out.println "intercepting call for ${name}"
  
  def method = Person.metaClass.getMetaMethod(name, args)
  
  if (method) {
    method.invoke(delegate, args)
  } else {
    Person.metaClass.invokeMissingMethod(delegate, name, args)
  }
} 

Person.metaClass.methodMissing = { String name, args ->
  def plays = ['Tennis', 'VolleyBall', 'BasketBall']

  System.out.println "methodMissing called for ${name}"
  def methodInList = plays.find { it == name.split('play')[1]}
  
  if (methodInList) {
    def impl = { Object[] vargs ->
        "playing ${name.split('play')[1]}..."
    }
      
    Person.metaClass."$name" = impl //future calls will use this
    
    impl(args)
  } else {
    throw new MissingMethodException(name, Person.class, args)
  }
}

jack = new Person()
println jack.work()
println jack.playTennis()
println jack.playTennis()
