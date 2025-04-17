/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:CHAR_OUTPUT"
for(ch = 'a'; ch < 'd'; ch++) {
  println ch
}
println "//" + "END:CHAR_OUTPUT"
for (ch in 'a'..'c') {
  println ch
}

println "//" + "START:ADD_OUTPUT"
lst = ['hello']
lst << 'there'
println lst
println "//" + "END:ADD_OUTPUT"

println "//" + "START:PLUS_OUTPUT"
class ComplexNumber {
  def real, imaginary
  def plus(other) {
    new ComplexNumber(real: real + other.real,
          imaginary: imaginary + other.imaginary)
  }
  String toString() { "$real ${imaginary > 0 ? '+' : ''} ${imaginary}i"}
}
c1 = new ComplexNumber(real: 1, imaginary: 2)
c2 = new ComplexNumber(real: 4, imaginary: 1)
println c1 + c2
println "//" + "END:PLUS_OUTPUT"
