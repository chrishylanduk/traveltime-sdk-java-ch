package com.traveltime.sdk.dto.requests;

import com.traveltime.sdk.AcceptType;
import com.traveltime.sdk.JsonUtils;
import com.traveltime.sdk.dto.common.Location;
import com.traveltime.sdk.dto.responses.SupportedLocationsResponse;
import com.traveltime.sdk.dto.responses.errors.TravelTimeError;
import io.vavr.control.Either;
import lombok.*;
import lombok.extern.jackson.Jacksonized;
import okhttp3.Request;

import java.net.URI;
import java.util.List;


@Value
@Builder
@Jacksonized
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SupportedLocationsRequest extends TravelTimeRequest<SupportedLocationsResponse> {
    @NonNull
    List<Location> locations;

    @Override
    public Either<TravelTimeError, Request> createRequest(URI baseUri, String appId, String apiKey) {
        String uri = baseUri + "supported-locations";
        return JsonUtils
            .toJson(this)
            .map(json -> createPostRequest(uri, appId, apiKey, json, AcceptType.APPLICATION_JSON));
    }

    @Override
    public Class<SupportedLocationsResponse> responseType() {
        return SupportedLocationsResponse.class;
    }
}
