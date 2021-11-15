package com.traveltime.sdk.dto.common.route;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.traveltime.sdk.dto.common.Coordinates;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;

import java.util.Date;
import java.util.List;

@Getter
@Jacksonized
@Builder
@AllArgsConstructor
public class PublicTransportPart implements Part {
    int id;
    @NonNull
    String mode;
    @NonNull
    String directions;
    @Positive(message = "distance must be greater than 0")
    int distance;
    @Positive(message = "travelTime must be greater than 0")
    int travelTime;
    @NonNull
    List<Coordinates> coords;
    @NonNull
    String line;
    @NonNull
    String departureStation;
    @NonNull
    String arrivalStation;
    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    Date departsAt;
    @NonNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    Date arrivesAt;
    int numStops;
}
