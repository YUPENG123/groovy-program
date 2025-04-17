/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:CREATEHASHMAPOUTPUT"
langs = ['C++' : 'Stroustrup', 'Java' : 'Gosling', 'Lisp' : 'McCarthy']

println langs.getClass().name
println "//" + "END:CREATEHASHMAPOUTPUT"

println "//" + "START:INDEXOUTPUT"
println langs['Java']
println langs['C++']
println "//" + "END:INDEXOUTPUT"

println "//" + "START:PROPERTYOUTPUT"
println langs.Java
println "//" + "END:PROPERTYOUTPUT"

try {
println "//" + "START:CPPOUTPUT"
println langs.C++ // Invalid code
} catch(Exception ex) {
  println ex
  println "//" + "END:CPPOUTPUT"
}

println "//" + "START:CPPAGAINOUTPUT"
println langs.'C++'
println "//" + "END:CPPAGAINOUTPUT"

println "//" + "START:CREATEHASH_NOQUOTE"
langs = ['C++' : 'Stroustrup', Java : 'Gosling', Lisp : 'McCarthy']

println langs
println "//" + "END:CREATEHASH_NOQUOTE"
