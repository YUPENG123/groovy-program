/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
userid = 'root'
password = ''

"./createdb.sh".execute().text

println "//" + "START:CONNECT_OUTPUT"
def sql = groovy.sql.Sql.newInstance('jdbc:mysql://localhost:3306/weatherinfo', 
              userid, password, 'com.mysql.jdbc.Driver')

println sql.connection.catalog
println "//" + "END:CONNECT_OUTPUT"

println "//" + "START:ITERATE_OUTPUT"
println "City                Temperature"
sql.eachRow('SELECT * from weather') {
  printf "%-20s%s\n", it.city, it[1]
}
println "//" + "END:ITERATE_OUTPUT"

println "//" + "START:ITERATE_TO_XML_OUTPUT"
bldr = new groovy.xml.MarkupBuilder()

bldr.weather {
  sql.eachRow('SELECT * from weather') {
    city(name: it.city, temperature: it.temperature)
  }
}
println "\n//" + "END:ITERATE_TO_XML_OUTPUT"

println "//" + "START:ITERATE_META_OUTPUT"
processMeta = { metaData ->
  metaData.columnCount.times { i ->
    printf "%-21s", metaData.getColumnLabel(i+1)
  }
  println ""
}
  
sql.eachRow('SELECT * from weather', processMeta) {
  printf "%-20s %s\n", it.city, it[1]
}
println "//" + "END:ITERATE_META_OUTPUT"

println "//" + "START:ROWS_OUTPUT"
rows = sql.rows('SELECT * from weather')

println "Weather info available for ${rows.size()} cities"
println "//" + "END:ROWS_OUTPUT"

println rows.getClass().name

println "//" + "START:DATASET_OUTPUT"
dataSet = sql.dataSet('weather')
citiesBelowFreezing = dataSet.findAll { it.temperature < 32 }
println "Cities below freezing:"
citiesBelowFreezing.each {
  println it.city
}
println "//" + "END:DATASET_OUTPUT"

println "//" + "START:DATASET_ADD_OUTPUT"
println "Number of cities : " + sql.rows('SELECT * from weather').size()
dataSet.add(city: 'Denver', temperature: 19)
println "Number of cities : " + sql.rows('SELECT * from weather').size()
println "//" + "END:DATASET_ADD_OUTPUT"

println "//" + "START:INSERT_OUTPUT"
temperature = 50
sql.executeInsert("""INSERT INTO weather (city, temperature) 
                    VALUES ('Oklahoma City', ${temperature})""")
println sql.firstRow(
  "SELECT temperature from weather WHERE city='Oklahoma City'")
println "//" + "END:INSERT_OUTPUT"
