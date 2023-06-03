package com.simplejavaapipomodoro.entities;

import com.simplejavaapipomodoro.DTO.UserRequestDTO;
import com.simplejavaapipomodoro.constants.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "nick_name")
})
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
    @Email
    @Column(length = 50)
    private String email;
    @NotBlank
    @Column(name = "nick_name", length = 20)
    private String nickName;
    @NotBlank
    private String password;
    @NotBlank
    @Column(name = "birth_date")
    private String birthDate;
    private Gender gender;
    @Column(name = "creation_date", updatable = false)
    private LocalDateTime creationDate;

    public User(UserRequestDTO userRequestDTO){
        this.id = userRequestDTO.id();
        this.firstName = userRequestDTO.firstName();
        this.lastName = userRequestDTO.lastName();
        this.nickName = userRequestDTO.nickName();
        this.email = userRequestDTO.email();
        this.password = userRequestDTO.password();
        this.birthDate = userRequestDTO.birthDate();
        this.gender = userRequestDTO.gender();
        this.creationDate = LocalDateTime.now();
    }
}
