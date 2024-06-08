package com.nexusnova.lifetravelapi.app.reporting.domain.model;

import com.nexusnova.lifetravelapi.app.core.booking.domain.model.Booking;
import com.nexusnova.lifetravelapi.app.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reviews")
public class Review extends AuditModel {
    @Column(name = "rating")
    private String rating;

    @Column(name = "information")
    private String information;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToMany(mappedBy = "reviews")
    private Set<Report> reports;
}
