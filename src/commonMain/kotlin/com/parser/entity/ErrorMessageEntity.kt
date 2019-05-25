package com.parser.entity

import com.parser.entity.response.ErrorSourceInterface

data class ErrorMessageEntity(val target: String, val source: ErrorSourceInterface?, val message: String)