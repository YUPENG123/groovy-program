/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
employeeSkills = ['James' : [department : 'Infrastructure', languages : ['C++', 'Java', 'Groovy']], 
        'Sara' : [department : 'Simulation', languages : ['Perl', 'Java', 'Ruby']], 
        'Nick' : [department : 'Automation', languages : ['Groovy', 'Perl', 'Ruby']]]

bldr = new SkillBuilder('employee', 'knows', 'languages', 'usedby')

employeeSkills.each { person, details ->
  bldr.employee(name: person, department: details.department ) {
    languages (details.languages) {
    }
  }
}

bldr.report()