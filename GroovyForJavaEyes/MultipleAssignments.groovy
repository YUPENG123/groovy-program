/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:MULTIPLEASSIGN_OUTPUT"
def splitName(fullName) { fullName.split(' ') }

def (firstName, lastName) = splitName('James Bond')
println "$lastName, $firstName $lastName"
println "//" + "END:MULTIPLEASSIGN_OUTPUT"

println splitName('James Bond').getClass()

println "//" + "START:SWAP_OUTPUT"
def name1 = "Thomson"
def name2 = "Thompson"

println "$name1 and $name2"
(name1, name2) = [name2, name1]
println "$name1 and $name2"
println "//" + "END:SWAP_OUTPUT"

println "//" + "START:EXCESS_OUTPUT"
def (String cat, String mouse) = ['Tom', 'Jerry', 'Spike', 'Tyke']
println "$cat and $mouse"
println "//" + "END:EXCESS_OUTPUT"

println "//" + "START:LESS_OUTPUT"
def (first, second, third) = ['Tom', 'Jerry']
println "$first, $second, and $third"
println "//" + "END:LESS_OUTPUT"
third = 'Tyke'
(first, second, third) = ['Tom', 'Jerry']
println "$first, $second, and $third"

try {
  def (int one, int two) = [1]  
} catch(ex) {
  println ex.getClass()
}
