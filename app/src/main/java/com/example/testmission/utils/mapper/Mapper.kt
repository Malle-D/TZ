package com.example.testmission.utils.mapper

import com.example.testmission.data.model.response.Book
import com.example.testmission.data.model.simple.BookModel

fun Book.toSimple(): BookModel = BookModel(
    this.alias,
    this.author,
    this.authorId,
    this.bookId,
    this.categoryId,
    this.comments,
    this.content,
    this.counter,
    this.dislikes,
    this.downloads,
    this.fileName,
    this.image.toString(),
    this.likes,
    this.popularity,
    this.rating,
    this.section,
    this.summary,
    this.title
)