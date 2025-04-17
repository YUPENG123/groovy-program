/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class TodoBuilder {
  def level = 0
  def result = new StringWriter()
  def build(closure) {
    result << "To-Do:\n"
    closure.delegate = this
    closure()
    println result
  }

  def methodMissing(String name, args) {
    handle(name, args)
  }
  
  def propertyMissing(String name) {
    Object[] emptyArray = []
    handle(name, emptyArray)  
  }

  def handle(String name, args) {
    level++
    level.times { result << " "}
    result << placeXifStatusDone(args)
    result << name.replaceAll("_", " ")
    result << printParameters(args)
    result << "\n"

    if (args.length > 0 && args[-1] instanceof Closure) {
      def theClosure = args[-1]
      theClosure.delegate = this
      theClosure()
    }
    
    level--
  }
  
  def placeXifStatusDone(args) {
    args.length > 0 && args[0] instanceof Map && 
      args[0]['status'] == 'done' ? "x " : "- "
  }
  
  def printParameters(args) {
    def values = ""
    if (args.length > 0 && args[0] instanceof Map) {
      values += " ["
      def count = 0
      args[0].each { key, value ->
        if (key == 'status') return
        count++
        values += (count > 1 ? " " : "")
        values += "${key}: ${value}"
      }
      values += "]"
    }

    values    
  }
}
