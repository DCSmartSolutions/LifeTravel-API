package com.nexusnova.lifetravelapi.app.logging.identity.resources.summaries;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Usuario (Summary)")
public class UserSummaryDto {
    @ApiModelProperty("Id del Usuario")
    private String id;
    @ApiModelProperty("Nombre del Usuario")
    private String name;
    @ApiModelProperty("Role")
    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
