/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:VARARGS_OUTPUT"
def receiveVarArgs(int a, int... b) {
  println "You passed $a and $b"
}

def receiveArray(int a, int[] b) {
  println "You passed $a and $b"  
}

receiveVarArgs(1, 2, 3, 4, 5)
receiveArray(1, 2, 3, 4, 5)
println "//" + "END:VARARGS_OUTPUT"

println "//" + "START:SENDARRAY_OUTPUT"
int[] values = [2, 3, 4, 5]
receiveVarArgs(1, values)  
receiveVarArgs(1, [2, 3, 4, 5] as int[])
println "//" + "END:SENDARRAY_OUTPUT"

receiveArray(1, values)  
receiveArray(1, [2, 3, 4, 5] as int[])

try {
  receiveVarArgs(1, [2, 3, 4, 5])
} catch(ex) {
  println ex.getClass()
}

try {
  receiveArray(1, [2, 3, 4, 5])
} catch(ex) {
  println ex.getClass()
}
