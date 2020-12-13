import javax.xml.bind.PrintConversionEvent

fun main(args: Array<String>)
{

    testRunSimulation("Gayal")
}
/*---5_8---
inline fun runSimulation(playerName :String,greetingFunction: (String,Int) -> String)
{
    val numBuildings=(1..10).random()
    println(greetingFunction(playerName,numBuildings))
}*/
fun testGreetingFunction(playerName: String,numBuildings: Int)
{
    val currentYear = 2018
    println("Adding $numBuildings houses.")
    "Welcome to SimVillage, $playerName! (copyright $currentYear)"
}
fun testRunSimulation(playerName :String)
{
    val numBuildings=(1..10).random()
    testPrintConstructionCost(numBuildings)
    println(testGreetingFunction(playerName,numBuildings))
}
fun testPrintConstructionCost(numBuildings: Int)
{
    val cost = 500
    println("Construction cost: ${cost * numBuildings}")
}