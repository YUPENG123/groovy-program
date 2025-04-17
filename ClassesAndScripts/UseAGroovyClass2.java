/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
public class UseAGroovyClass2 {
  public static void main(String[] args) {
    AGroovyClass instance = new AGroovyClass();
    //Java code
    System.out.println("Received: " + 
      instance.passToClosure(2, new Object() {
        public String call(int value) {
          return "You called from Groovy with value " + value;
        }
      }));
  }
}
