package com.example.api.Auth;

import com.example.api.Config.JwtService;
import com.example.api.exceptions.EntityNotFoundException;
import com.example.api.models.Entreprise;
import com.example.api.models.Etudiant;
import com.example.api.reporitory.EntrepriseRepository;
import com.example.api.reporitory.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final JwtService jwtService;
    private final EtudiantRepository userRepository;
    private final EntrepriseRepository userRepository1;
    private final PasswordEncoder passwordEncoder;
    public AuthenticationResponse authenticate(AuthenticationRequestEtudiant request) {
        UserDetails user=userRepository.findEtudiantByPhone(request.getPhone()).orElseThrow(()-> new EntityNotFoundException("aucun utilisateur n'est trouvé!"));
        String jwtToken="";
        if(passwordEncoder.matches(request.getMotDePasse(),user.getPassword())){
            jwtToken=jwtService.generateToken(user);
        }
        UserDetails user1=userRepository.findEtudiantByPhone(request.getPhone()).orElseThrow(()-> new EntityNotFoundException("aucun utilisateur n'est trouvé!"));
        if(!StringUtils.hasLength(user1.getUsername())){
            log.warn("le username de ce utilisateur est nul");
        }
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse registerEtudiant(RegisterRequest request) {
        var user= Etudiant.builder()
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .dateNais(request.getDateNais())
                .phone(request.getPhone())
                .photo(request.getPhoto())
                .gender(request.getGender())
                .motDePasse(passwordEncoder.encode(request.getMotDePasse()))
                .build();
        log.warn("voici votre objet{}",user);
        userRepository.save(user);
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticateEntreprise(AuthenticationRequestEntreprise request) {
        UserDetails user=userRepository1.findEntrepriseByMail(request.getMail()).orElseThrow(()-> new EntityNotFoundException("aucune entreprise n'est trouvé!"));
        String jwtToken="";
        if(passwordEncoder.matches(request.getMotDePasse(),user.getPassword())){
            jwtToken=jwtService.generateToken(user);
        }
        UserDetails user1=userRepository1.findEntrepriseByMail(request.getMail()).orElseThrow(()-> new EntityNotFoundException("aucune entreprise n'est trouvé!"));
        if(!StringUtils.hasLength(user1.getUsername())){
            log.warn("le username de cette entreprise est nul");
        }
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerEntreprise(RegisterRequestEntreprise request) {
        var user= Entreprise.builder()
                .nom(request.getNom())
                .mail(request.getMail())
                .photo(request.getPhoto())
                .motDePasse(passwordEncoder.encode(request.getMotDePasse()))
                .build();
        log.warn("voici votre objet{}",user);
        userRepository1.save(user);
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}