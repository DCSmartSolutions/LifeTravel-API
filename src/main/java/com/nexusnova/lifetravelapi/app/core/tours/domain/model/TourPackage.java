package com.nexusnova.lifetravelapi.app.core.tours.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexusnova.lifetravelapi.app.logging.profile.domain.model.Agency;
import com.nexusnova.lifetravelapi.app.shared.domain.AuditModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.validation.constraints.Max;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tour_packages")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE tour_packages SET _deleted = true WHERE id = ?")
public class TourPackage extends AuditModel {


    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "visible")
    private boolean visible;

    @Column(name = "rating")
    @Max(5)
    private Integer rating;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "region_id", nullable = false)
    @JsonIgnore
    private Region region;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "agency_id", nullable = false)
    @JsonIgnore
    private Agency agency;

    @ManyToMany
    @JoinTable(name = "tour_package_activities",
            joinColumns = @JoinColumn(name = "tour_package_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private Set<Activity> activities;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tourPackage")
    private Set<Destination> destinations;
}
