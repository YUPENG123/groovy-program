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
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.control.SourceUnit
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.MethodNode

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class ExploreAST implements ASTTransformation {
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
      println "sourceUnit $sourceUnit.name"
      println "Number of nodes presented: ${astNodes.length}"
      
      astNodes.each { node ->
        if(node instanceof ClassNode || node instanceof MethodNode)
         println "The targeted node is ${node.name}"
      }
    }
}