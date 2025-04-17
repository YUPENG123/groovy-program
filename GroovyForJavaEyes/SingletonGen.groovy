/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
public class TheUnique implements 
  groovy.lang.GroovyObject extends java.lang.Object { 

    private static volatile TheUnique instance 
    //...
    
    private TheUnique() {
        metaClass = /*BytecodeExpression*/
        this.println('Instance created')
    }

    public java.lang.Object hello() {
        return this.println('hello')
    }

    public static TheUnique getInstance() {
        if ( instance != null) {
            return instance 
        } else {
            synchronized (TheUnique) {
                if ( instance != null) {
                    return instance 
                } else {
                    return instance = new TheUnique()
                }
            }
        }
    }
//...
