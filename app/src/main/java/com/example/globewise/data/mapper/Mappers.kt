package com.example.globewise.data.mapper

import com.example.globewise.data.local.ArticleEntity
import com.example.globewise.data.local.SourceEntity
import com.example.globewise.data.remote.response.ArticleDto
import com.example.globewise.data.remote.response.SourceDto
import com.example.globewise.domain.Article
import com.example.globewise.domain.Source

fun ArticleDto.toEntity(): ArticleEntity {
    return ArticleEntity(
        author = this.author,
        content = this.content,
        description = this.description,
        publishedAt = this.publishedAt,
        source = this.source?.toEntity(),
        title = this.title,
        url = this.url,
        urlToImage = this.urlToImage
    )
}

fun SourceDto.toEntity(): SourceEntity {
    return SourceEntity(
        id = this.id,
        name = this.name
    )
}

fun ArticleEntity.toArticle(): Article {
    return Article(
        author = this.author,
        content = this.content ?: "",
        description = this.description,
        publishedAt = this.publishedAt ?: "",
        source = this.source?.toSource() ?: Source("", ""),
        title = this.title ?: "",
        url = this.url ?: "",
        urlToImage = this.urlToImage
    )
}

fun SourceEntity.toSource(): Source {
    return Source(
        id = this.id,
        name = this.name ?: ""
    )
}