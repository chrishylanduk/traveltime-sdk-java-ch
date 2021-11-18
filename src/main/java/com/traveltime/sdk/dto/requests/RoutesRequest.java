package com.traveltime.sdk.dto.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.traveltime.sdk.AcceptType;
import com.traveltime.sdk.JsonUtils;
import com.traveltime.sdk.dto.common.Location;
import com.traveltime.sdk.dto.requests.routes.ArrivalSearch;
import com.traveltime.sdk.dto.requests.routes.DepartureSearch;
import com.traveltime.sdk.dto.responses.RoutesResponse;
import com.traveltime.sdk.dto.responses.errors.TravelTimeError;
import io.vavr.control.Either;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import okhttp3.Request;

import java.util.List;

@Value
@Builder
@Jacksonized
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoutesRequest extends TravelTimeRequest<RoutesResponse> {
    @NonNull
    List<Location> locations;
    @Valid
    List<DepartureSearch> departureSearches;
    @Valid
    List<ArrivalSearch> arrivalSearches;

    @Override
    public Either<TravelTimeError, Request> createRequest(String appId, String apiKey) {
        String uri = "https://api.traveltimeapp.com/v4/routes";
        return JsonUtils
            .toJson(this)
            .map(json -> createPostRequest(uri, appId, apiKey, json, AcceptType.APPLICATION_JSON));
    }

    @Override
    public Class<RoutesResponse> responseType() {
        return RoutesResponse.class;
    }
}
