package com.parser.entity

data class ParserResponseEntity<T>(val data: T?, val errors: Array<ErrorMessageEntity>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ParserResponseEntity<*>

        if (data != other.data) return false
        if (!errors.contentEquals(other.errors)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data?.hashCode() ?: 0
        result = 31 * result + errors.contentHashCode()
        return result
    }
}