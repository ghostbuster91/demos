$version: "2"

namespace hello

use alloy#simpleRestJson

@simpleRestJson
service WeatherService {
    operations: [Hello]
}

@http(method: "POST", uri: "/name", code: 200)
operation Hello {
    output: Greeting
}

structure Greeting {
    @required
    message: String
    @httpResponseCode
    @required
    code: Integer
}
