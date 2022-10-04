package com.traveltime.sdk.dto.responses;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class TimeFilterProtoResponse {
    @NonNull
    List<Integer> travelTimes;
}
