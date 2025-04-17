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
import org.codehaus.groovy.ast.builder.AstBuilder
import org.codehaus.groovy.ast.ClassNode
import org.codehaus.groovy.ast.Parameter
import org.codehaus.groovy.ast.MethodNode
import org.codehaus.groovy.ast.ASTNode
import org.codehaus.groovy.control.SourceUnit
import static org.objectweb.asm.Opcodes.ACC_STATIC
import static org.objectweb.asm.Opcodes.ACC_PUBLIC
import org.codehaus.groovy.ast.ClassHelper

@GroovyASTTransformation(phase = CompilePhase.SEMANTIC_ANALYSIS)
class EAMTransformation implements ASTTransformation {
    void visit(ASTNode[] astNodes, SourceUnit sourceUnit) {
            
      astNodes.findAll { node -> node instanceof ClassNode }.each { classNode ->

        def useMethodBody = new AstBuilder().buildFromCode { 
          def instance = newInstance()
          try {
            instance.open()
            instance.with block
          } finally  {
            instance.close()
          }
        }
        
        def useMethod = new MethodNode( 
          'use', ACC_PUBLIC | ACC_STATIC, ClassHelper.OBJECT_TYPE, 
          [new Parameter(ClassHelper.OBJECT_TYPE, 'block')] as Parameter[],
          [] as ClassNode[], useMethodBody[0])
        
        classNode.addMethod(useMethod)
      }
    }
}
