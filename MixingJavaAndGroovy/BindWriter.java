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

public class BindWriter {
  public static void main(String[] args) {
    ScriptEngineManager manager = new ScriptEngineManager();
    
    ScriptEngine engine = manager.getEngineByName("groovy");

    try {
      java.io.StringWriter writer = new java.io.StringWriter();
      engine.getContext().setWriter(writer);
      engine.eval("println 'Hello from Groovy'");
      System.out.println("Content captured in writer is: " + writer);
    } catch(ScriptException ex) {
      System.out.println(ex);
    }
  }
}
