package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Activity (Request)")
public class ActivityRequestDto {

    @ApiModelProperty("Id de la actividad")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
