package com.nexusnova.lifetravelapi.app.logging.profile.resources.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("Tourist (Request)")
public class TouristRequestDto {
    @ApiModelProperty("Id del Usuario")
    private String id;
    @ApiModelProperty("Nombre del Usuario")
    private String name;
    @ApiModelProperty("Fecha de nacimiento")
    private Date birthDate;
    @ApiModelProperty("Numero de telefono")
    private String phoneNumber;
    @ApiModelProperty("Telefono de emergencia")
    private String emergencyPhoneNumber;

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

    public String getEmergencyPhoneNumber() {
        return emergencyPhoneNumber;
    }

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }
}