package com.example.twoactivities

import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    val driver = mockk<Driver>(relaxed = true, relaxUnitFun = true)


    @Test
    fun addition_isCorrect() {


        assertEquals(4, 2 + 2)
    }

    @Test
    fun carTest() {
//        every { car.getName() } returns "くるま"

        val car = Car(driver)
        car.getDriverName()
        verify { driver.getName() }
    }
}