/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
package com.agiledeveloper;

import javax.script.*;

public class InvokeFunction {
  public static void main(String[] args) {
    ScriptEngineManager manager = new ScriptEngineManager();
    
    ScriptEngine engine = manager.getEngineByName("groovy");

    try {
      engine.eval(
        "def greet(name)" +
        "{" +
        "  println \"Hello ${name}\"\n" +
        " 'Thanks for calling Groovy'" +
        " }");
      
      Invocable invocable = (Invocable) engine;

      try {
        Object result = invocable.invokeFunction("greet", "Dan");
      
        System.out.println("Back in Java: " + result);
      } catch(NoSuchMethodException ex) {
        System.out.println(ex);
      }
    } catch(ScriptException ex) {
      System.out.println(ex);
    }
  }
}
