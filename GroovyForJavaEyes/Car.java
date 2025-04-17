/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
//Java code
public class Car {
  private int miles;
  private final int year;
  
  public Car(int theYear) { year = theYear; }
  public int getMiles() { return miles; }
  public void setMiles(int theMiles) { miles = theMiles; }
  
  public int getYear() { return year; }
  
  public static void main(String[] args) {
    Car car = new Car(2008);
    
    System.out.println("Year: " + car.getYear());
    System.out.println("Miles: " + car.getMiles());
    System.out.println("Setting miles");
    car.setMiles(25);
    System.out.println("Miles: " + car.getMiles());
  }
}
