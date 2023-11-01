package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description="Meeting Point (Request)")
public class MeetingPointRequestDto {

    @Schema(description="Latitud")
    private BigDecimal latitude;
    @Schema(description="Longitud")
    private BigDecimal longitude;

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
