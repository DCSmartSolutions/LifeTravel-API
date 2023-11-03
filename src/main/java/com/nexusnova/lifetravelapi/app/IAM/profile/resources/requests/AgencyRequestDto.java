package com.nexusnova.lifetravelapi.app.IAM.profile.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Agency (Request)")
public class AgencyRequestDto {
    @Schema(description="Id del Usuario")
    private String id;
    @Schema(description="Nombre del Usuario")
    private String legalName;
    @Schema(description="RUC de la agencia")
    private Long RUC;
    @Schema(description="Direccion de la agencia")
    private String address;
    @Schema(description="Decripcion de la agencia")
    private String description;
    @Schema(description="nUmero de telefono")
    private String phoneNumber;
    @Schema(description="Pagina Web")
    private String webPageUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public Long getRUC() {
        return RUC;
    }

    public void setRUC(Long RUC) {
        this.RUC = RUC;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebPageUrl() {
        return webPageUrl;
    }

    public void setWebPageUrl(String webPageUrl) {
        this.webPageUrl = webPageUrl;
    }
}