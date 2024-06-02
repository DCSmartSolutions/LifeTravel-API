package com.nexusnova.lifetravelapi.app.assets.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Region;
import com.nexusnova.lifetravelapi.app.shared.domain.model.AuditModel;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "temperatures")
public class Temperature extends AuditModel {
    /*
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "region_id")
    @JsonIgnore
    private Region region;
     */
    @Column(nullable = false)
    private double value;
    @Column(nullable = false)
    private Date measuredAt;
}
