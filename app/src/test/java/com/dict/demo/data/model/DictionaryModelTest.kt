package com.news.demo.data.model

import com.dict.demo.data.model.DictionaryModel
import org.junit.After
import org.junit.Assert
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.junit.Before
import org.junit.Test

class DictionaryModelTest {
    private val author = "Testing author"
    private val thumbsDown = 1
    private val thumbsUp = 3
    private val definition = "definition"

    @Mock
    var dictionaryModel: DictionaryModel? = null

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Mockito.`when`(dictionaryModel?.author).thenReturn(author)
        Mockito.`when`(dictionaryModel?.thumbsDown).thenReturn(thumbsDown)
        Mockito.`when`(dictionaryModel?.thumbsUp).thenReturn(thumbsUp)
        Mockito.`when`(dictionaryModel?.definition).thenReturn(definition)
    }

    @Test
    fun testNewsAuthor() {
        Mockito.`when`(dictionaryModel?.author).thenReturn(author)
        Assert.assertEquals("Testing author", dictionaryModel?.author)
    }

    @Test
    fun testNewsThumbsDown() {
        Mockito.`when`(dictionaryModel?.thumbsDown).thenReturn(thumbsDown)
        Assert.assertEquals("Testing thumbsDown", dictionaryModel?.thumbsDown)
    }

    @Test
    fun testNewsThumbsUp() {
        Mockito.`when`(dictionaryModel?.thumbsUp).thenReturn(thumbsUp)
        Assert.assertEquals("Testing thumbsUp", dictionaryModel?.thumbsUp)
    }

    @Test
    fun testNewsDefinition() {
        Mockito.`when`(dictionaryModel?.definition).thenReturn(definition)
        Assert.assertEquals("definition", dictionaryModel?.definition)
    }


    @Test
    fun testNewsAuthorIncorrect() {
        Mockito.`when`(dictionaryModel?.author).thenReturn(author)
        Assert.assertEquals("Testing author", dictionaryModel?.author)
    }

    @Test
    fun testNewsThumbsUpIncorrect() {
        Mockito.`when`(dictionaryModel?.thumbsUp).thenReturn(thumbsUp)
        Assert.assertEquals("Testing thumbsUp", dictionaryModel?.thumbsUp)
    }

    @Test
    fun testNewsThumbsDownIncorrect() {
        Mockito.`when`(dictionaryModel?.thumbsDown).thenReturn(thumbsDown)
        Assert.assertEquals("www.google.com/image", dictionaryModel?.thumbsDown)
    }

    @Test
    fun testNewsDefinitionIncorrect() {
        Mockito.`when`(dictionaryModel?.definition).thenReturn(definition)
        Assert.assertEquals("Testing definition", dictionaryModel?.definition)
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        dictionaryModel = null
    }
}