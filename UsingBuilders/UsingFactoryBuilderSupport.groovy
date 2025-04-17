/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class Robot {
  String name
  def movements = []

  void go() {
    println "Robot $name operating..."
    movements.each { movement -> println movement }
  }
}

class ForwardMove {
  def dist
  String toString() { "move distance... $dist"}
}

class LeftTurn {
  def rotation
  String toString() { "turn left... $rotation degrees"}
}

class RobotFactory extends AbstractFactory {
  def newInstance(FactoryBuilderSupport builder, name, value, Map attributes ) {
       new Robot(name: value) 
  }

  void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
    parent.movements << child
  }
}

class ForwardMoveFactory extends AbstractFactory {
  boolean isLeaf() { true }
  
  def newInstance(FactoryBuilderSupport builder, name, value, Map attributes ) {
    new ForwardMove() 
  }

  boolean onHandleNodeAttributes(FactoryBuilderSupport builder, 
                Object node, Map attributes) { 
    if (attributes.speed && attributes.duration) {
        node.dist = attributes.speed * attributes.duration
        attributes.remove('speed')
        attributes.remove('duration')
    }
    
    true
  }  
}

class LeftTurnFactory extends AbstractFactory {
  boolean isLeaf() { true }
  
  def newInstance(FactoryBuilderSupport builder, name, value, Map attributes) {
    new LeftTurn()
  }
}

class RobotBuilder extends FactoryBuilderSupport {
  {
    registerFactory('robot', new RobotFactory())
	
    registerFactory('forward', new ForwardMoveFactory())
	
    registerFactory('left', new LeftTurnFactory())
  };
}

println "//" + "START:USE_OUTPUT"
def bldr = new RobotBuilder()

def robot = bldr.robot('iRobot') {
    forward(dist: 20)
    left(rotation: 90)
    forward(speed: 10, duration: 5)
}

robot.go()
println "//" + "END:USE_OUTPUT"

try {
println "//" + "START:USE_INVALID_OUTPUT"
  def robotBldr = new RobotBuilder()
  robotBldr.robot('bRobot') {
    forward(dist: 20) { }
  }
} catch(ex) {
    println ex
} finally {
    println "//" + "END:USE_INVALID_OUTPUT"
}
