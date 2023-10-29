package com.nexusnova.lifetravelapi.app.core.tours.resources.summaries;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Actividad (Summary)")
public class ActivitySummaryDto {

    @ApiModelProperty("Id del Usuario")
    private String id;
    @ApiModelProperty("Titulo de la actividad")
    private String title;
    @ApiModelProperty("Url de la imagens")
    private String imgUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
