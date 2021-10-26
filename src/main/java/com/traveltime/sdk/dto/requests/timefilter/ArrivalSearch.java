package com.traveltime.sdk.dto.requests.timefilter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.traveltime.sdk.dto.common.transportation.Transportation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ArrivalSearch {
    String id;
    Iterable<String> departureLocationIds;
    String arrivalLocationId;
    Transportation transportation;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    Date arrivalTime;
    @Positive(message = "travelTime must be greater than 0")
    Integer travelTime;
    Iterable<String> properties;
}
