/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def takeHelp(helper) {
  //...
  helper.helpMoveThings()
  //...
}

class Man {
  void helpMoveThings() {
    //...
    println "Man's helping"
  }
  //...
}

class Woman {
  void helpMoveThings() {
    //...
    println "Woman's helping"
  }
  //...
}

class Elephant {
  void helpMoveThings() {
    //...
    println "Elephant's helping"
  }
  void eatSugarcane() {
    //...
    println "I love sugarcanes..."
  }
  //...
}


println "//" + "START:TAKEHELP_OUTPUT"
takeHelp(new Man())
takeHelp(new Woman())
takeHelp(new Elephant())
println "//" + "END:TAKEHELP_OUTPUT"

println "//" + "START:TAKEHELP_AND_REWARD_OUTPUT"
def takeHelpAndReward(helper) {
  //...
  helper.helpMoveThings()
  
  if (helper.metaClass.respondsTo(helper, 'eatSugarcane'))
  {
    helper.eatSugarcane()
  }
  //...
}

takeHelpAndReward(new Man())
takeHelpAndReward(new Woman())
takeHelpAndReward(new Elephant())
println "//" + "END:TAKEHELP_AND_REWARD_OUTPUT"
