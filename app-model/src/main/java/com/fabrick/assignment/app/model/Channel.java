package com.fabrick.assignment.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by massimo.biancalani on 04/10/2018.
 */
public enum Channel {
    @JsonProperty("CARD")
    CARD("CARD"),
    @JsonProperty("MONEYTRANSFER")
    MONEYTRANSFER("MONEYTRANSFER"),
    @JsonProperty("wiretransfer")
    wiretransfer("wiretransfer");

    private final String formatted;

    Channel(String formatted) {
        this.formatted = formatted;
    }

    @Override
    public String toString() {
        return formatted;
    }
}
