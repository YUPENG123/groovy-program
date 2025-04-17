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
import org.codehaus.groovy.ast.stmt.ExpressionStatement
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.stmt.Statement
import org.codehaus.groovy.ast.builder.AstBuilder

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class InjectAudit implements ASTTransformation {
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
      def checkingAccountClassNode = 
        astNodes[0].classes.find { it.name == 'CheckingAccount' }
      injectAuditMethod(checkingAccountClassNode)
    }
    
    static void injectAuditMethod(checkingAccountClassNode) {
      def nonAuditMethods = 
        checkingAccountClassNode?.methods.findAll { it.name != 'audit' }
      nonAuditMethods?.each { injectMethodWithAudit(it) }
    }
    
    static void injectMethodWithAudit(methodNode) {
      List<Statement> statements = new AstBuilder().buildFromSpec {
        expression {
          methodCall {
            variable 'this'
            constant 'audit'
            argumentList { 
              methodNode.parameters.each { variable it.name }
            }
          }          
        }
      }
      def callToCheck = statements[0]
      methodNode.code.statements.add(0, callToCheck)
    }
}
