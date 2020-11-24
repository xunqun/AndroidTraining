package com.whiles.lessons

class Npc(name: String, age: Int): Role(name, age) {
    override fun greeting() {
        println("Hi, I am $name")
    }

    override fun attack(role: Role) {
        println("殺～")
    }

    override fun injured(value: Int) {
        println("${name}:啊～(受到 $value 傷害)")
    }

}