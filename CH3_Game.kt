fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    //Aura
    val auraVisible = isBlessed && healthPoints>50 || isImmortal
    /*if(auraVisible)
    {
        println("Green")
    }
    else
    {
        println("None")
    }*/
    val auraColor = if(auraVisible) "Green" else "None"
    //println(auraColor)


    /*val healthStatus = if (healthPoints == 100)
    {
        //println(name + " is in excellent condition!")
        " is in excellent condition!"
    }
    else if(healthPoints in 90..99)
    {
        //println(name + " has a few scratches.")
        " has a few scratches."
    }
    else if(healthPoints in 75..89)
    {
        if(isBlessed)
        {
            //println(name + " has some minor wounds but is healing quite quickly!")
            " has some minor wounds but is healing quite quickly!"
        }
        else
        {
            //println(name + " has some minor wounds.")
            " has some minor wounds."
        }
    }
    else if(healthPoints in 15..74)
    {
        //println(name + " looks pretty hurt.")
        " looks pretty hurt."
    }
    else
    {
        //println(name + " is in awful condition!")
        " is in awful condition!"
    }*/
    val healthStatus = when(healthPoints)
    {
        100 -> " is in excellent condition!"
        in 90..99 -> " has a few scratches."
        in 75..89 -> if(isBlessed)
                    {
                        //println(name + " has some minor wounds but is healing quite quickly!")
                        " has some minor wounds but is healing quite quickly!"
                    }
                    else
                    {
                        //println(name + " has some minor wounds.")
                        " has some minor wounds."
                    }
        in 15..74 -> " looks pretty hurt."
        else -> " is in awful condition!"
    }
    //Player Status
    println("(Aura: $auraColor) " +
            "(Blessed: ${if(isBlessed) "Yes" else "No"})")
    println("$name$healthStatus")
    //println("\$auraColor")
    val karma = (0..20).random()
    print("Karma: $karma ")
    println(when(karma)
    {
        in 0..5 -> "Red"
        in 6..10 -> "Orange"
        in 11..15 -> "Purple"
        in 16..20 -> "Green"
        else -> "Over flow"
    })
}