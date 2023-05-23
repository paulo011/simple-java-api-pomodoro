package com.simplejavaapipomodoro.entities;

import com.simplejavaapipomodoro.constants.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(name = "first_name", length = 20)
    private String firstName;
    @Column(name = "last_name", length = 10)
    private String lastName;
    @NotBlank
    @Column(length = 50)
    private String email;
    @NotBlank
    @Column(name = "nick_name", length = 20)
    private String nickName;
    @NotBlank
    private String password;
    @NotBlank
    @Column(name = "birth_date")
    private Date birthDate;
    private Gender gender;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Session> sessions;
    @Column(name = "registration_date", insertable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
}
