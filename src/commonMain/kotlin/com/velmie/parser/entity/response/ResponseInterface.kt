package com.velmie.parser.entity.response

interface ResponseInterface<T> {
    val data: T?
    val errors: Array<ErrorMessageEntity>
}