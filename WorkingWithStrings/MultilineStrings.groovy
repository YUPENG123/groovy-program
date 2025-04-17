/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
println "//" + "START:LITERALOUTPUT"
memo = '''Several of you raised concerns about long meetings.
To discuss this, we will be holding a 3 hour meeting starting
at 9AM tomorrow. All getting this memo are required to attend.
If you can't make it, please have a meeting with your manager to explain.
'''

println memo
println "//" + "END:LITERALOUTPUT"

println "//" + "START:EXPRESSIONOUTPUT"
price = 251.12

message = """We're very pleased to announce
that our stock price hit a high of \$${price} per share
on December 24th. Great news in time for...
"""
println message
println "//" + "END:EXPRESSIONOUTPUT"
