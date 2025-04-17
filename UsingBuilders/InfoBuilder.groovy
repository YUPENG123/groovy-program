/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class InfoBuilder {
  def level = 0
  
  def names = [:]
  def languages = [:]
  def currentName = ''
  
  def methodMissing(String name, args) {
    if (level == 0) {
       currentName = args[0]
      names[currentName] = []  
       
       args[1].delegate = this
       level++
       args[1]()
       level--
    } else {
      names[currentName] = args[0]
      
      args[0].each { language ->
        if (languages[language] == null) {
          languages[language] = []
        }
        languages[language] << currentName
        }
    
      if (args.size()  > 1) {
        throw new Exception("Unexcpted parameter or closure provided")
      }
    }
  }
  
  def report() {
    names.each { name, languages ->
      println "${name} knows " + languages.join(', ')
      }
    
    println ""
    
    languages.each { language, names ->
      println "${language} is used by " + names.join(', ')
      }
  }
}
