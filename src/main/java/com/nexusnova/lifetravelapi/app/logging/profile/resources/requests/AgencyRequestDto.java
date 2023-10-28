package com.nexusnova.lifetravelapi.app.logging.profile.resources.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Agency (Request)")
public class AgencyRequestDto {
    @ApiModelProperty("Id del Usuario")
    private String id;
    @ApiModelProperty("Nombre del Usuario")
    private String legalName;
    @ApiModelProperty("RUC de la agencia")
    private Long RUC;
    @ApiModelProperty("Direccion de la agencia")
    private String address;
    @ApiModelProperty("Decripcion de la agencia")
    private String description;
    @ApiModelProperty("nUmero de telefono")
    private String phoneNumber;
    @ApiModelProperty("Pagina Web")
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