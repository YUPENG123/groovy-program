/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
"groovyc Greet.groovy".execute().text
new File("Greet.class").deleteOnExit()
groovyJar = "ls /opt/groovy/current/embeddable".execute().text.split('\n').collect {"/opt/groovy/current/embeddable/$it" }.join(":")
print "java -classpath $groovyJar:. Greet".execute().text
