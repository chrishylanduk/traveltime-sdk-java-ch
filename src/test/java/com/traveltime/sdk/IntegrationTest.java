package com.traveltime.sdk;

import com.traveltime.sdk.dto.common.Coordinates;
import com.traveltime.sdk.dto.common.transportation.PublicTransport;
import com.traveltime.sdk.dto.common.transportation.Transportation;
import com.traveltime.sdk.dto.requests.TimeFilterRequest;
import com.traveltime.sdk.dto.requests.TimeMapRequest;
import com.traveltime.sdk.dto.requests.timemap.DepartureSearch;
import com.traveltime.sdk.dto.responses.HttpResponse;
import com.traveltime.sdk.dto.responses.TimeFilterResponse;
import com.traveltime.sdk.dto.responses.TimeMapResponse;
import com.traveltime.sdk.exceptions.RequestValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class IntegrationTest {
    TravelTimeSDK sdk;

    @Before
    public void init() {
        sdk = new TravelTimeSDK("ed0b2f22", "4d5366b527c0e3868ee1546e70f6eb90");
    }

    @Test
    public void shouldSendTimeFilterRequest() throws IOException, RequestValidationException {
        String requestJson = Common.readFile("dto/requests/timeFilterRequest.json");
        TimeFilterRequest timeFilterRequest = JsonUtils.fromJson(requestJson, TimeFilterRequest.class);
        HttpResponse<TimeFilterResponse> timeFilterResponse = sdk.send(timeFilterRequest);

        Assert.assertEquals(200, (int) timeFilterResponse.getHttpCode());
        Assert.assertNotNull(timeFilterResponse.getParsedBody());
    }

    @Test
    public void shouldSendTimeMapRequest() throws IOException, RequestValidationException {
        String requestJson = Common.readFile("dto/requests/timeMapRequest.json");
        TimeMapRequest timeMapRequest = JsonUtils.fromJson(requestJson, TimeMapRequest.class);
        HttpResponse<TimeMapResponse> timeMapResponse = sdk.send(timeMapRequest);

        Assert.assertEquals(200, (int) timeMapResponse.getHttpCode());
        Assert.assertNotNull(timeMapResponse.getParsedBody());
    }

    @Test
    public void shouldSendAsyncTimeMapRequest() throws ExecutionException, InterruptedException, IOException, RequestValidationException {
        String departureId = "public transport from Trafalgar Square";
        Coordinates departureCoords = new Coordinates(51.507609,-0.128315);
        Transportation transportation = PublicTransport
            .builder()
            .walkingTime(30)
            .build();
        Date departureDate = Date.from(Instant.now());

        DepartureSearch ds = new DepartureSearch(departureId, departureCoords, transportation, departureDate, 1800);

        TimeMapRequest timeMapRequest = TimeMapRequest
            .builder()
            .departureSearches(Collections.singletonList(ds))
            .build();

        CompletableFuture<HttpResponse<TimeMapResponse>> responseFuture = sdk.sendAsync(timeMapRequest);
        HttpResponse<TimeMapResponse> response = responseFuture.get();

        Assert.assertEquals(200, (int)response.getHttpCode());
        Assert.assertNotNull(response.getParsedBody());
    }
}
