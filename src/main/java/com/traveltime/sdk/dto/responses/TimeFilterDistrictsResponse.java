package com.traveltime.sdk.dto.responses;

import com.traveltime.sdk.dto.responses.zones.DistrictsResult;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder
@Jacksonized
@AllArgsConstructor
public class TimeFilterDistrictsResponse {
    @NonNull
    List<DistrictsResult> results;
}
