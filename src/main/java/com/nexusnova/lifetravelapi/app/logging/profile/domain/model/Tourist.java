package com.nexusnova.lifetravelapi.app.logging.profile.domain.model;


import com.nexusnova.lifetravelapi.app.logging.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.shared.domain.AuditModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Date;

@Getter
@Setter
@With
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tourists")
@Where(clause = "_deleted = false")
@SQLDelete(sql = "UPDATE tourists SET _deleted = true WHERE id = ?")
public class Tourist extends AuditModel {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "emergency_phone_number")
    private String emergencyPhoneNumber;
}
