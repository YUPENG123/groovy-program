/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:SVN_OUTPUT"
println "svn help".execute().text
println "//" + "END:SVN_OUTPUT"

println "//" + "START:PROC_OUTPUT"
println "svn help".execute().getClass().name
println "//" + "END:PROC_OUTPUT"

println "//" + "START:LS_OUTPUT"
println "ls -l".execute().text
println "//" + "END:LS_OUTPUT"

println "//" + "START:GROOVY_OUTPUT"
println "groovy -v".execute().text
println "//" + "END:GROOVY_OUTPUT"
