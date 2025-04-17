/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class RunTest extends TestBase {
  void testCollectionsConvenienceMethods() {
    evaluateScript "CollectionsConvenienceMethods.groovy"    
    assertResultMatchesFileContent 'CollectionsConvenienceMethods.output'
  }
  
  void testCreatingArrayList() {
    evaluateScript "CreatingArrayList.groovy"
    result = result.replace('\n', '')
    assertResultEquals "//" + "START:CREATEOUTPUT[1, 3, 4, 1, 8, 9, 2, 6]java.util.ArrayList//" + "END:CREATEOUTPUT//" + "START:FETCH_ELEMENTSOUTPUT16//" + "END:FETCH_ELEMENTSOUTPUT//" + "START:INDEXOUTPUT62//" + "END:INDEXOUTPUT//" + "START:RANGEOUTPUT[4, 1, 8, 9]//" + "END:RANGEOUTPUT//" + "START:NEGATIVE_RANGEOUTPUT[4, 1, 8, 9]//" + "END:NEGATIVE_RANGEOUTPUT//" + "START:MODRANGEOUTPUT<java.util.ArrayList\$SubList@fedbf parent=[1, 3, 4, 1, 8, 9, 2, 6] parentOffset=2 offset=2 size=4 this\$0=[1, 3, 4, 1, 8, 9, 2, 6] modCount=1>After  subLst[0]=55 lst = [1, 3, 55, 1, 8, 9, 2, 6]//" + "END:MODRANGEOUTPUT"
  }

  void testIteratingArrayList() {
    evaluateScript "IteratingArrayList.groovy"
    assertResultMatchesFileContent 'IteratingArrayList.output'
  }

  void testNavigatingMap() {
    evaluateScript "NavigatingMap.groovy"
    assertResultMatchesFileContent 'NavigatingMap.output'
 }

  void testUsingMap() {
    evaluateScript "UsingMap.groovy"
    assertResultMatchesFileContent 'UsingMap.output'
  }

  void testFind() {
    evaluateScript "Find.groovy"
    assertResultMatchesFileContent 'Find.output'
  }
}
