import java.io.File

fun main(args: Array<String>)
{
    /*
    //---9.1Origin---
    val menuFile =  File("menu-file.txt")
    menuFile.setReadable(true)
    menuFile.setWritable(true)
    menuFile.setExecutable(false)

    //---9.1Apply---
    val menuFile = File("menu-file.txt").apply{
        setReadable(true)
        setWritable(true)
        setExecutable(false)
    }
    */

    /*
    //---9.2Origin---
    val firstElement = listOf(1,2,3).last()
    val firstItemSquared = firstElement*firstElement

    //---9.2let---
    val firstItemSquared = listOf(1,2,3).last().let{
        it*it
    }
    println(firstItemSquared)

    //---9.2_1---
    println(formatGreeting("RR"))
    */

    /*
    //---9.3Origin---
    println(playerCreatMessage(nameIsLong("Polarcubis, Supreme Master of NyetHack")))

    //---9.3run---
    "Polarcubis, Supreme Master of NyetHack"
            .run(::nameIsLong)
            .run(::playerCreatMessage)
            .run(::println)
    */
    /*
    //---9.6Origin---
    val file = File("myfile.txt")
    val fileContect = if(file.canRead() && file.canWrite()){
        file.readText()
    }else{
        null
    }*/
    //---9.6takeif---
    val fileContect = File("myfile.txt")
            .takeIf { it.canRead() && it.canWrite() }
            ?.readText()

}
/*---9.2_1Origin---
fun formatGreeting(vipGuest: String?): String{
    return if(vipGuest!=null)
    {
        "Welcome, $vipGuest. Please, go straight back = your table is ready"
    }
    else
    {
        "Welcome to the tavern. You'll be seated soon."
    }
}
*/
/*---9.2_1let---
fun formatGreeting(vipGuest: String?): String{
    return vipGuest?.let{
        "Welcome, $it. Please, go straight back = your table is ready"
    }?: "Welcome to the tavern. You'll be seated soon."
}*/
/*---9.3---
fun nameIsLong(name :String) = name.length >= 20
fun playerCreatMessage(nameTooLong :Boolean): String{
   return if(nameTooLong) {
       "Name is too long. Please choose another one."
   }
   else {
       "Welcome, adventurer"
   }
}*/
