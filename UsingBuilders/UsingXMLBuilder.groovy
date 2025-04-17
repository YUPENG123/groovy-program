/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
bldr = new groovy.xml.MarkupBuilder()
bldr.languages {
  language(name: 'C++') { author('Stroustrup')}
  language(name: 'Java') { author('Gosling')}
  language(name: 'Lisp') { author('McCarthy')}
}