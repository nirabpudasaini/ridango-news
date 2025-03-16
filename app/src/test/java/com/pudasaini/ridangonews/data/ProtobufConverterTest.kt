package com.pudasaini.ridangonews.data

import com.pudasaini.ridangonews.data.model.ArticleDto
import com.pudasaini.ridangonews.data.model.SourceDto
import com.pudasaini.ridangonews.data.utils.ProtoConverter.toProto
import org.junit.Assert.assertEquals
import org.junit.Test

class ProtobufConverterTest {
    @Test
    fun `article to proto conversion preserves essential fields`() {
        val testArticle = ArticleDto(
            title = "Test Title",
            source = SourceDto("Test","Test Source"),
            url = "https://example.com",
            publishedAt = "2025-01-01T12:00:00Z",
            description = "Test Description",
            content = "Test Content",
            author = null,
            urlToImage = "https://example.com/image.png"
        )

        val protoArticle = testArticle.toProto()

        assertEquals(testArticle.title, protoArticle.title)
        assertEquals(testArticle.source.name, protoArticle.source.name)
        assertEquals(testArticle.publishedAt, protoArticle.publishedAt)
        assertEquals(testArticle.description, protoArticle.description)
    }
}