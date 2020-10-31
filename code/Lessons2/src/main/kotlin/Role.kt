package com.whiles.lessons

class Role(val name: String, val age: Int) {

    enum class Classes(val cname: String){
        Novice("初心者"), Swordman("劍士"), Mage("魔法師"), Archer("弓箭手"), Thief("盜賊")
    }

    /**
     * The classes of the role
     */
    var classes: Classes = Classes.Novice

    /**
     * Strength of the role that affect the attack value
     */
    var str: Int = 0

    /**
     * Dexterity of the role
     */
    var dex: Int = 0

    /**
     * Intelligent of the role
     */
    var int: Int = 0

}