/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:JSONSIMPLE_OUTPUT"
class Person {
  String first
  String last
  def sigs 
  def tools
}
john = new Person(first: "John", last: "Smith", 
  sigs: ['Java', 'Groovy'], tools: ['script': 'Groovy', 'test': 'Spock'])
bldr = new groovy.json.JsonBuilder(john)
writer = new StringWriter()
bldr.writeTo(writer)
println writer
println "//" + "END:JSONSIMPLE_OUTPUT"

println "//" + "START:JSONCUSTOM_OUTPUT"
bldr = new groovy.json.JsonBuilder()
bldr {
  firstName john.first
  lastName john.last
  "special interest groups" john.sigs
  "preferred tools" {
    numberOfTools john.tools.size()
    tools john.tools
  }
}
writer = new StringWriter()
bldr.writeTo(writer)
println writer
println "//" + "END:JSONCUSTOM_OUTPUT"
