/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
enum WeekendActivity {
  SATURDAY, SUNDAY;

  String activity() { 'Relax' }
}

def emc = new ExpandoMetaClass(WeekendActivity)
emc.activity = {-> 'Play'}
emc.initialize()
WeekendActivity.SATURDAY.metaClass = emc

for(day in WeekendActivity.values()) {  
  println "$day - ${day.activity()}"
}
