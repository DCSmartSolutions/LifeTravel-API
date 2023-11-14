package com.nexusnova.lifetravelapi.app.core.tours.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexusnova.lifetravelapi.app.IOT.domain.model.TrackingWearable;
import com.nexusnova.lifetravelapi.app.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tour_experience")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE tour_experience SET _deleted = true WHERE id = ?")
public class TourExperience extends AuditModel {

    @Column(name = "start_time")
    private String day;

    @Column(name = "start_hour")
    private String startHour;

    @Column(name = "start_minute")
    private String startMinute;

    @Column(name = "start_day_time")
    private String startDayTime;

    @Column(name = "end_hour")
    private String endtHour;

    @Column(name = "end_minute")
    private String endMinute;

    @Column(name = "end_day_time")
    private String endDayTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tour_package_id", nullable = false)
    @JsonIgnore
    private TourPackage tourPackage;

    @OneToMany(mappedBy = "tourExperience", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<TrackingWearable> bookings = new ArrayList<>();

}
