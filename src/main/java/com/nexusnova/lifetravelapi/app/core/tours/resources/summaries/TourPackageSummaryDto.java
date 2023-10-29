package com.nexusnova.lifetravelapi.app.core.tours.resources.summaries;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel("Tour Packages (Summary)")
public class TourPackageSummaryDto {

    @ApiModelProperty("Id del Paquete")
    private String id;
    @ApiModelProperty("Titulo del Paquete")
    private String title;
    @ApiModelProperty("Departamento del Paquete")
    private String departmentName;
    @ApiModelProperty("Descripcion del Paquete")
    private String description;
    @ApiModelProperty("Precio del Paquete")
    private BigDecimal price;
    @ApiModelProperty("Rating del Paquete")
    private Float rating;
    @ApiModelProperty("Url de la imagen")
    private String imgUrl;
    @ApiModelProperty("Visible")
    private Boolean visible;

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
