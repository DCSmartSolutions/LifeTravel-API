package com.nexusnova.lifetravelapi.app.core.booking.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourExperience;
import com.nexusnova.lifetravelapi.app.IAM.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "bookings")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE bookings SET _deleted = true WHERE id = ?")
public class Booking extends AuditModel {

    @Formula("concat(serie,'-', number)")
    private String serieNumber;

    @Column(name = "serie")
    private String serie;

    @Column(name = "number")
    private String number;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tourist_id", nullable = false)
    @JsonIgnore
    private Tourist tourist;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tourist_user_id", nullable = false)
    @JsonIgnore
    private User touristUser;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tour_experience_id", nullable = false)
    @JsonIgnore
    private TourExperience tourExperience;

    @Column(name = "date")
    private Date date;
}
