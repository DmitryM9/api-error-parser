/*
package com.velmie.parser

import com.velmie.parser.entity.ParserMessageEntity
import com.velmie.parser.entity.response.ErrorMessageInterface
import com.velmie.parser.entity.response.ErrorSourceInterface
import com.velmie.parser.entity.response.ResponseInterface
import kotlinx.serialization.Serializable
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ParserTests {

    private val parser: ErrorParser = ErrorParser(
        mapOf(
            Pair(Constants.ErrorCode.INSUFFICIENT_FUNDS, Constants.Message.EMPTY_BALANCE),
            Pair(Constants.ErrorCode.INVALID_PASSWORD_CONFIRMATION, Constants.Message.PASSWORD_DO_NOT_MATCH),
            Pair(Constants.ErrorCode.INVALID_PUNCTUATION, Constants.Message.PUNCTUATION_ERROR)
        ), Constants.Message.DEFAULT
    )

    private var response: ResponseInterface<DataEntity>? = null

    @UnstableDefault
    @BeforeTest
    fun initJson() {
        response = Json.parse(ResponseEntity.serializer(), Constants.JSON)
    }

    @Test
    fun testMessageFromCode() {
        assertEquals(parser.getMessage(Constants.ErrorCode.INVALID_PUNCTUATION), Constants.Message.PUNCTUATION_ERROR)
        assertEquals(parser.getMessage(Constants.ErrorCode.UNKNOWN), Constants.Message.DEFAULT)
    }

    @Test
    fun testFirstErrorMessage() {
        assertEquals(parser.getFirstMessage(response!!.errors), Constants.Message.EMPTY_BALANCE)
        val errors = response!!.errors.toMutableList()
        errors.add(0, response!!.errors[2])
        assertEquals(parser.getFirstMessage(errors), Constants.Message.DEFAULT)
    }

    @Test
    fun testMessage() {
        assertEquals(parser.getMessage(response!!.errors.last()), Constants.Message.PASSWORD_DO_NOT_MATCH)
        assertEquals(parser.getMessage(response!!.errors[2]), Constants.Message.DEFAULT)
    }

    @Test
    fun testListError() {
        checkErrorList(parser.getErrors(response!!.errors))
    }

    @Test
    fun testParsing() {
        val parserResponse = parser.parse(response!!)

        assertEquals(response!!.data, parserResponse.data)

        checkErrorList(parserResponse.errors)
    }

    private fun checkErrorList(parserErrors: List<ParserMessageEntity>) {
        response?.run {

            assertEquals(errors[0].code, parserErrors[0].code)
            assertEquals(errors[1].code, parserErrors[1].code)
            assertEquals(errors[2].code, parserErrors[2].code)
            assertEquals(errors[3].code, parserErrors[3].code)

            assertEquals(parserErrors[0].message, Constants.Message.EMPTY_BALANCE)
            assertEquals(parserErrors[1].message, Constants.Message.PUNCTUATION_ERROR)
            assertEquals(parserErrors[2].message, Constants.Message.DEFAULT)
            assertEquals(parserErrors[3].message, Constants.Message.PASSWORD_DO_NOT_MATCH)

            assertNotNull(parserErrors[0].source)
            assertNotNull(parserErrors[3].source)
        }
    }

}

@Serializable
private data class DataEntity(val id: Int, val userName: String, val age: Int)

@Serializable
data class ErrorMessageEntity(
    override val code: String,
    override val target: String,
    override val source: ErrorSourceEntity? = null,
    override val message: String
) : ErrorMessageInterface

@Serializable
data class ErrorSourceEntity(override val field: String? = null) : ErrorSourceInterface

@Serializable
private data class ResponseEntity(override val data: DataEntity?, override val errors: List<ErrorMessageEntity>) :
    ResponseInterface<DataEntity>*/
