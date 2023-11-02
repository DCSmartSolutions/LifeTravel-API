package com.nexusnova.lifetravelapi.app.core.tours.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexusnova.lifetravelapi.app.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "destinations")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE destinations SET _deleted = true WHERE id = ?")
public class Destination extends AuditModel {

    @Column(name = "latitude", columnDefinition = "decimal(5,10)")
    private BigDecimal latitude;

    @Column(name = "longitude", columnDefinition = "decimal(5,10)")
    private BigDecimal longitude;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tour_package_id", nullable = false)
    @JsonIgnore
    private TourPackage tourPackage;

}
