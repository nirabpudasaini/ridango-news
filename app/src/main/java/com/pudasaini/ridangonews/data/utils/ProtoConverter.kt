package com.pudasaini.ridangonews.data.utils

import com.pudasaini.ridangonews.data.model.ArticleDto
import com.pudasaini.ridangonews.data.model.SourceDto
import com.pudasaini.ridangonews.proto.ArticleProto

object ProtoConverter {

    fun ArticleDto.toProto(): ArticleProto.Article{
        return ArticleProto.Article.newBuilder()
            .setTitle(title)
            .setUrl(url)
            .setImageUrl(urlToImage.orEmpty())
            .setPublishedAt(publishedAt)
            .setDescription(description.orEmpty())
            .setContent(content.orEmpty()).setSource(source.toProto())
            .build()
    }

    private fun SourceDto.toProto(): ArticleProto.Article.Source {
        return ArticleProto.Article.Source.newBuilder()
            .setName(name).build()
    }
}