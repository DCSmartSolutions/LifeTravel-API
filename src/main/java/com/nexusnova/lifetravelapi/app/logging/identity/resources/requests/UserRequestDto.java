package com.nexusnova.lifetravelapi.app.logging.identity.resources.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Usuario (Request)")
public class UserRequestDto {
    @ApiModelProperty("Id del Usuario")
    private String id;
    @ApiModelProperty("Nombre del Usuario")
    private String name;
    @ApiModelProperty("Email del Usuario")
    private String email;
    @ApiModelProperty("Url de la foto del Usuario")
    private String photoUrl;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
