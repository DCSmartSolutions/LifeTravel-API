package com.nexusnova.lifetravelapi.app.core.tours.resources.details;

import com.nexusnova.lifetravelapi.app.core.booking.domain.services.BookingQueryService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(name = "TourPackage (Detail)")
public class TourPackageDetailDto {

    @Schema(name = "Id del paquete")
    private Long id;
    @Schema(name = "Nombre del Usuario")
    private String title;
    @Schema(name = "Nombre del departamento")
    private String departmentName;
    @Schema(name = "Nombre del Usuario")
    private String description;
    @Schema(name = "Nombre del Usuario")
    private String imgUrl;
    @Schema(name = "Rating")
    private Float rating;
    @Schema(name = "Id Agencia")
    private Long agencyId;
    @Schema(name = "Precio")
    private BigDecimal price;
    @Schema(name = "Id Region")
    private Long regionId;
    @Schema(name = "Visible")
    private Boolean visible;
    @Schema(name = "Latitud de encuentro")
    private BigDecimal meetingPointLatitude;
    @Schema(name = "Longitud de encuentro")
    private BigDecimal meetingPointLongitude;

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

    public BigDecimal getMeetingPointLatitude() {
        return meetingPointLatitude;
    }

    public void setMeetingPointLatitude(BigDecimal meetingPointLatitude) {
        this.meetingPointLatitude = meetingPointLatitude;
    }

    public BigDecimal getMeetingPointLongitude() {
        return meetingPointLongitude;
    }

    public void setMeetingPointLongitude(BigDecimal meetingPointLongitude) {
        this.meetingPointLongitude = meetingPointLongitude;
    }

    public Long getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
