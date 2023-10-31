package com.nexusnova.lifetravelapi.app.logging.identity.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "roles")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE roles SET _deleted = true WHERE id = ?")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

}
