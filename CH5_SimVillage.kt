import javax.xml.bind.PrintConversionEvent

fun main(args: Array<String>)
{
    /*---5_1---
    println(
            {
                val currentYear = 2018
                "Welcome to SimVillage, Mayor! (copyright $currentYear)"
            }())
    */

    /*---5_2---
    val greetingFunction: () -> String =
            {
                val currentYear = 2018
                "Welcome to SimVillage, Mayor! (copyright $currentYear)"
            }

     println(greetingFunction())
     */

    /*---5_3---
    val greetingFunction: (String) -> String =
            {
                playerName ->
                val currentYear = 2018
                "Welcome to SimVillage, $playerName! (copyright $currentYear)"
            }

    println(greetingFunction("Guyal"))
    */

    /*---5_4--- it can only use in one variable
    val greetingFunction: (String) -> String =
            {
                val currentYear = 2018
                "Welcome to SimVillage, $it! (copyright $currentYear)"
            }

    println(greetingFunction("Ruyal"))
     */

    /*---5_5---
    val greetingFunction: (String,Int) -> String =
            {
                playerName,numBuildings ->
                val currentYear = 2018
                println("Adding $numBuildings houses.")
                "Welcome to SimVillage, $playerName! (copyright $currentYear)"
            }

    println(greetingFunction("Guyal",2))
     */

    /*---5_6---
    val greetingFunction =
            {
                playerName :String,numBuildings :Int ->
                val currentYear = 2018
                println("Adding $numBuildings houses.")
                "Welcome to SimVillage, $playerName! (copyright $currentYear)"
            }

    println(greetingFunction("Guyal",2))
    */

    /*---5_7---
    val greetingFunction =
            {
                playerName :String,numBuildings :Int ->
                val currentYear = 2018
                println("Adding $numBuildings houses.")
                "Welcome to SimVillage, $playerName! (copyright $currentYear)"
            }
    runSimulation("Kayal",greetingFunction)
     */

    /*---5_8---
    runSimulation("Gayal")
    {
        playerName :String,numBuildings :Int ->
        val currentYear = 2018
        println("Adding $numBuildings houses.")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    */

    /*---5_10---
    runSimulation("Gayal",::printConstructionCost)
    {
        playerName :String,numBuildings :Int ->
        val currentYear = 2018
        println("Adding $numBuildings houses.")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    */
    runSimulation()
}
/*---5_8---
inline fun runSimulation(playerName :String,greetingFunction: (String,Int) -> String)
{
    val numBuildings=(1..10).random()
    println(greetingFunction(playerName,numBuildings))
}*/

/*---5_10---
inline fun runSimulation(playerName :String,printConstructionCost: (Int) -> Unit,greetingFunction: (String,Int) -> String)
{
    val numBuildings=(1..10).random()
    printConstructionCost(numBuildings)
    println(greetingFunction(playerName,numBuildings))
}
fun printConstructionCost(numBuildings: Int)
{
    val cost = 500
    println("Construction cost: ${cost * numBuildings}")
}*/
fun runSimulation()
{
    val greetingFunction = configureGreetionFunction()
    println(greetingFunction("Qayal"))
    println(greetingFunction("Qayal"))
}

fun configureGreetionFunction() :(String) -> String
{
    val structType = "hospital"
    var numBuildings = 5
    return {
        playerName ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structType")
        "Welcome to Simvillage, $playerName! (copywrite $currentYear)"
    }
}