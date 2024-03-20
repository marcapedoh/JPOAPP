package com.example.api.Auth;


import com.example.api.models.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {
    private String nom;
    private String prenom;
    private LocalDate dateNais;
    private String photo;
    private String phone;
    private Gender gender;
    private String motDePasse;
}
