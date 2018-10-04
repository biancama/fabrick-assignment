package com.fabrick.assignment.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by massimo.biancalani on 04/10/2018.
 */
public enum OrderThreshold {
    @JsonProperty("OVER_THRESHOLD")
    OVER_THRESHOLD,
    @JsonProperty("UNDER_THRESHOLD")
    UNDER_THRESHOLD;
}
