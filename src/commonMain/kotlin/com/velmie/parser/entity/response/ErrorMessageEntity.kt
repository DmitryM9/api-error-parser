package com.velmie.parser.entity.response

data class ErrorMessageEntity(
    val code: String,
    val target: String,
    val source: ErrorSourceInterface?,
    val message: String
)