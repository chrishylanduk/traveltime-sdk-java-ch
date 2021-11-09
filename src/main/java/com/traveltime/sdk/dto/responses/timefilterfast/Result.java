package com.traveltime.sdk.dto.responses.timefilterfast;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
    @NonNull
    String searchId;
    @NonNull
    Iterable<Location> locations;
    @NonNull
    Iterable<String> unreachable;
}
