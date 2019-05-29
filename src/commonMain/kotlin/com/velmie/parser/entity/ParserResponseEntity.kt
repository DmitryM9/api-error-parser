package com.velmie.parser.entity

data class ParserResponseEntity<T>(val data: T?, val errors: List<ParserMessageEntity>)