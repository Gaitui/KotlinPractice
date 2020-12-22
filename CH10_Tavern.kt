import kotlin.math.roundToInt
import java.io.File

const val TAVERN_NAME10 = "Taernyl's Folly"

var playerGold10 = 10
var playerSilver10 = 10
/*---10_2----
val patronList = listOf("Eli","Mordoc","Sophie")
*/
val patronList = mutableListOf("Eli","Mordoc","Sophie")
val lastName = listOf("Ironfoot","Fernsworth","Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
        .readText()
        .split("\n")

val readOnlyPatronList = patronList.toList()

fun main(args: Array<String>)
{
    if(patronList.contains("Eli")){
        println("The tavern master says: Eli's in the back playing cards. ")
    }
    else {
        println("The tavern master says: Eli isn't here.")
    }

    if(patronList.containsAll(listOf("Sophie","Mordoc")))
    {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    }
    else{
        println("The tavern master says: Nay, they departed hours ago.")
    }


    /*---10_12---
    println(patronList)
    patronList.remove("Eli")
    patronList.add("Alex")
    println(patronList)
    patronList.removeAt(1)
    patronList.add(0,"Harry")
    println(patronList)
    patronList[0] = "Potter"
    println(patronList)
    patronList.addAll(2, listOf("KKman","Lmao"))
    println(patronList)
    println(readOnlyPatronList)
    */
    /*---10_13---
    for(patron in patronList)
    {
        println("Good evening, $patron")
    }
    */
    /*---10_14---
    patronList.forEach{
        println("Good evening, $it")
    }
     */

    /*---10_19---
    patronList.forEachIndexed{ index , patron->
        println("Good evening, $patron, you're #${index+1} in line.")
        placeOrder(patron,menuList.shuffled().first())
    }

    menuList.forEachIndexed{ index , data ->
        println("$index : $data")
    }
     */

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        //println(name)
        uniquePatrons += name
    }
    println(uniquePatrons)

    var orderCount = 0
    while(orderCount<=9){
        placeOrder(uniquePatrons.shuffled().first(),menuList.shuffled().first())
        orderCount++
    }

    /*---10_4---
    println(patronList[0])
    println(patronList.first())
    println(patronList.last())

    val fifthPatron = patronList.getOrNull(4) ?: "Unknown Patron"
    println(fifthPatron)
    */

}

fun performPurchase10(price: Double)
{
    displayBalance()
    val totalPurse = playerGold10 + (playerSilver10 / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance = totalPurse - price
    //課本寫法 println("Remaining balance: ${"%.2f".format(remainingBalance)}")
    println("Remaining balance: ${String.format("%.2f",remainingBalance)}")
    val remainingGold = remainingBalance.toInt()
    //課本寫法 val remainingSilver = (remainingBalance %1 *100).roundToInt()
    val remainingSilver = String.format("%.0f",remainingBalance %1 *100).toInt()
    playerGold10 = remainingGold
    playerSilver10 = remainingSilver
    displayBalance()
}

private  fun displayBalance()
{
    println("Player's purse balance: Gold: $playerGold10 ,Silver: $playerSilver10")
}

private  fun toDragonSpeak(phrase:String) =
        phrase.replace(Regex("[aeiou]")){
            when(it.value){
                "a" -> "4"
                "e" -> "3"
                "i" -> "1"
                "0" -> "0"
                "u" -> "|_|"
                else -> it.value
            }
        }


private fun placeOrder(patronName:String,menuData: String)
{
    val indexOfApostrophe = TAVERN_NAME10.indexOf('\'')
    val tavernMaster = TAVERN_NAME10.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")


    val(type,name,price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price"
    println(message)

    //performPurchase10(price.toDouble())

    val phrase = if (name == "Dragon's Breath"){
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    }else{
        "$patronName says: Thanks for the $name"
    }
    println(phrase)
}
