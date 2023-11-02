package com.nexusnova.lifetravelapi.app.logging.profile.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description="Tourist (Summary)")
public class TouristSummaryDto {

    @Schema(description="Id del Usuario")
    private String id;
    @Schema(description="Nombre del turista")
    private String name;
    @Schema(description="Fecha de Nacimiento del turista")
    private Date birthDate;
    @Schema(description="Numero de telefono del turista")
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
