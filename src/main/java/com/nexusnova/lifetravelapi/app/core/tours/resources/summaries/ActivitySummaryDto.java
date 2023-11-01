package com.nexusnova.lifetravelapi.app.core.tours.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description="Actividad (Summary)")
public class ActivitySummaryDto {

    @Schema(description="Id del Usuario")
    private String id;
    @Schema(description="Titulo de la actividad")
    private String title;
    @Schema(description="Url de la imagens")
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
