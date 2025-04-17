/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class Worker {
  def simpleWork1(spec) { println "worker does work1 with spec $spec" }
  def simpleWork2() { println "worker does work2" }
}

class Expert {
  def advancedWork1(spec) { println "Expert does work1 with spec $spec" }
  def advancedWork2(scope, spec) { 
    println "Expert does work2 with scope $scope spec $spec" 
  }
}

class Manager {
  def worker = new Worker()
  def expert = new Expert()
  def schedule() { println "Scheduling ..." }
  def methodMissing(String name, args) {
    println "intercepting call to $name..."
    def delegateTo = null
    
    if(name.startsWith('simple')) { delegateTo = worker }
    if(name.startsWith('advanced')) { delegateTo = expert }
    if (delegateTo?.metaClass.respondsTo(delegateTo, name, args)) { 
      Manager instance = this
      instance.metaClass."${name}" = { Object[] varArgs -> 
            delegateTo.invokeMethod(name, varArgs)
      }
      delegateTo.invokeMethod(name, args)
    } else {
      throw new MissingMethodException(name, Manager.class, args)      
    }
  }
}
peter = new Manager()
peter.schedule()
peter.simpleWork1('fast')
peter.simpleWork1('quality')
peter.simpleWork2()
peter.simpleWork2()
peter.advancedWork1('fast')
peter.advancedWork1('quality')
peter.advancedWork2('prototype', 'fast')
peter.advancedWork2('product', 'quality')
try {
  peter.simpleWork3()
} catch(Exception ex) {
  println ex
}
