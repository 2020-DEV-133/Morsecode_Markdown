package com.meg.hopintest.morsecode

import java.io.File
import java.io.FileNotFoundException
import java.util.*

class MorseDecoder : MorseCode {

    var root: MorseNode
    private var EMPTY: Char = ' '

    init {
        root = MorseNode(EMPTY, null, null)
        readTreeInfo()
    }

    fun readTreeInfo() {
        var input: Scanner? = null
        try {
            input = Scanner(File("C:\\Users\\debin\\StudioProjects\\HopinTest\\morsecode.txt"))
        } catch (exception: FileNotFoundException) {
            println("File not found!")
        }
        while (input!!.hasNextLine()) {
            val data: String = input.nextLine().trim()
            if (data.length > 0) {
                add(data.substring(1).trim { it <= ' ' }, data[0])
            }
        }
        input.close()
    }


    override fun add(mcode: String, ltr: Char) {
        var current: MorseNode? = root
        var signal = " "
        for (i in 0 until mcode.length) {
            signal = mcode.substring(i, i + 1)
            if (signal == ".") {
                if (current!!.left != null) {
                    current = current.left
                } else {
                    current.left = MorseNode(EMPTY, null, null)
                    current = current.left
                }
            } else {
                if (current!!.right != null) {
                    current = current.right
                } else {
                    current.right = MorseNode(EMPTY, null, null)
                    current = current.right
                }
            }
        }
        current!!.letter = ltr
        println("Current letter :: ${current!!.letter}")
    }


    fun morseHelper(input: String, currentLevel: Int, tree: MorseNode?): String {
        if (tree == null) {
            return ""
        }
        if (currentLevel == input.length)
            return tree?.letter.toString()
        var aux = currentLevel
        aux = aux + 1
        if (input[currentLevel] == '?') {
            return morseHelper(input, aux, tree?.left) + morseHelper(input, aux, tree?.right)
        }
        if (input[currentLevel] == '.') {
            return morseHelper(input, aux, tree?.left)
        }
        return morseHelper(input, aux, tree?.right)
    }
}

fun main() {
    val morseDecoder = MorseDecoder()
    var code1: String = "?.."
    println("Result :: ${morseDecoder.morseHelper(code1, 0, morseDecoder.root)}")
}

