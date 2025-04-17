/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class DateUtil {
  static int getDays(Integer self) { self }

  static Calendar getAgo(Integer self) {
    def date = Calendar.instance
    date.add(Calendar.DAY_OF_MONTH, -self)
    date
  }

  static Date at(Calendar self, Double time) {
    def hour = (int)(time.doubleValue())
    def minute = (int)(Math.round((time.doubleValue() - hour) * 100))
    self.set(Calendar.HOUR_OF_DAY, hour)
    self.set(Calendar.MINUTE, minute)
    self.set(Calendar.SECOND, 0)
    self.time
  }
}

use(DateUtil) {
  println 2.days.ago.at(4.30)
}
