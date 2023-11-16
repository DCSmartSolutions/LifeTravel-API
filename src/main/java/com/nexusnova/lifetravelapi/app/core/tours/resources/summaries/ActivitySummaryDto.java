package com.nexusnova.lifetravelapi.app.core.tours.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description="Actividad (Summary)")
public class ActivitySummaryDto {

    @Schema(description="Id del Usuario")
    private String id;
    @Schema(description="Titulo de la actividad")
    private String title;
    @Schema(description="Url de la imagens")
    private String imgUrl;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
