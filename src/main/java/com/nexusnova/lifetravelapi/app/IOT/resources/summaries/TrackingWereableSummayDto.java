package com.nexusnova.lifetravelapi.app.IOT.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "TrackingWereable (Summary)")
public class TrackingWereableSummayDto {

    @Schema(description = "Id del GPS Tracker")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
