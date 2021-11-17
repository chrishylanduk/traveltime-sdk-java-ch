package com.traveltime.sdk.dto.responses.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;

import java.util.List;
import java.util.Map;

@Getter
@Jacksonized
@Builder
@AllArgsConstructor
public class ResponseError implements TravelTimeError {
    @NonNull
    Integer httpStatus;
    @NonNull
    Integer errorCode;
    @NonNull
    String description;
    @NonNull
    String documentationLink;
    @NonNull
    Map<String, List<String>> additionalInfo;
}
