package com.nexusnova.lifetravelapi.app.core.tours.resources.details;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

@ApiModel("TourPackage (Detail)")
public class TourPackageDetailDto {

    @ApiModelProperty("Id del paquete")
    private Long id;
    @ApiModelProperty("Nombre del Usuario")
    private String title;
    @ApiModelProperty("Nombre del departamento")
    private String departmentName;
    @ApiModelProperty("Nombre del Usuario")
    private String description;
    @ApiModelProperty("Nombre del Usuario")
    private String imgUrl;
    @ApiModelProperty("Rating")
    private Float rating;
    @ApiModelProperty("Latitud de encuentro")
    private BigDecimal meetintPointLatitude;
    @ApiModelProperty("Longitud de encuentro")
    private BigDecimal meetintPointLongitude;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public BigDecimal getMeetintPointLatitude() {
        return meetintPointLatitude;
    }

    public void setMeetintPointLatitude(BigDecimal meetintPointLatitude) {
        this.meetintPointLatitude = meetintPointLatitude;
    }

    public BigDecimal getMeetintPointLongitude() {
        return meetintPointLongitude;
    }

    public void setMeetintPointLongitude(BigDecimal meetintPointLongitude) {
        this.meetintPointLongitude = meetintPointLongitude;
    }
}
