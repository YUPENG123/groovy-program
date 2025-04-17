/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
document = groovy.xml.DOMBuilder.parse(new FileReader('languages.xml'))

rootElement = document.documentElement

use(groovy.xml.dom.DOMCategory) {
  println "Languages and authors"
  languages = rootElement.language

  languages.each { language ->
    println "${language.'@name'} authored by ${language.author[0].text()}"
  }  
  
  def languagesByAuthor = { authorName ->
      languages.findAll { it.author[0].text() == authorName }.collect { 
        it.'@name' }.join(', ')
  }
  
  println "Languages by Wirth:" + languagesByAuthor('Wirth')
}
