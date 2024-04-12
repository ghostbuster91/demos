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
        @httpPayload
        @required
        map: StringMap
    }
    output := {
        @required
        weather: String
    }
}

@sparse
map StringMap {
    key: String
    @length(min: 2)
    value: String
}
