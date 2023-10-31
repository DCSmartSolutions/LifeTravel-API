package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel("Meeting Point (Request)")
public class MeetingPointRequestDto {

    @ApiModelProperty("Latitud")
    private BigDecimal latitude;
    @ApiModelProperty("Longitud")
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
