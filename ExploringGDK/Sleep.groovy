/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:DEEPSLEEPOUTPUT"
thread = Thread.start {
  println "Thread started"
  startTime = System.nanoTime()
  new Object().sleep(2000)
  endTime = System.nanoTime()
  println "Thread done in ${(endTime - startTime)/10**9} seconds"
}
new Object().sleep(100)
println "Let's interrupt that thread"
thread.interrupt()
thread.join()
println "//" + "END:DEEPSLEEPOUTPUT"

println "//" + "START:HANDLEINTERRUPTOUTPUT"
def playWithSleep(flag)
{
  thread = Thread.start {
    println "Thread started"
    startTime = System.nanoTime()
    new Object().sleep(2000) {
      println "Interrupted... " + it
      flag
    }
    endTime = System.nanoTime()
    println "Thread done in ${(endTime - startTime)/10**9} seconds"
  }

  thread.interrupt()
  thread.join()
}

playWithSleep(true)
playWithSleep(false)

println "//" + "END:HANDLEINTERRUPTOUTPUT"
