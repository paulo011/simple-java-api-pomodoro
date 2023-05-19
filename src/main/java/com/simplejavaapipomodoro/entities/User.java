package com.simplejavaapipomodoro.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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
    private String firstName;
    private String lastName;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String dateOfBirth;
}
