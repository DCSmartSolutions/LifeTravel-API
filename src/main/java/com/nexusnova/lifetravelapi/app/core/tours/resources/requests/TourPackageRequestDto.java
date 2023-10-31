package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

@ApiModel("Tour Package (Request)")
public class TourPackageRequestDto {

    @ApiModelProperty("Id de Agencia")
    private String agencyId;
    @ApiModelProperty("Nombre del Usuario")
    private String title;
    @ApiModelProperty("Nombre del Usuario")
    private String description;
    @ApiModelProperty("Nombre del Usuario")
    private String imgUrl;
    @ApiModelProperty("Nombre del departamento")
    private String departmentName;
    @ApiModelProperty("Precio")
    private BigDecimal price;
    @ApiModelProperty("Punto de encuentro")
    private MeetingPointRequestDto meetingPoint;
    @ApiModelProperty("Lista de actividades")
    private List<ActivityRequestDto> activities;
    @ApiModelProperty("Punto de encuentro")
    private List<MeetingPointRequestDto> activitiesMeetingPoints;

    public String getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    public String getTitle() {
        return title;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public MeetingPointRequestDto getMeetingPoint() {
        return meetingPoint;
    }

    public void setMeetingPoint(MeetingPointRequestDto meetingPoint) {
        this.meetingPoint = meetingPoint;
    }

    public List<ActivityRequestDto> getActivities() {
        return activities;
    }

    public void setActivities(List<ActivityRequestDto> activities) {
        this.activities = activities;
    }

    public List<MeetingPointRequestDto> getActivitiesMeetingPoints() {
        return activitiesMeetingPoints;
    }

    public void setActivitiesMeetingPoints(List<MeetingPointRequestDto> activitiesMeetingPoints) {
        this.activitiesMeetingPoints = activitiesMeetingPoints;
    }
}
