/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
//Java code
package com.agiledeveloper;

public class OrderPizza {
  public static void main(String[] args) {
    PizzaShop joesPizza = new PizzaShop();
    joesPizza.setSize(Size.LARGE);
    joesPizza.setCrust(Crust.THIN);
    joesPizza.setTopping("Olives", "Onions", "Bell Pepper");
    joesPizza.setAddress("101 Main St., ...");
    int time = joesPizza.setCard(CardType.VISA, "1234-1234-1234-1234");
    System.out.printf("Pizza will arrive in %d minutes\n", time);
  }
}
