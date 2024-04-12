$version: "2"

namespace hello

use alloy#simpleRestJson

@simpleRestJson
service WeatherService {
    operations: [GetWeather]
}

@http(method: "POST", uri: "/weather")
@readonly
operation GetWeather {
    input := {
        @required
        map: StringList
    }
    output := {
        @required
        weather: String
    }
}

@length(min: 2)
string Email

list StringList {
    @length(min:2)
    member: String
}
