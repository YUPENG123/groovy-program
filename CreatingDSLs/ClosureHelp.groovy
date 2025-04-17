/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
import com.agiledeveloper.*

time = getPizza {
  setSize Size.LARGE
  setCrust Crust.THIN
  setTopping "Olives", "Onions", "Bell Pepper"
  setAddress "101 Main St., ..."
  setCard(CardType.VISA, "1234-1234-1234-1234")
}

printf "Pizza will arrive in %d minutes\n", time  

def getPizza(closure) {
  PizzaShop pizzaShop = new PizzaShop()
  closure.delegate = pizzaShop
  closure()
}
