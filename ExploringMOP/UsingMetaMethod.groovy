/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:INVOKEOUTPUT"
str = "hello"
methodName = 'toUpperCase'
// Name may come from an input instead of being hard coded

methodOfInterest = str.metaClass.getMetaMethod(methodName)

println methodOfInterest.invoke(str)
println "//" + "END:INVOKEOUTPUT"

println "//" + "START:RESPONDSTOOUTPUT"
print "Does String respond to toUpperCase()? "
println String.metaClass.respondsTo(str, 'toUpperCase')? 'yes' : 'no'

print "Does String respond to compareTo(String)? " 
println String.metaClass.respondsTo(str, 'compareTo', "test")? 'yes' : 'no'

print "Does String respond to toUpperCase(int)? "
println String.metaClass.respondsTo(str, 'toUpperCase', 5)? 'yes' : 'no'
println "//" + "END:RESPONDSTOOUTPUT"
