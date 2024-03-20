package com.example.api.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Etudiant extends  AbstractEntity implements UserDetails {
    @Column(name = "nom",nullable = false)
    private String nom;
    @Column(name = "prenom",nullable = false)
    private String prenom;
    @Column(name = "dateNais",nullable = false)
    private LocalDate dateNais;
    @Column(name = "phone",nullable = false,unique = true)
    private String phone;
    @Column(name = "gender",nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "photo", nullable = false)
    private String photo;
    @Column(name = "motDePasse",nullable = false)
    private String motDePasse;
    @ManyToOne
    @JoinColumn(name = "idDomainEtude")
    private DomainEtude domainEtudeEtud;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("Etudiant"));
    }

    @Override
    public String getPassword() {
        return this.motDePasse;
    }

    @Override
    public String getUsername() {
        return this.phone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
