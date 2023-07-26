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

@mixin
structure Extra {
    @deprecated
    @required
    name: String
}

structure Greeting with [Extra] {
    @required
    message: String
}
