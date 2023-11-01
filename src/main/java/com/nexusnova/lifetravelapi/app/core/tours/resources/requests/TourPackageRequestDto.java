package com.nexusnova.lifetravelapi.app.core.tours.resources.requests;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.List;

@Schema(description="Tour Package (Request)")
public class TourPackageRequestDto {

    @Schema(description="Id de Agencia")
    private String agencyId;
    @Schema(description="Nombre del Usuario")
    private String title;
    @Schema(description="Nombre del Usuario")
    private String description;
    @Schema(description="Nombre del Usuario")
    private String imgUrl;
    @Schema(description="Nombre del departamento")
    private String departmentName;
    @Schema(description="Precio")
    private BigDecimal price;
    @Schema(description="Punto de encuentro")
    private MeetingPointRequestDto meetingPoint;
    @Schema(description="Lista de actividades")
    private List<ActivityRequestDto> activities;
    @Schema(description="Punto de encuentro")
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
