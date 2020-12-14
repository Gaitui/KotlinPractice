fun main(args: Array<String>)
{
    /*---6_1---
    var signatureDrink: String = "Butter Ale";
    signatureDrink = null;
    signatureDrink = signatureDrink + ", large";
     */

    /*---6_6---
    var beverage = readLine()?.capitalize()
    */

    /*---6_7---
    var beverage = readLine()?.let{
        if(it.isNotBlank())
        {
            it.capitalize()
        }
        else
        {
            "Buffer Ale"
        }
    }*/

    var beverage = readLine()
    if(beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null!")
    }

    //beverage = null
    //println(beverage)
    val beverageServer: String = beverage ?: "Buttered Ale"
    println(beverageServer)
}
