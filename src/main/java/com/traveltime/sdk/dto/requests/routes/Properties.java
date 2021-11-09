package com.traveltime.sdk.dto.requests.routes;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Properties {
    @JsonProperty("travel_time")
    TRAVEL_TIME,
    @JsonProperty("distance")
    DISTANCE,
    @JsonProperty("route")
    ROUTE,
    @JsonProperty("fares")
    FARES,
    @JsonProperty("distance_breakdown")
    DISTANCE_BREAKDOWN
}
