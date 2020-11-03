package com.meg.hopintest.markdowntohtml

import android.text.Html
import org.xml.sax.Parser


class Markdown {

     var regexMatch : MatchResult?= null
     var lastLetter : Char = ' '
     lateinit var newMarkdownText : String
     lateinit var output : String
     lateinit var errorMgs : String


    fun getHTMLHead(s : String, count : Int?) : String {
        println("The header Text :: ${s}Hai")
        when(count) {
            2 -> {
                return "<h1>$s<h1>"
            }
            3 -> {
                return "<h2>$s<h2>"
            }
            4 -> {
                return "<h3>$s<h3>"
            }
            5 -> {
                return "<h4>$s<h4>"
            }
            6 -> {
                return "<h5>$s<h5>"
            }
            7 -> {
                return "<h6>$s<h6>"
            }
            else -> {
                return ""
            }
        }
    }

    fun validationMarkdown(markdownText: String){
        val regex3 = ("[#]{1,}\\s").toRegex()
        regexMatch = regex3.find(markdownText)
        val count = regexMatch?.value?.count()
        newMarkdownText = markdownText.replace(regex3, "").trim()
        val length = newMarkdownText.length
        lastLetter = newMarkdownText.get(length-1)

        if(regexMatch?.value!=null) {
            if(lastLetter!='#' && count!! <= 7) {
                output = getHTMLHead(newMarkdownText, regexMatch?.value?.count())
                println("Convert to HTML :: ${output}")
            } else {
                if(count!! > 7) {
                    errorMgs = "To many hashes"
                    println("Error is :: ${errorMgs}")
                } else {
                    errorMgs = "Invalid Input"
                    println("Error is :: ${errorMgs}")
                }
            }
        } else {
            errorMgs = "Invalid Input"
            println("Error is :: ${errorMgs}")
        }

    }

}

fun main() {
    val markdown = Markdown()
    val markdowmText = "#### This is testing"
    markdown.validationMarkdown(markdowmText)
}
