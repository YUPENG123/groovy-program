/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def (forward, left, then, fast, right) = 
  ['forward', 'left', '', 'fast', 'right']

def move(dir) {
  println "moving $dir"
  this
}

def and(then) { this }

def turn(dir) {
  println "turning $dir"
  this
}

def jump(speed, dir) {
  println "jumping $speed and $dir"
  this
}

move forward and then turn left
jump fast, forward and then turn right
