package com.traveltime.sdk.dto.responses.timemapfast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.traveltime.sdk.dto.common.Shape;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder
@Jacksonized
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    String searchId;
    List<Shape> shapes;
}
