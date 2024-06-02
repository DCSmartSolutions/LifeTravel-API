package com.nexusnova.lifetravelapi.app.assets.domain.model;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Region;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Region region;
    private double value;
    private LocalDateTime measuredAt;
}
