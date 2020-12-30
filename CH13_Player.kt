import java.io.File

fun main(args: Array<String>)
{

    /*---13_3---
    val player = Player13("Madrigal",89,true,false)
    */
    val player = Player13("Madrigal")
    player.castFireball()

    //Player status
    printPlayerStatus(player)

    /*---13_7---
    val player1 = Player13("kar")
    printPlayerStatus(player1)
    */
}
class Player13(_name: String,
               /*---13_1---
               ,_healthPoints: Int,
               _isBlessed: Boolean,
               _isImmortal: Boolean*/
               var healthPoints: Int,
               val isBlessed: Boolean,
               private val isImmortal: Boolean){


    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value){
            field = value.trim()
            //trim is to erase blank in the front or back
        }

    /*---13_1---
    var healthPoints = _healthPoints
    val isBlessed = _isBlessed
    private val isImmortal = _isImmortal
     */

    /*---13_11---
    val hometown = selectHometown()
    */

    val hometown by lazy {selectHometown()}

    private fun selectHometown() = File("data/towns.txt")
            .readText()
            .split("\n")
            .shuffled()
            .first()

    init{
        require(healthPoints > 0, {"healthPoints must be greater than zero."})
        require(name.isNotBlank(), {"Player must have a name"})
    }

    constructor(name: String): this(
            name,
            healthPoints=100,
            isBlessed=true,
            isImmortal=false){
        if(name.toLowerCase() == "kar") healthPoints = 40
    }

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

private fun printPlayerStatus(player: Player13) {
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "Yes" else "No"})")

    //13-11 player name here would show only when "Madrigal of Curlthistle Forest"??
    println("${player.name}")
    println("${player.name}${player.formatHealthStatus()}")
}
