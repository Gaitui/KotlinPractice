import java.lang.Exception
import java.lang.IllegalStateException

fun main(args: Array<String>)
{
    var swordsJuggling: Int? = null
    var isJugglingProficient = (1..3).random() == 3
    if(isJugglingProficient)
    {
        swordsJuggling = 2
    }
    /*---6_13---
    proficiencyCheck(swordsJuggling)
    swordsJuggling = swordsJuggling!!.plus(1)*/

    try
    {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    }
    catch(e: Exception)
    {
        println(e)
    }

    println("Your juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?)
{
    /*---6_13---
    swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
     */
    /*---6_15---
    swordsJuggling ?: throw UnskilledSwordJugglerException()
     */
    checkNotNull(swordsJuggling, {"Player cannot juggle swords"})
}

class UnskilledSwordJugglerException() :
        IllegalStateException("Player cannot juggle swords")
