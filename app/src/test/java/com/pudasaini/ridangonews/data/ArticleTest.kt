package com.pudasaini.ridangonews.data

import com.pudasaini.ridangonews.data.model.ArticleDto
import com.pudasaini.ridangonews.data.model.SourceDto
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class ArticleTest {
    @Test
    fun `article should have valid default values for nullable fields`() {
        val article = ArticleDto(
            title = "Test Title",
            source = SourceDto(null,"Test Source"),
            url = "https://example.com",
            urlToImage = null,
            publishedAt = "2023-01-01",
            description = null,
            author = null,
            content = null
        )

        assertNull(article.urlToImage)
        assertNull(article.description)
        assertNull(article.content)
        assertNull(article.author)
        assertNull(article.source.id)
        assertEquals("Test Source", article.source.name)
    }
}