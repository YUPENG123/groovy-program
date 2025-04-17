/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:DEFINE_OUTPUT"
class Friend {
  def listen() {
    "$name is listening as a friend"
  }
}
println "//" + "END:DEFINE_OUTPUT"

println "//" + "START:INJECT_OUTPUT"
@Mixin(Friend)
class Person {
  String firstName
  String lastName  
  String getName() { "$firstName $lastName"}
}

john = new Person(firstName: "John", lastName: "Smith")
println john.listen()
println "//" + "END:INJECT_OUTPUT"

println "//" + "START:POST_INJECT_OUTPUT"
class Dog {
  String name
}

Dog.mixin Friend

buddy = new Dog(name: "Buddy")
println buddy.listen()
println "//" + "END:POST_INJECT_OUTPUT"

println "//" + "START:NO_MIXIN_OUTPUT"
class Cat {
  String name
}

try {
  rude = new Cat(name: "Rude")
  rude.listen()
} catch(ex) {
  println ex.message
}
println "//" + "END:NO_MIXIN_OUTPUT"

println "//" + "START:INSTANCE_INJECT_OUTPUT"
socks = new Cat(name: "Socks")
socks.metaClass.mixin Friend
println socks.listen()
println "//" + "END:INSTANCE_INJECT_OUTPUT"

class Sample {
  def getName() { "sample" }
  static { mixin Friend }
}

println new Sample().listen()

@Mixin([Friend, StringBuilder])
class Sample2 {
  def getName() { "sample2" }
}

println new Sample2().listen()
println new Sample2().append("hello")