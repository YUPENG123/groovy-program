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

public class InvokeMethod {
  public static void main(String[] args) {
    ScriptEngineManager manager = new ScriptEngineManager();
    
    ScriptEngine engine = manager.getEngineByName("groovy");

    try {
      engine.eval(
        "class Foo" +
        "{" +
        "  def bar(val)" +
        "  {" +
        "    println \"got ${val}\"" +
        "  }\n" +
        "  def static bar2(val)" +
        "  {" +
        "    println \"got ${val}!\"" +
        "  }" +
        "}\n" +
        "" +
        "def getFoo() { new Foo() }\n" +
        "def getFooClass() { Foo.class }");
      
      Invocable invocable = (Invocable) engine;
      Object foo = invocable.invokeFunction("getFoo");
      
      invocable.invokeMethod(foo, "bar", "Groovy?");
      
      Object fooClass = invocable.invokeFunction("getFooClass");
      invocable.invokeMethod(fooClass, "bar2", "Groovy?");
    } catch(NoSuchMethodException ex) {
      System.out.println(ex);
    } catch(ScriptException ex) {
      System.out.println(ex);
    }
  }
}
