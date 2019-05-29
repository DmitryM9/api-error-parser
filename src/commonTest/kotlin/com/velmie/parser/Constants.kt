package com.velmie.parser

object Constants {

    object Message {
        const val DEFAULT = "DEFAULT"
        const val EMPTY_BALANCE = "It seems that user has empty balance"
        const val PUNCTUATION_ERROR = "It seems that the password provided is missing a punctuation character"
        const val PASSWORD_DO_NOT_MATCH = "It seems that the password and password confirmation fields do not match"
    }

    object ErrorCode {
        const val INSUFFICIENT_FUNDS = "insufficient_funds"
        const val INVALID_PUNCTUATION = "invalid_punctuation"
        const val INVALID_PASSWORD_CONFIRMATION = "invalid_password_confirmation"
        const val UNKNOWN = "unknown_code"
    }

    object TARGET {
        const val FIELD = "field"
        const val COMMON = "common"
    }

    const val JSON = """{
  "data":
    {
      "id": 1,
      "userName": "Tom",
      "age": 21
    },
"errors": [
    {
      "code": "insufficient_funds",
      "target": "common",
      "source": {
        "field": "userBalance",
      },
      "message": "Hi Nick, it seems that user has empty balance"
    },
    {
      "code": "invalid_punctuation",
      "target": "field",
      "source": {
        "field": "userPassword"
      },
      "message": "Hi Vova, it seems that the password provided is missing a punctuation character"
    },
    {
      "code": "unknown_code",
      "target": "common",
      "source": {
        "field": "serverError",
      },
      "message": "Oh no! Something went wrong"
    }
    {
      "code": "invalid_password_confirmation",
      "target": "field",
      "source": {
        "field": "userPassword",
      },
      "message": "Hi Lesha, it seems that the password and password confirmation fields do not match"
    },
  ]
}"""
}