package com.meg.hopintest

import com.meg.hopintest.markdowntohtml.Markdown
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class MarkdownTest {

    private lateinit var markdown: Markdown

    @Before
    fun setUp() {
        markdown = Markdown()
    }

    @Test
    fun markdownTextValidationLastLetter() {
        val markdownText = "######## This is test"
        markdown.validationMarkdown(markdownText)
        assertEquals('t', markdown.lastLetter)
    }

    @Test
    fun markdownTextValidation() {
        val markdownText = "####### This is test  "
        markdown.validationMarkdown(markdownText)
        assertEquals(true, markdown.regexMatch?.value?.count()!! > 7)
    }

    @Test
    fun regexMatchTest() {
        val markdownText = "### This is test"
        markdown.validationMarkdown(markdownText)
        assertEquals(4, markdown.regexMatch?.value?.count())
    }

    @Test
    fun `replace given character with empty string and trim`() {
        val markdownText = "    ### This is test   "
        val result = "This is test"
        markdown.validationMarkdown(markdownText)
        assertEquals(result, markdown.newMarkdownText)
    }

    @Test
    fun getHtmlHeadInvalidInput() {
        val markdownText = "###This is test"
        val errorMgs = "Invalid Input"
        markdown.validationMarkdown(markdownText)
        assertEquals(errorMgs, markdown.errorMgs)
    }

    @Test
    fun getHtmlHeadTooManyHashes() {
        val markdownText = "########## This is test"
        val errorMgs = "To many hashes"
        markdown.validationMarkdown(markdownText)
        assertEquals(errorMgs, markdown.errorMgs)
    }

    @Test
    fun getHtmlHeadInvalidInputTest() {
        val markdownText = "This is test"
        val errorMgs = "Invalid Input"
        markdown.validationMarkdown(markdownText)
        assertEquals(errorMgs, markdown.errorMgs)
    }

    @Test
    fun getHtmlHeadTest() {
        val markdownText = "### This is test"
        val actualOutput = "<h3>This is test<h3>"
        markdown.validationMarkdown(markdownText)
        assertEquals(actualOutput, markdown.output)
    }
}