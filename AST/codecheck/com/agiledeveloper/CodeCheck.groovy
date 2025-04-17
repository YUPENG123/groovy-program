/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
package com.agiledeveloper

import org.codehaus.groovy.transform.GroovyASTTransformation
import org.codehaus.groovy.control.CompilePhase
import org.codehaus.groovy.transform.ASTTransformation
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.syntax.SyntaxException
import org.codehaus.groovy.ast.*

@GroovyASTTransformation(phase = CompilePhase.CLASS_GENERATION)
class CodeCheck implements ASTTransformation {
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
      sourceUnit.ast.classes.each { classNode ->
        classNode.visitContents(new ClassVisitor(sourceUnit))
      }
    }
}

class ClassVisitor implements GroovyClassVisitor {
  
 SourceUnit sourceUnit
 
 ClassVisitor(theSourceUnit) { sourceUnit = theSourceUnit }

 
 private void reportError(message, lineNumber, columnNumber) {
   sourceUnit.addError(new SyntaxException(message, lineNumber, columnNumber))
 }
 
 void visitClass(ClassNode node) {} 
 
 void visitConstructor(ConstructorNode node) {}
 
 void visitField(FieldNode node) {
   if(node.name.size() == 1)
     reportError "Better name for field '$node.name' please", 
         node.lineNumber, node.columnNumber
 }
 
 void visitMethod(MethodNode node) {
   if(node.name.size() == 1)
     reportError "Really, a single letter method?", 
         node.lineNumber, node.columnNumber
 }
 
 void visitProperty(PropertyNode node) {
   if(node.name.size() == 1) 
     reportError "Morally wrong to use a single letter property", 
         node.lineNumber, node.columnNumber
 }
}
