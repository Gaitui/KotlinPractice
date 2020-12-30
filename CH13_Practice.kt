fun main(args: Array<String>)
{
    var sword = Sword("Excalibur")
    println(sword.name)
    sword.name = "Gleipnir"
    println(sword.name)

    var swordOne = SwordOne("Excalibur")
    println(swordOne.name)
}

class Sword(_name: String)
{
    var name=_name
        get() = "The Legendary $field"
        set(value) {
            field = value.toLowerCase().reversed().capitalize()
        }
}

class SwordOne(_name: String)
{
    var name=_name
        get() = "The Legendary $field"
        set(value) {
            field = value.toLowerCase().reversed().capitalize()
        }
    init{
        name = _name
    }
}
