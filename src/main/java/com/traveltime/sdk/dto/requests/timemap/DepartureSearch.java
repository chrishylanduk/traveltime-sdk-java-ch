package com.traveltime.sdk.dto.requests.timemap;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.traveltime.sdk.dto.common.Coordinates;
import com.traveltime.sdk.dto.common.transportation.Transportation;
import jakarta.validation.constraints.Positive;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;


@Getter
@Jacksonized
@SuperBuilder
public class DepartureSearch {
    @NonNull
    String id;
    @NonNull
    Coordinates coords;
    @NonNull
    Transportation transportation;
    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    Date departureTime;
    @Positive(message = "traveltime should be positive")
    Integer travelTime;
}
