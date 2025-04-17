/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
// Traditional Looping
for(int i = 0; i < 10; i++) {
  println(i);
}
// Groovy ways
for(i in 0..9) { println i }

0.upto(9) { println it }

10.times { println it }
