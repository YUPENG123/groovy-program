/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
process = "wc".execute()

process.out.withWriter {
  // Send input to process
  it << "Let the World know...\n"
  it << "Groovy Rocks!\n"
}

// Read output from process
println process.in.text
// or
//println process.text