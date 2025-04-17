/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
public class Car implements Cloneable {
  int year;
  Engine engine;
  
  //Java code
  public Object clone() {
    try {
      Car cloned = (Car) super.clone();
      cloned.engine = (Engine) engine.clone();
      return cloned;
    } catch(CloneNotSupportedException ex) {
      return null; // Will not happen, but we need to please the compiler
    }
  }
}
