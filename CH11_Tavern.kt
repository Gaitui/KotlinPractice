import kotlin.math.roundToInt
import java.io.File

const val TAVERN_NAME11 = "Taernyl's Folly"

/*---Until 11_4----
var playerGold11 = 10
var playerSilver11 = 10
 */
val patronList11 = mutableListOf("Eli","Mordoc","Sophie")
val lastName11 = listOf("Ironfoot","Fernsworth","Baggins")
val uniquePatrons11 = mutableSetOf<String>()
val menuList11 = File("data/tavern-menu-items.txt")
        .readText()
        .split("\n")
/*---11_1---
val patronGold = mutableMapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
 */
val patronGold = mutableMapOf<String,Double>()

fun main(args: Array<String>)
{
    if(patronList11.contains("Eli")){
        println("The tavern master says: Eli's in the back playing cards. ")
    }
    else {
        println("The tavern master says: Eli isn't here.")
    }

    if(patronList11.containsAll(listOf("Sophie","Mordoc")))
    {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    }
    else{
        println("The tavern master says: Nay, they departed hours ago.")
    }



    (0..9).forEach {
        val first = patronList11.shuffled().first()
        val last = lastName11.shuffled().first()
        val name = "$first $last"
        //println(name)
        uniquePatrons11 += name
    }
    //println(uniquePatrons11)
    uniquePatrons11.forEach{
        patronGold[it]= 6.0
    }

    var orderCount = 0
    while(orderCount<=9){
        placeOrder(uniquePatrons11.shuffled().first(),menuList11.shuffled().first())
        orderCount++
    }
    displayPatronBalance()
    /*---11_4---
    println(patronGold)
    patronGold += "Sophie" to 10.7
    println(patronGold)
    println(patronGold["Eli"])
    println(patronGold["Mordoc"])
    println(patronGold["Sophie"])
     */

}

private fun displayPatronBalance(){
    patronGold.forEach{ patron,balance ->
        println("$patron, balance: ${String.format("%.2f",balance)}")
    }
}

fun performPurchase11(price: Double, patronName: String)
{
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
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
    val indexOfApostrophe = TAVERN_NAME11.indexOf('\'')
    val tavernMaster = TAVERN_NAME11.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")


    val(type,name,price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price"
    println(message)

    performPurchase11(price.toDouble() , patronName)

    val phrase = if (name == "Dragon's Breath"){
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    }else{
        "$patronName says: Thanks for the $name"
    }
    println(phrase)
}
