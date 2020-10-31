package com.whiles.lessons

import kotlin.random.Random


fun main() {

    val info = askBasicInformation()
    val ability = rollDiceForAbility()

    println("\n---- Hero information ----")
    println("name : ${info[0]}")
    println("age : ${info[1]}")
    println("classes: Novice")
    println("ability: STR=${ability[0]} DEX=${ability[1]} INT=${ability[2]}")
    println("------------")
}

fun rollDiceForAbility(): Array<Int> {
    var str: Int
    var dex: Int
    var int: Int

    do {
        str = Random.nextInt(1, 5)
        dex = Random.nextInt(1, 5)
        int = Random.nextInt(1, 5)
        println("Your ability is STR=${str} DEX=${dex} INT=${int}")
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

