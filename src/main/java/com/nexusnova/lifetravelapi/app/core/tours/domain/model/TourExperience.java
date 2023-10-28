package com.nexusnova.lifetravelapi.app.core.tours.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexusnova.lifetravelapi.app.shared.domain.AuditModel;
import jakarta.persistence.*;
import lombok.*;
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
@Table(name = "tour_experience")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE tour_experience SET _deleted = true WHERE id = ?")
public class TourExperience extends AuditModel {

    @Column(name = "start_date")
    private Date startDate;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "tour_package_id", nullable = false)
    @JsonIgnore
    private TourPackage tourPackage;

}
