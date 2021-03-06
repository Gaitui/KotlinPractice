open class Room(val name: String)
{
    /*---14_1---
    fun description() = "Room: $name"
    */

    protected open val dangerLevel = 5

    fun description() = "Room: $name\n" +
            "Danger level : $dangerLevel"

    open fun load() = "Nothing much to see here"
}

open class TownSquare : Room("Town Square")
{
    override val dangerLevel: Int = super.dangerLevel - 3
    private var bellSound = "GWONG"

    override open fun load() = "The villagers rally and cheer as you enter!\n${ringBell()}"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}
