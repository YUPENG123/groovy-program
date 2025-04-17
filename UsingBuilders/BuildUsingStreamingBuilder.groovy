/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']

xmlDocument = new groovy.xml.StreamingMarkupBuilder().bind {
  mkp.xmlDeclaration()
  mkp.declareNamespace(computer: "Computer")
  languages {
    comment << "Created using StreamingMarkupBuilder" 
    langs.each { key, value ->
      computer.language(name: key) {
        author (value)
      }
    }
  }
}
println xmlDocument