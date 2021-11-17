package com.traveltime.sdk.dto.responses.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.io.IOException;

@Getter
@AllArgsConstructor
public class IOError implements TravelTimeError {
    @NonNull
    String errorMsg;
}