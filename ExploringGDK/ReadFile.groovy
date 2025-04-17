/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:READ_OUTPUT"
println new File('thoreau.txt').text
println "//" + "END:READ_OUTPUT"

println "//" + "START:READLINE_OUTPUT"
new File('thoreau.txt').eachLine { line ->
  println line // or do whatever you like with that line here
}
println "//" + "END:READLINE_OUTPUT"

println "//" + "START:FILTERLINE_OUTPUT"
println new File('thoreau.txt').filterLine { it =~ /life/ }
println "//" + "END:FILTERLINE_OUTPUT"
