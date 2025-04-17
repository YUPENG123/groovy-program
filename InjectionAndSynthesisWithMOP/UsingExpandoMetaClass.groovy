/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println '//' + 'START:METHOD_OUTPUT'
Integer.metaClass.daysFromNow = { ->
  Calendar today = Calendar.instance
  today.add(Calendar.DAY_OF_MONTH, delegate)
  today.time
}
println 5.daysFromNow()
println '//' + 'END:METHOD_OUTPUT'

println "//" + "START:PROPERTY_OUTPUT"
Integer.metaClass.getDaysFromNow = { ->
  Calendar today = Calendar.instance
  today.add(Calendar.DAY_OF_MONTH, delegate)
  today.time
}
println 5.daysFromNow
println "//" + "END:PROPERTY_OUTPUT"

println "//" + "START:STATIC_METHOD_OUTPUT"
Integer.metaClass.'static'.isEven = { val -> val % 2 == 0 }

println "Is 2 even? " + Integer.isEven(2)
println "Is 3 even? " + Integer.isEven(3)
println "//" + "END:STATIC_METHOD_OUTPUT"

println "//" + "START:CONSTRUCTOR_OUTPUT"
Integer.metaClass.constructor << { Calendar calendar ->
   new Integer(calendar.get(Calendar.DAY_OF_YEAR))
}

println new Integer(Calendar.instance)
println "//" + "END:CONSTRUCTOR_OUTPUT"
  
println "//" + "START:OVERRIDE_CONSTRUCTOR_OUTPUT"
Integer.metaClass.constructor = { int val ->
  println "Intercepting constructor call"
  constructor = Integer.class.getConstructor(Integer.TYPE)
  constructor.newInstance(val)
}

println new Integer(4)
println new Integer(Calendar.instance)
println "//" + "END:OVERRIDE_CONSTRUCTOR_OUTPUT"
