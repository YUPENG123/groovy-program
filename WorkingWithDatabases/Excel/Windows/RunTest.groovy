/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testAccessExcel() {
    result = "cmd /c groovy AccessExcel.groovy".execute().text
    result = result.replaceAll('\n', '').replaceAll(' ', '').replaceAll('\t', '')
    assertResultEquals new File('AccessExcel.output').text
      .replaceAll('\n', '').replaceAll(' ', '').replaceAll('\t', '')
  }
}
