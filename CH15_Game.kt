import java.io.File
import java.lang.Exception
import java.lang.IllegalStateException

fun main(args: Array<String>)
{
    Game.play()

    /*---15.1.2---
    val abandonedTownSquare = object :TownSquare(){
        override fun load() = "You anticipate appluse, but no one is here"
    }

    println(abandonedTownSquare.description())
    println(abandonedTownSquare.load())
     */
}

class Player15(_name: String,
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
    var currentPosition = Coordinate(0,0)

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


object Game{
    private val player = Player15("Madrigal")
    private var currenRoom :Room = TownSquare()

    private var worldMap = listOf(
            listOf(currenRoom,Room("Tavern"),Room("Back Room")),
            listOf(Room("Long Corridor"),Room("Generic Room"))
    )

    init{
        println("Welcome, adventurer")
        player.castFireball()
    }

    fun play(){
        while(true){
            println(currenRoom.description())
            println(currenRoom.load())

            //Player Status
            printPlayerStatus(player)

            print("> Enter your command: ")
            println("Last command: ${GameInput(readLine()).processCommand()}")
        }
    }

    private fun printPlayerStatus(player: Player15){
        println("(Aura: ${player.auraColor()}) "+
                "(Blessed: ${if(player.isBlessed) "Yes" else "No"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    private class GameInput(args: String?) {
        private val input = args ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1,{ "" })

        fun processCommand() = when(command.toLowerCase()){
            "move" -> move(argument)
            else -> commandNotFound()
        }

        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"
    }

    private fun move(directionInput: String) =
            try{
                val direction = Direction.valueOf(directionInput.toUpperCase())
                val newPosition = direction.updateCoordinate(player.currentPosition)
                if(!newPosition.isInBonds){
                    throw IllegalStateException("$direction is out of bounds.")
                }
                val newRoom = worldMap[newPosition.y][newPosition.x]
                player.currentPosition = newPosition
                currenRoom = newRoom
                "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
            } catch(e: Exception){
                "Invalid direction: $directionInput"
            }
}
