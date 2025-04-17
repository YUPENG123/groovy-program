/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def printThreadInfo(msg) {
  def currentThread = Thread.currentThread()
  println "$msg Thread is ${currentThread}. Daemon? ${currentThread.isDaemon()}"
}

printThreadInfo 'Main'

Thread.start { 
  printThreadInfo "Started"
  sleep(3000) { println "Interrupted" }
  println "Finished Started"
}

sleep(1000)

Thread.startDaemon {
  printThreadInfo "Started Daemon"
  sleep(5000) { println "Interrupted" }
  println "Finished Started Daemon" // Will not get here
}
