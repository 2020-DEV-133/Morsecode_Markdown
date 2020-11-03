package com.meg.hopintest

import com.meg.hopintest.morsecode.MorseNode
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class MorseNodeTest {

    @Test
    fun morseNodeInitiates() {
        val morseNode = MorseNode(null, null, null)
        assertEquals(morseNode, morseNode)
    }
}