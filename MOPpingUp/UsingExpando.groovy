/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:DEFINE_OUTPUT"
carA = new Expando()
carB = new Expando(year: 2012, miles: 0)
carA.year = 2012
carA.miles = 10

println "carA: " + carA
println "carB: " + carB
println "//" + "END:DEFINE_OUTPUT"
println "//" + "START:METHOD_OUTPUT"
car = new Expando(year: 2012, miles: 0, turn: { println 'turning...' })
car.drive = { 
  miles += 10 
  println "$miles miles driven"
}

car.drive()
car.turn()

println "//" + "END:METHOD_OUTPUT"
