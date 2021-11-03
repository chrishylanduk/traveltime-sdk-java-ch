package com.traveltime.sdk.dto.responses.timemap;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@Builder
public class ResponseProperties {
    Boolean isOnlyWalkingProperty;
    Iterable<Agency> agencies;
}
