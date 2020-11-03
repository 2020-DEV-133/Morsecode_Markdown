package com.meg.hopintest.morsecode

data class MorseNode(
    var letter: Char?,
    var left: MorseNode?,
    var right: MorseNode?
)