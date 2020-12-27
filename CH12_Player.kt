fun main(args: Array<String>)
{

    val player = Player()
    player.castFireball()

    //Player status
    printPlayerStatus(player)

}
class Player{
    var name = "madrigal"
        get() = field.capitalize()
        private set(value){
            field = value.trim()
            //trim is to erase blank in the front or back
        }
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false


    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "Green" else "None"
        return auraColor
    }

    fun formatHealthStatus(): String {
        val healthStatus = when (healthPoints) {
            100 -> " is in excellent condition!"
            in 90..99 -> " has a few scratches."
            in 75..89 -> if (isBlessed) {
                " has some minor wounds but is healing quite quickly!"
            } else {
                " has some minor wounds."
            }
            in 15..74 -> " looks pretty hurt."
            else -> " is in awful condition!"
        }
        return healthStatus
    }

    fun castFireball(numFireballs: Int=2) {
        println("A glass of Fireball springs into existence. (x$numFireballs)")
    }
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "Yes" else "No"})")
    println("${player.name}${player.formatHealthStatus()}")
}
