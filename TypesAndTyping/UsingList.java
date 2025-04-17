/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
import java.util.*;

public class UsingList {
  public static void main(String[] args) {
    {
    ArrayList list1 = new ArrayList();
    
    list1.add("hello");
    
    int size = ((String)(list1.get(0))).length(); 
    System.out.println(size);
    }

    {
    ArrayList<String> list2 = new ArrayList<String>();
    
    list2.add("better?");
    
    int size = list2.get(0).length();
    System.out.println(size);
    }

    {
    ArrayList<String> list3 = new ArrayList<String>();
    
    //list3.add(1); // Will result in a compilation error if uncommented
    
    ArrayList list = list3; 
    // May happen during passing parameters in method calls
    list.add(1);
    int size = list3.get(0).length(); 
    System.out.println(size);
    }
  }
}
