const val TAVERN_NAME = "Taernyl's Folly"

fun main(args: Array<String>)
{
    //placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("elixir,Shirleys's Temple,4.12")
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
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    /*---7_3---
    val data = menuData.split(',')
    val type = data[0]
    val name = data[1]
    val price = data[2]
     */

    val(type,name,price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

    /*---7_5---
    val phrase = "Ah, delicious $name!"
    println("Madrigal exclaims: ${toDragonSpeak(phrase)}")
     */

    val phrase = if (name == "Dragon's Breath"){
        "Madrigal exclaims: Ah, delicious $name!"
    }else{
        "Madrigal says: Thanks for the $name"
    }
    println(phrase)
}
