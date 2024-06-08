package com.nexusnova.lifetravelapi.app.reporting.domain.model;

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
@Table(name = "reports")
public class Report extends AuditModel {
    @Column(name = "content")
    private String content;

    @ManyToMany
    @JoinTable(
            name = "report_tour_packages",
            joinColumns = @JoinColumn(name = "report_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_package_id")
    )
    private Set<Review> reviews;
}
