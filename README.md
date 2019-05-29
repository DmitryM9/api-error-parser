#Error Parser
Library for handling errors in the application based on codes.
The code is written in Kotlin/Native with compilation under JVM/Android, JS, Swift.

**For processing, the errors must comply with the standard:**
Each error from server should be in next format:

- ***code***: a unique code of an error. Used to identify error from the dictionary.
- ***target***: some sort of error scope
- ***field*** - the error related to certain field
- ***common*** - the error related to whole request
- ***message (OPTIONAL)***: the error message for developers (use it only for debug purposes)
- ***source (OPTIONAL)***: a container for additional data. Arbitrary structure: ( field: resource object attribute name. Required if target set to field. )

Example:
```json
{
"data": [
     {
       "id": 1,
       "userName": "Tom",
       "age": 21
     },
     {
       "id": 2,
       "userName": "Bob",
       "age": 22
     }
   ],
  "errors": [
    {
      "code": "insufficient_funds",
      "target": "common",
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
      "code": "invalid_password_confirmation",
      "target": "field",
      "source": {
        "field": "userPassword",
        "someAdditionalData": "bla bla bla"
      },
      "message": "Hi Lesha, it seems that the password and password confirmation fields do not match"
    }
  ]
 }
```
###Version

0.0.1



How it works
-------------
The library provides ready-made interfaces for server responses to which the object passed to the parmer must correspond.

To initialize the ErrorParser, you must pass to the constructor:
  errorMessages: 
- [Map<String, String>] - the key is the error code and the value of the displayed message
- [defaultErrorMessage]: String - message of unknown errors


**Api parser description:**
- `parse(response: ResponseInterface<T>)` - parses the server response object and returns the processed result
- `getErrors(errors: List<ErrorMessageInterface>)` - returns a list of processed errors
- `getMessage(errorCode: String)` - returns the message associated with this error code
- `getMessage(errorMessage: ErrorMessageInterface)` - returns the processed error
- `getFirstMessage(errors: List<ErrorMessageInterface>)` - returns the first processed error from the list

JVM/Android(Kotlin)
-------------

```kotlin
val errorParser = ErrorParser(resource.getStringArray(R.array.error_code)
                              .zip(resource.getStringArray(R.array.error_message)).toMap(),
                              resource.getString(R.string.something_went_wrong))
               
val parserResponse: ParserResponseEntity<UserEntity> = errorParser.parse(serverResponse)
                              
                              
```
Add it in your **root build.gradle** at the end of repositories:
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
Then, add the Error Parser library to your **app's build.gradle**:
```groovy
dependencies {
         ...
	 implementation 'com.github.velmie:api-error-parser:Tag'
}
```