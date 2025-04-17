/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
abstract class Writer {
  abstract void write(String message)
}

class StringWriter extends Writer {
  def target = new StringBuilder()
  
  void write(String message) {
    target.append(message)
  }
  
  String toString() { target.toString() }
}

println "//" + "START:WRITESTUFF_OUTPUT"
def writeStuff(writer) {
  writer.write("This is stupid")
  println writer
}

def create(theWriter, Object[] filters = []) {
  def instance = theWriter.newInstance()
  filters.each { filter -> instance.metaClass.mixin filter }
  instance
}
writeStuff(create(StringWriter))

println "//" + "END:WRITESTUFF_OUTPUT"

class UppercaseFilter {

  void write(String message) {
    def allUpper = message.toUpperCase()
	
    invokeOnPreviousMixin(metaClass, "write", allUpper)
  }
}

Object.metaClass.invokeOnPreviousMixin = { 
  MetaClass currentMixinMetaClass, String method, Object[] args ->
  def previousMixin = delegate.getClass()
  for(mixin in mixedIn.mixinClasses) {
    if(mixin.mixinClass.theClass == 
      currentMixinMetaClass.delegate.theClass) break
    previousMixin = mixin.mixinClass.theClass
  }
  mixedIn[previousMixin]."$method"(*args)  
}

println "//" + "START:USEUPPER_OUTPUT"
writeStuff(create (StringWriter, UppercaseFilter))
println "//" + "END:USEUPPER_OUTPUT"

println "//" + "START:PROFANITYFILTER_OUTPUT"
class ProfanityFilter {
  void write(String message) {
    def filtered = message.replaceAll('stupid', 's*****')
    invokeOnPreviousMixin(metaClass, "write", filtered)
  }
}

writeStuff(create (StringWriter, ProfanityFilter))
println "//" + "END:PROFANITYFILTER_OUTPUT"


println "//" + "START:BOTH_OUTPUT"
writeStuff(create(StringWriter, UppercaseFilter, ProfanityFilter))
writeStuff(create(StringWriter, ProfanityFilter, UppercaseFilter))
println "//" + "END:BOTH_OUTPUT"
