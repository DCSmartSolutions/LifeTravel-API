package com.nexusnova.lifetravelapi.app.core.booking.resources.summaries;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;

@Schema(description="Booking (Summary)")
public class BookingSummaryDto {

    @Schema(description="Id del Booking")
    private Long id;
    @Schema(description="Id del Tour")
    private Long tourPackageId;
    @Schema(description="Fecha de Tour")
    private Date tourExperienceDate;
    @Schema(description="Titutlo de TourPackage")
    private String tourPackageTitle;
    @Schema(description="Nombre de Agencia")
    private String agencyName;
    @Schema(description="Imagen de Tour Package")
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTourPackageId() {
        return tourPackageId;
    }

    public void setTourPackageId(Long tourPackageId) {
        this.tourPackageId = tourPackageId;
    }

    public Date getTourExperienceDate() {
        return tourExperienceDate;
    }

    public void setTourExperienceDate(Date tourExperienceDate) {
        this.tourExperienceDate = tourExperienceDate;
    }

    public String getTourPackageTitle() {
        return tourPackageTitle;
    }

    public void setTourPackageTitle(String tourPackageTitle) {
        this.tourPackageTitle = tourPackageTitle;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
