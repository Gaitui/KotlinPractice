fun main(args: Array<String>)
{
    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    //Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)


    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    //Player Status
    printPlayerStatus(isBlessed = isBlessed,
                      auraColor = auraColor,
                      name = name,
                      healthStatus =  healthStatus)
    //printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball()
    //castFireball(5)
}

private fun printPlayerStatus(auraColor: String, isBlessed: Boolean, name: String, healthStatus: String) {
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "Yes" else "No"})")
    println("$name$healthStatus")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "Green" else "None"
    return auraColor
}

/*private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean)
        = if (isBlessed && healthPoints > 50 || isImmortal) "Green" else "None"
*/

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    val healthStatus = when (healthPoints) {
        100 -> " is in excellent condition!"
        in 90..99 -> " has a few scratches."
        in 75..89 -> if (isBlessed) {
            //println(name + " has some minor wounds but is healing quite quickly!")
            " has some minor wounds but is healing quite quickly!"
        } else {
            //println(name + " has some minor wounds.")
            " has some minor wounds."
        }
        in 15..74 -> " looks pretty hurt."
        else -> " is in awful condition!"
    }
    return healthStatus
}

/*----another way---
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> " is in excellent condition!"
        in 90..99 -> " has a few scratches."
        in 75..89 -> if (isBlessed) {
            //println(name + " has some minor wounds but is healing quite quickly!")
            " has some minor wounds but is healing quite quickly!"
        } else {
            //println(name + " has some minor wounds.")
            " has some minor wounds."
        }
        in 15..74 -> " looks pretty hurt."
        else -> " is in awful condition!"
    }

 */

/*---Overloading is available
private fun castFireball()
{
    println("A glass of Fireball springs into existence.")
}*/

private fun castFireball(numFireballs: Int = 2) =
    println("A glass of Fireball springs into existence. (x$numFireballs)")