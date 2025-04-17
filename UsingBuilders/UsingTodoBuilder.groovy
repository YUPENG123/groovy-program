/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
bldr = new TodoBuilder()

bldr.build {
  Prepare_Vacation (start: '02/15', end: '02/22') {
    Reserve_Flight (on: '01/01', status: 'done')
    Reserve_Hotel(on: '01/02')
    Reserve_Car(on: '01/02')
  }
  Buy_New_Mac {
    Install_QuickSilver
    Install_TextMate
    Install_Groovy {
      Run_all_tests
    }
  }
}