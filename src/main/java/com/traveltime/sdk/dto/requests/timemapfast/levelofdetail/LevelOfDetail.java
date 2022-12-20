package com.traveltime.sdk.dto.requests.timemapfast.levelofdetail;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "scaleType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SimpleNumericLevelOfDetail.class, name = "simple"),
        @JsonSubTypes.Type(value = SimpleNumericLevelOfDetail.class, name = "simple_numeric"),
        @JsonSubTypes.Type(value = CoarseGridLevelOfDetail.class, name = "coarse_grid"),
})
public interface LevelOfDetail {
}
