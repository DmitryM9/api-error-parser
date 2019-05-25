package com.parser.entity.response

data class ApiErrorMessageEntity(
    val code: String,
    val target: String,
    val source: ErrorSourceInterface?,
    val message: String
)