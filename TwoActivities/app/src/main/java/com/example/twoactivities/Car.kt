package com.example.twoactivities

class Car(private val driver: Driver) {


    private val name = "Car"

    fun getName(): String {
        val a = getNa()
        return a
    }

    fun getNa(): String {
        return name
    }

    fun getDriverName(): String {
        driver.getName()
        return ""
    }

}


class Driver {

    private val name = "ore"


    fun getName() {
        name + name
    }
}