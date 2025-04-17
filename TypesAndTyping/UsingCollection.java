/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
//Java code
import java.util.*;

public class UsingCollection {
  public static void main(String[] args) {
    ArrayList<String> lst = new ArrayList<String>();
    Collection<String> col = lst;
	
    lst.add("one");
    lst.add("two");
    lst.add("three");
    lst.remove(0);
    col.remove(0);
	
    System.out.println("Added three items, removed two, so 1 item to remain.");
    System.out.println("Number of elements is: " + lst.size());
    System.out.println("Number of elements is: " + col.size());
  }
}
