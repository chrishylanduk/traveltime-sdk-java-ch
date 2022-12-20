package com.traveltime.sdk.dto.requests.timemapfast;

import com.traveltime.sdk.dto.common.Coordinates;
import com.traveltime.sdk.dto.requests.timemapfast.levelofdetail.LevelOfDetail;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
@AllArgsConstructor
public class OneToMany {
    @NonNull
    String id;
    @NonNull
    Coordinates coords;
    @NonNull
    String arrivalTimePeriod;
    @NonNull
    Integer travelTime;
    @NonNull
    LevelOfDetail levelOfDetail;
    @NonNull
    Transportation transportation;
}
