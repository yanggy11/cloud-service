package com.yanggy.cloud.kothlin.test;

/**
 *@author derrick.yang
 *@Date 24/10/2018 22:23
 */
data class Person constructor(var name: String) {
    var age: Int
    init {
        name = ""
        age = 0
    }

    constructor( name: String,  age: Int) : this(name) {
        this.name = name
        this.age = age
    }

    constructor(age : Int) : this("") {
        this.age = age
    }
}