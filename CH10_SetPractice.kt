fun main(args: Array<String>)
{
    val planet = mutableSetOf("Mercury", "Venus", "Earth", "Earth")
    println(planet)
    println("Planet contain Earth :${planet.contains("Earth")}.")
    println("Planet contain Pluto :${planet.contains("Pluto")}.")
    println(planet.elementAt(2))
    planet.add("Pluto")
    println(planet)
    planet.add("Earth")
    println(planet)
}
