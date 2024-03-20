package com.example.api.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequestEntreprise {
    private String nom;
    private String mail;
    private String photo;
    private String motDePasse;
}
