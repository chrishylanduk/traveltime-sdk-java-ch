package com.traveltime.sdk.dto.responses.timemap;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder
@Jacksonized
@AllArgsConstructor
public class Result {
    String searchId;
    List<Shape> shapes;
    ResponseProperties properties;
}
