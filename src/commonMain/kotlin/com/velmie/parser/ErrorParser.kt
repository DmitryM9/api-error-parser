package com.velmie.parser

import com.velmie.parser.entity.ParserMessageEntity
import com.velmie.parser.entity.ParserResponseEntity
import com.velmie.parser.entity.response.ErrorMessageEntity
import com.velmie.parser.entity.response.ResponseInterface

class ErrorParser (val errorMessages: Map<String, String>, val defaultErrorMessage: String) {

    fun <T> parse(response: ResponseInterface<T>): ParserResponseEntity<T> {
        return ParserResponseEntity(response.data, errors = getErrors(response.errors))
    }

    fun getErrors(errors: Array<ErrorMessageEntity>): Array<ParserMessageEntity> {
        return Array(errors.size, init = { index ->
            errors[index].run {
                ParserMessageEntity(target, source, code, getMessage(code))
            }
        })
    }

    fun getMessage(errorCode: String): String {
        return errorMessages[errorCode] ?: defaultErrorMessage
    }

    fun getMessage(errorMessage: ErrorMessageEntity): String {
        return errorMessages[errorMessage.code] ?: defaultErrorMessage
    }

    fun getFirstMessage(errors: List<ErrorMessageEntity>): String {
        return getMessage(errors.first())
    }
}
