package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Schedule (Request)")
public class ScheduleDto {

    @Schema(description="Dia")
    private String day;
    @Schema(description="Rango de Hora")
    private HourRangeDto hourRange;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public HourRangeDto getHourRange() {
        return hourRange;
    }

    public void setHourRange(HourRangeDto hourRange) {
        this.hourRange = hourRange;
    }
}
