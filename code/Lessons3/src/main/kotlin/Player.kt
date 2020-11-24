package com.whiles.lessons

class Player(name: String, age: Int): Role(name, age) {
    //todo : Add the pocket by collections
    override fun greeting() {
        println("Hi, 我是${classes.cname} $name")
    }

    override fun attack(role: Role) {
        println("${this.name}攻擊${role.name}")
        val value = str + (1 * age)  - dex
        role.injured(value)
    }

    override fun injured(value: Int) {

    }

}