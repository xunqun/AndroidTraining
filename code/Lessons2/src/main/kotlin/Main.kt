package com.whiles.lessons

import kotlin.random.Random


fun main() {

    val info = askBasicInformation()
    val ability = rollDiceForAbility()

    val hero = Player(info[0], info[1].toInt()).apply {
        str = ability[0]
        dex = ability[1]
        int = ability[2]
    }

    showState(hero)

    val npc = Npc("哥布林", 1)
    hero.attack(npc)
}

fun showState(role: Role) {
    println("\n---- Hero information ----")
    println("name : ${role.name}")
    println("age : ${role.age}")
    println("classes: ${role.classes.cname}")
    println("ability: STR=${role.str} DEX=${role.dex} INT=${role.int}")
    println("---------------------------")
}

fun rollDiceForAbility(): Array<Int> {
    var str: Int
    var dex: Int
    var int: Int

    do {
        str = Random.nextInt(1, 5)
        dex = Random.nextInt(1, 5)
        int = Random.nextInt(1, 5)

        val total = str + dex + int
        val evaluate = when {
            total < 5 -> "Bad"
            (total in 5..8) -> "So-so"
            total in 9..11 -> "Good"
            else -> "Perfect"
        }

        println("Your ability is STR=${str} DEX=${dex} INT=${int} evaluate-> $evaluate")
        println("Do you want to save your ability?(Y/N)")
        val ok: Boolean = readLine() == "Y"
    } while (!ok)
    return arrayOf(str, dex, int)
}

fun askBasicInformation(): Array<String> {
    var name: String?
    var age: String?
    do {
        println("What is your name?")
        name = readLine()
    } while (name == null)

    do {
        println("How old are you?")
        age = readLine()
    } while (age == null)
    println("Hi $name, welcome to the world~\n")

    return arrayOf(name, age)
}

