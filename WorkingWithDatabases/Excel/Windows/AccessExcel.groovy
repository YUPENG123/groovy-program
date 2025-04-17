/***
 * Excerpted from "Programming Groovy, 2nd Edition",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vslg2 for more book information.
***/
def sql = groovy.sql.Sql.newInstance(
"""jdbc:odbc:Driver=
{Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};
DBQ=C:/temp/weather.xlsx;READONLY=false""", '', '')

println "City\t\tTemperature"
sql.eachRow('SELECT * FROM [temperatures$]') {
 println "${it.city}\t\t${it.temperature}"
}
