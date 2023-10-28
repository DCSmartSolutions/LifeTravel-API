package com.nexusnova.lifetravelapi.app.logging.profile.resources.summaries;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("Tourist (Summary)")
public class TouristSummaryDto {

    @ApiModelProperty("Id del Usuario")
    private String id;
    @ApiModelProperty("Nombre del turista")
    private String name;
    @ApiModelProperty("Fecha de Nacimiento del turista")
    private Date birthDate;
    @ApiModelProperty("Numero de telefono del turista")
    private String phoneNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
