/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:EACHENTRYOUTPUT"
langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']

langs.each { entry ->
  println "Language $entry.key was authored by $entry.value"  
}
println "//" + "END:EACHENTRYOUTPUT"

println "//" + "START:EACHOUTPUT"
langs.each { language, author ->
  println "Language $language was authored by $author"  
}
println "//" + "END:EACHOUTPUT"

println "//" + "START:COLLECTOUTPUT"
println langs.collect { language, author ->
  language.replaceAll("[+]", "P")
}
println "//" + "END:COLLECTOUTPUT"

println "//" + "START:FINDOUTPUT"
println "Looking for the first language with name greater than 3 characters"
entry = langs.find { language, author ->
  language.size() > 3
}
println "Found $entry.key written by $entry.value"
println "//" + "END:FINDOUTPUT"

println "//" + "START:FINDALLOUTPUT"
println "Looking for all languages with name greater than 3 characters"
selected = langs.findAll { language, author ->
  language.size() > 3
}
selected.each { key, value ->
  println "Found $key written by $value"
}
println "//" + "END:FINDALLOUTPUT"

println "//" + "START:ANYOUTPUT"
print "Does any language name have a nonalphabetic character? "
println langs.any { language, author ->
  language =~ "[^A-Za-z]"
}
println "//" + "END:ANYOUTPUT"

println "//" + "START:EVERYOUTPUT"
print "Do all language names have a nonalphabetic character? "
println langs.every { language, author ->
  language =~ "[^A-Za-z]"
}
println "//" + "END:EVERYOUTPUT"

println "//" + "START:GROUPBYOUTPUT"
friends = [ briang : 'Brian Goetz', brians : 'Brian Sletten', 
	davidb : 'David Bock', davidg : 'David Geary',
	scottd : 'Scott Davis', scottl : 'Scott Leberknight', 
	stuarth : 'Stuart Halloway']

groupByFirstName = friends.groupBy { it.value.split(' ')[0] }

groupByFirstName.each { firstName, buddies ->
  println "$firstName : ${buddies.collect { key, fullName -> fullName }.join(', ')}"
}
println "//" + "END:GROUPBYOUTPUT"
