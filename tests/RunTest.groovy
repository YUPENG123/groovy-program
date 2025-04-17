/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testGroovyVersion() {
    def version = "groovy -v".execute().text

    def sectionsAffected = '''Error: Version difference affects figures groovysh.eps, groovyConsole. Also search text for reference to that version'''
    assertEquals sectionsAffected, 'Groovy Version: 2.1.1 JVM: 1.7.0_04-ea Vendor: Oracle Corporation OS: Mac OS X\n', version    
  }
}
