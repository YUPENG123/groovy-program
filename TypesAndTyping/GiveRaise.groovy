/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
void giveRaise(Employee employee) {
  employee.raise(new BigDecimal(10000.00))
  // same as 
  //employee.raise(10000.00) 
}
  
giveRaise new Employee()
giveRaise new Executive()
