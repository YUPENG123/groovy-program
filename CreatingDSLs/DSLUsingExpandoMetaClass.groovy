/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
Integer.metaClass{
  getDays = { -> 
    delegate
  }
   
  getAgo = { ->
      def date = Calendar.instance
      date.add(Calendar.DAY_OF_MONTH, -delegate)
      date
    }
}

Calendar.metaClass.at = { Map time ->
    def hour = 0
    def minute = 0
    time.each {key, value -> 
      hour = key.toInteger()
      minute = value.toInteger()
    }

    delegate.set(Calendar.HOUR_OF_DAY, hour)
    delegate.set(Calendar.MINUTE, minute)
    delegate.set(Calendar.SECOND, 0)
    delegate.time
}

println 2.days.ago.at(4:30)