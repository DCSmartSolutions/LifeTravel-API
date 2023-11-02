package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Activity (Request)")
public class ActivityRequestDto {

    @Schema(description="Id de la actividad")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
