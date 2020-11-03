package com.meg.hopintest

import com.meg.hopintest.morsecode.MorseDecoder
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.File
import java.io.FileNotFoundException
import java.util.*


class MorseDecoderTest {

    private lateinit var morseDecoder: MorseDecoder

    @Before
    fun setUp() {
        morseDecoder = MorseDecoder()
    }

    @Test
    fun readDataFromFileTest() {
        val input = getMorseTextFile()
        while (input!!.hasNextLine()) { val data : String = input.nextLine().trim()
         assertEquals(true, data.length>0)
         assertEquals(data[0], data[0])
     }
    }

    @Test
    fun decodeTest() {
        var code : String = "-.."
        var actualResult = "D"
        val result = morseDecoder.morseHelper(code, 0, morseDecoder.root)
        println("value of result :: ${morseDecoder.morseHelper(code, 0, morseDecoder.root)}")
        assertEquals(actualResult,result)
    }

    @Test
    fun decodeTestNotReliable() {
        var code : String = "?.."
        var actualResult = "SD"
        val result = morseDecoder.morseHelper(code, 0, morseDecoder.root)
        println("value of result :: ${morseDecoder.morseHelper(code, 0, morseDecoder.root)}")
        assertEquals(actualResult, result)
    }

    fun getMorseTextFile() : Scanner? {
        var input: Scanner? = null
        try {
            input = Scanner(File("C:\\Users\\debin\\StudioProjects\\HopinTest\\morsecode.txt"))
        } catch (exception: FileNotFoundException) {
            println("File not found!")
        }
        return input
    }
}