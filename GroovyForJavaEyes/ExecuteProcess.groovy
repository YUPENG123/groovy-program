/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
//Java code
import java.io.*;
public class ExecuteProcess {
  public static void main(String[] args) {
    try {
      Process proc = Runtime.getRuntime().exec("svn help");
      BufferedReader result = new BufferedReader(
        new InputStreamReader(proc.getInputStream()));
      String line;          
      while((line = result.readLine()) != null) {
        System.out.println(line);
      }
    } catch(IOException ex) {
      ex.printStackTrace();
    }
  }
}
