import java.io.File

fun main(args: Array<String>)
{

    val player  = Player14("Madrigal")
    player.castFireball()

    /*---14_2---
    var currentRoom = Room("Foyer")
    */
    var currentRoom = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

    printIsSourceOfBlessings(player)
    printIsSourceOfBlessings(currentRoom)

    //Player Status
    printPlayerStatus(player)
}

class Player14(_name: String,
               var healthPoints: Int,
               val isBlessed: Boolean,
               private val isImmortal: Boolean){


    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value){
            field = value.trim()
            //trim is to erase blank in the front or back
        }

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

private fun printPlayerStatus(player: Player14) {
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "Yes" else "No"})")

    //13-11 player name here would show only when "Madrigal of Curlthistle Forest"??
    println("${player.name}")
    println("${player.name}${player.formatHealthStatus()}")
}

fun printIsSourceOfBlessings(any: Any)
{
    val isSourceofBlessings = if (any is Player14)
    {
        any.isBlessed
    }
    else
    {
        (any as Room).name == "Fount of Blessings"
    }

    println("$any is a source of blessings: $isSourceofBlessings")
}
