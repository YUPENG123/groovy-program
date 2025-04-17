/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
// Java code
package com.agiledeveloper;

import javax.script.*;

public class ParameterPassing {
  public static void main(String[] args) {
    ScriptEngineManager manager = new ScriptEngineManager();
    
    ScriptEngine engine = manager.getEngineByName("groovy");

    try {
      engine.put("name", "Venkat");
      engine.eval("println \"Hello ${name} from Groovy\"; name += '!' ");
      String name = (String) engine.get("name");
      System.out.println("Back in Java:" + name);
    } catch(ScriptException ex) {
      System.out.println(ex);
    }
  }
}
