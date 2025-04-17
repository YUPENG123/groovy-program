/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
class SkillBuilder extends BuilderSupport {
  def parentMethod
  def childMethod
  def theActivity
  def theUsedBy
  def currentPerson
  def personSkills = [:]
  def skillsPeople = [:]

  def SkillBuilder(person, activity, skill, uses) {
    parentMethod = person
    childMethod = skill
    theActivity = activity
    theUsedBy = uses
  }

  void setParent(parent, child) {
    if (parent != parentMethod || child != childMethod) {
      throw new Exception("node ${child} not expected under parent ${parentMethod}")
    }
  }

  void validateMethodName(name) {
    if (name != parentMethod && name != childMethod) {
      throw new Exception("Validation error: node name ${name} unexpected")
    }  
  }

  def createNode(name) {
    validateMethodName(name)
     throw new Exception("Expected map of attrbutes in call to ${name}")
  }
  
  def createNode(name, Object value) {
    validateMethodName(name)
  
    if (name == parentMethod)
       throw new Exception("Expected map of attrbutes in call to ${name}")

    if (value instanceof ArrayList) {
      personSkills[currentPerson] = value
      
      value.each { skill ->
        if (skillsPeople[skill] == null) {
          skillsPeople[skill] = []
        }
        
        skillsPeople[skill] << currentPerson
      }
      
      name    
    }
    else
      throw new Exception("Expected ArrayList of values in call to ${name}")
  }

  def createNode(name, Map attributes) {
    validateMethodName(name)
  
    currentPerson = new Expando(attributes)
    name
   }

  def createNode(name, Map attribute, Object value) {
    validateMethodName(name)
     throw new Exception("Expected only map of attrbutes in call to ${name}, value not expected")    
  }

  void nodeCompleted(parent, node) {
  }

  def expandoToString(obj) {
    def str = ""
    obj.properties.each { name, value -> str += "${value} "}
    str
  }

  def report() {
    println "${parentMethod} and ${childMethod}"
    personSkills.each { person, skills ->
      println "${expandoToString(person)} ${theActivity} " + skills.join(', ')
      }
    
    println "${childMethod} and ${parentMethod}"
    
    skillsPeople.each { skill, persons ->
      println "${skill} ${theUsedBy} " + persons.collect{ expandoToString(it) }.join(', ')
      }
  }
}
