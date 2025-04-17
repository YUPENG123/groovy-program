/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
package com.agiledeveloper;

class PriceExtension {
  public static double getPrice(String self) {
      def url = "http://ichart.finance.yahoo.com/table.csv?s=$self".toURL()

      def data = url.readLines()[1].split(",")
      Double.parseDouble(data[-1])
    }
}
