import kotlin.math.roundToInt

const val TAVERN_NAME8 = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10

fun main(args: Array<String>)
{
    placeOrder("shandy,Dragon's Breath,5.91")

}
/*---8_1---
fun performPurchase()
{
    displayBalance()
}*/
fun performPurchase(price: Double)
{
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance = totalPurse - price
    //In book println("Remaining balance: ${"%.2f".format(remainingBalance)}")
    println("Remaining balance: ${String.format("%.2f",remainingBalance)}")
    val remainingGold = remainingBalance.toInt()
    //In book val remainingSilver = (remainingBalance %1 *100).roundToInt()
    val remainingSilver = String.format("%.0f",remainingBalance %1 *100).toInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private  fun displayBalance()
{
    println("Player's purse balance: Gold: $playerGold ,Silver: $playerSilver")
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


private fun placeOrder(menuData: String)
{
    val indexOfApostrophe = TAVERN_NAME8.indexOf('\'')
    val tavernMaster = TAVERN_NAME8.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")


    val(type,name,price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

    /*---8_1---
    performPurchase()
    */
    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath"){
        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    }else{
        "Madrigal says: Thanks for the $name"
    }
    println(phrase)
}
