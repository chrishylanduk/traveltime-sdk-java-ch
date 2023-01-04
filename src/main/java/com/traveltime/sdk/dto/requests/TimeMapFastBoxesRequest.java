package com.traveltime.sdk.dto.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.traveltime.sdk.auth.TravelTimeCredentials;
import com.traveltime.sdk.dto.requests.timemapfast.ArrivalSearches;
import com.traveltime.sdk.dto.responses.TimeMapFastBoxesResponse;
import com.traveltime.sdk.dto.responses.errors.TravelTimeError;
import com.traveltime.sdk.utils.AcceptType;
import com.traveltime.sdk.utils.JsonUtils;
import io.vavr.control.Either;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import okhttp3.HttpUrl;
import okhttp3.Request;

@Value
@Builder
@Jacksonized
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TimeMapFastBoxesRequest extends TravelTimeRequest<TimeMapFastBoxesResponse> {
    @NonNull
    ArrivalSearches arrivalSearches;

    @Override
    public Either<TravelTimeError, Request> createRequest(HttpUrl baseUri, TravelTimeCredentials credentials) {
        val uri = baseUri.newBuilder().addPathSegments("time-map/fast").build();
        AcceptType acceptType = AcceptType.APPLICATION_BOUNDING_BOXES_JSON;
        return JsonUtils
                .toJson(this)
                .map(json -> createPostRequest(credentials, uri, json, acceptType));
    }

    @Override
    public Class<TimeMapFastBoxesResponse> responseType() {
        return TimeMapFastBoxesResponse.class;
    }
}
