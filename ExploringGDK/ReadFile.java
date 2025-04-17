/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
// Java code
import java.io.*;
public class ReadFile {
  public static void main(String[] args) {
    try {
      BufferedReader reader = new BufferedReader(
                      new FileReader("thoreau.txt"));
    
      String line = null;
      while((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch(FileNotFoundException ex) {
      ex.printStackTrace();
    } catch(IOException ex) {
      ex.printStackTrace();
    }
  }
}
