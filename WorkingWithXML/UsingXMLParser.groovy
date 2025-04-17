/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
languages = new XmlParser().parse('languages.xml')

println "Languages and authors"

languages.each {
  println "${it.@name} authored by ${it.author[0].text()}"
}

def languagesByAuthor = { authorName ->
    languages.findAll { it.author[0].text() == authorName }.collect { 
      it.@name }.join(', ')
}

  
println "Languages by Wirth:" + languagesByAuthor('Wirth')
