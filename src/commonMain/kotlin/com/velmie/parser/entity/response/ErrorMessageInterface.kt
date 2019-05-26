package com.velmie.parser.entity.response

interface ErrorMessageInterface {
    val code: String
    val target: String
    val source: ErrorSourceInterface?
    val message: String
}