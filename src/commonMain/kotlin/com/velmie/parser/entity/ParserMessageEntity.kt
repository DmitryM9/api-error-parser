package com.velmie.parser.entity

import com.velmie.parser.entity.response.ErrorSourceInterface

data class ParserMessageEntity(
    val target: String,
    val source: ErrorSourceInterface?,
    val code: String,
    val message: String
)