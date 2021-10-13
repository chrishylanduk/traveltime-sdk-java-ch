package com.traveltime.sdk.dto.responses;

import com.traveltime.sdk.dto.responses.timefilter.Result;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TimeFilterResponse {
    Iterable<Result> results;
}
