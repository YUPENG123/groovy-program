/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
bldr = new groovy.swing.SwingBuilder()

frame = bldr.frame(
  title: 'Swing',
  size: [50, 100],
  layout: new java.awt.FlowLayout(),
  defaultCloseOperation:javax.swing.WindowConstants.EXIT_ON_CLOSE
) {
  lbl = label(text: 'test')
  btn = button(text: 'Click me', actionPerformed: { 
    btn.text = 'Clicked'
    lbl.text = "Groovy!" 
    } )
}

frame.show()