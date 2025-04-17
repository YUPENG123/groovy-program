/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:EVALUATE_OUTPUT"
what = new StringBuilder('fence')
text = "The cow jumped over the $what"
println text

what.replace(0, 5, "moon")
println text
println "//" + "END:EVALUATE_OUTPUT"

println "//" + "START:PROBLEM_OUTPUT"
price = 684.71
company = 'Google'
quote = "Today $company stock closed at $price"
println quote

stocks = [Apple : 663.01, Microsoft : 30.95]

stocks.each { key, value ->
  company = key
  price = value
  println quote
}

println "//" + "END:PROBLEM_OUTPUT"

println "//" + "START:FIX1_OUTPUT"

companyClosure = { it.write(company) }
priceClosure = { it.write("$price") }
quote = "Today ${companyClosure} stock closed at ${priceClosure}"
stocks.each { key, value ->
  company = key
  price = value
  println quote
}

println "//" + "END:FIX1_OUTPUT"

println "//" + "START:FIX2_OUTPUT"

companyClosure = {-> company }
priceClosure = {-> price }
quote = "Today ${companyClosure} stock closed at ${priceClosure}"
stocks.each { key, value ->
  company = key
  price = value
  println quote
}

println "//" + "END:FIX2_OUTPUT"

println "//" + "START:FIX_OUTPUT"

quote = "Today ${-> company } stock closed at ${-> price }"

stocks.each { key, value ->
  company = key
  price = value
  println quote
}

println "//" + "END:FIX_OUTPUT"
