package com.parser.entity.response

interface ApiResponseInterface<T> {
    val data: T?
    val errors: Array<ApiErrorMessageEntity>
}