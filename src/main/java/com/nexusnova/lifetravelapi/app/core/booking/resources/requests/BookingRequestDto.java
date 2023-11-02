package com.nexusnova.lifetravelapi.app.core.booking.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Booking (Request)")
public class BookingRequestDto {

    @Schema(description="Id del Tour Experience")
    private Long tourExperienceId;
    @Schema(description="Id del Turista")
    private String touristId;

    public Long getTourExperienceId() {
        return tourExperienceId;
    }

    public void setTourExperienceId(Long tourExperienceId) {
        this.tourExperienceId = tourExperienceId;
    }

    public String getTouristId() {
        return touristId;
    }

    public void setTouristId(String touristId) {
        this.touristId = touristId;
    }
}
