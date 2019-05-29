package com.velmie.parser

import com.velmie.parser.entity.ParserMessageEntity
import com.velmie.parser.entity.ParserResponseEntity
import com.velmie.parser.entity.response.ErrorMessageInterface
import com.velmie.parser.entity.response.ResponseInterface

class ErrorParser(val errorMessages: Map<String, String>, val defaultErrorMessage: String) {

    fun <T> parse(response: ResponseInterface<T>): ParserResponseEntity<T> {
        return ParserResponseEntity(response.data, errors = getErrors(response.errors))
    }

    fun getErrors(errors: List<ErrorMessageInterface>): List<ParserMessageEntity> {
        return errors.map { ParserMessageEntity(it.target, it.source, it.code, getMessage(it.code)) }
    }

    fun getMessage(errorCode: String): String {
        return errorMessages[errorCode] ?: defaultErrorMessage
    }

    fun getMessage(errorMessage: ErrorMessageInterface): String {
        return errorMessages[errorMessage.code] ?: defaultErrorMessage
    }

    fun getFirstMessage(errors: List<ErrorMessageInterface>): String {
        return getMessage(errors.first())
    }
}
