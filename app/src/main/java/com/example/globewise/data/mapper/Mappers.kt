package com.example.globewise.data.mapper

import com.example.globewise.data.local.ArticleEntity
import com.example.globewise.data.local.SourceEntity
import com.example.globewise.data.remote.response.ArticleDto
import com.example.globewise.domain.Article
import com.example.globewise.domain.Source

fun ArticleDto.toEntity(): ArticleEntity {
    return ArticleEntity(
        author = this.author,
        content = this.content,
        description = this.description,
        publishedAt = this.publishedAt,
        source = SourceEntity(id = this.source.id, name = this.source.name),
        title = this.title,
        url = this.url,
        urlToImage = this.urlToImage
    )
}
fun ArticleEntity.toArticle(): Article {
    return Article(
        author = this.author,
        content = this.content,
        description = this.description,
        publishedAt = this.publishedAt,
        source = Source(id = this.source.id, name = this.source.name),
        title = this.title,
        url = this.url,
        urlToImage = this.urlToImage
    )
}
